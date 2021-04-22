package com.hospital.managementsystem.domin.upload;

import com.hospital.managementsystem.common.Constants;
import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.constraint.AssertValid;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.MethodParameterContext;
import net.sf.oval.exception.ConstraintsViolatedException;
import net.sf.oval.guard.Guard;
import net.sf.oval.internal.util.Invocable;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;


/**
 * @ClassName: XGuard
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/12 7:04 下午
 * @Version: 1.0
 */
@Slf4j
public class XGuard extends Guard implements Function<ConstraintsViolatedException, String> {

    private ThreadLocal<Set<String>> tempEnableProfiles = ThreadLocal.withInitial(()->new HashSet<>());

    {
        this.disableAllProfiles();
        this.enableProfile("default");
    }

    @Override
    protected Object guardMethod(Object guardedObject, Method method, Object[] args, Invocable invocable) throws Throwable {

        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            AssertValid annotation = parameter.getAnnotation(AssertValid.class);
            if (annotation == null) {
                continue;
            }
            String[] profiles = annotation.profiles();
            if (profiles.length == 0) {
                continue;
            }
            for (String profile : profiles) {
                this.enableProfile(profile);
                tempEnableProfiles.get().add(profile);
            }
        }
        try {
            return super.guardMethod(guardedObject, method, args, invocable);
        } finally {
            tempEnableProfiles.get().forEach(p->this.disableProfile(p));
        }

    }

    @Override
    public String apply(ConstraintsViolatedException cve) {

        String msg = cve.getLocalizedMessage();
        ConstraintViolation[] constraintViolations = cve.getConstraintViolations();
        if (constraintViolations != null && constraintViolations.length > 0) {
            ConstraintViolation cv = constraintViolations[0];
            Object invalidValue = cv.getInvalidValue();
            String errorCode = cv.getErrorCode();
            if (errorCode.endsWith(Constants.ASSERT_VALID)) {
                try {
                    tempEnableProfiles.get().forEach(p->this.enableProfile(p));
                    this.assertValid(invalidValue);
                } catch (ConstraintsViolatedException e1) {
                    return apply(e1);
                } finally {
                    tempEnableProfiles.get().forEach(p->this.disableProfile(p));
                }
            }

            if (cv.getContext() instanceof MethodParameterContext) {
                MethodParameterContext context = (MethodParameterContext) cv.getContext();
                StringBuffer point = new StringBuffer(context.getMethod().getDeclaringClass().getName()).append(":")
                        .append(context.getMethod().getName()).append(" ")
                        .append(context.getParameterName());
                log.error(point.append(" -> ").append(msg).toString());
            } else {
                FieldContext context = (FieldContext) cv.getContext();
                StringBuffer point = new StringBuffer(context.getField().getDeclaringClass().getName()).append(".")
                        .append(context.getField().getName());
                log.error(point.append(" -> ").append(msg).toString());

            }
        }

        return msg;
    }
}
