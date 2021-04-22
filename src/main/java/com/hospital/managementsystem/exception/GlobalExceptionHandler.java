package com.hospital.managementsystem.exception;

import com.google.common.base.Strings;
import com.hospital.managementsystem.controller.BaseController;
import com.hospital.managementsystem.domin.upload.XGuard;
import com.hospital.managementsystem.enums.Status;
import net.sf.oval.exception.ConstraintsViolatedException;
import net.sf.oval.exception.ValidationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/7 8:19 下午
 * @Version: 1.0
 */
@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({Exception.class})
    public Object handleException(Exception e) {
        log.error("Catch Exception, message={}, {}", e.getMessage(), e);

        return error(Status.UNKNOWN_ERROR.getCode(), Status.UNKNOWN_ERROR.getMsg());

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("Catch HttpRequestMethodNotSupportedException, message={}", e.getMessage(), e);
        return error(Status.UN_SUPPORT_HTTP_METHOD_HEADER.getCode(), Status.UN_SUPPORT_HTTP_METHOD_HEADER.getMsg());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("Catch HttpMediaTypeNotSupportedException, message={}, {}", e.getMessage(), e);

        return error(Status.UN_SUPPORT_MEDIA_TYPE_HEADER.getCode(), Status.UN_SUPPORT_MEDIA_TYPE_HEADER.getMsg());
    }

    @ExceptionHandler({AuthException.class})
    public Object handleException(AuthException e) {
        log.error("Catch AuthException, message={}, {}", e.getMessage(), e);

        return error(e.hashCode(), e.getMessage());

    }

//    @ExceptionHandler({NoSuchIndexException.class, UncategorizedElasticsearchException.class})
//    public Object handleElasticSearchException(Exception e) {
//        log.error("Catch ElasticsearchException, message={}, {}", e.getMessage(), e);
//
//        if (e instanceof NoSuchIndexException) {
//            return success();
//        } else {
//            return error(Status.INDEX_FIELD_UN_CATEGORIZED_ERROR.getCode(), Status.INDEX_FIELD_UN_CATEGORIZED_ERROR.getMsg());
//        }
//
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class,ConstraintsViolatedException.class,
            MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class, ValidationFailedException.class})
    public Object constraintsViolatedException(Exception e) {

        log.warn("Catch paramValidateException, message={}, {}", new Object[]{e.getMessage(), e});
        String message = messageExtractor.apply(e);
        if (Strings.isNullOrEmpty(message)) {
            message = Status.REQUEST_PARAMS_NOT_VALID_ERROR.getMsg();
        }

        return error(Status.REQUEST_PARAMS_NOT_VALID_ERROR.getCode(), message);

    }

    @ExceptionHandler({BusinessException.class})
    public Object handleBusinessException(BusinessException e) {
        log.warn("Catch BusinessException, message={}, {}", e.getMessage(), e);
        return error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({ParamValidException.class})
    public Object handleParamValidateException(ParamValidException e) {
        log.warn("Catch paramValidateException, message={}", new Object[]{e.getMessage(), e});
        return error(e.getCode(), e.getMessage());

    }

    @Autowired
    private XGuard xGuard;

    private Function<Exception, String> messageExtractor = this::extractReadableMessage;
    private String extractReadableMessage(Exception e) {

        BindingResult bindingResult = null;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        } else if (e instanceof MissingServletRequestParameterException) {
            return String.format("参数%s必填", ((MissingServletRequestParameterException) e).getParameterName());
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            return String.format("参数%s类型不正确", ((MethodArgumentTypeMismatchException) e).getName());
        } else if (e instanceof HttpMessageNotReadableException) {
            return "参数类型不正确";
        } else if (e instanceof ValidationFailedException) {
            return "请检查参数";
        } else {
            if (!(e instanceof MethodArgumentNotValidException)) {
                if (e instanceof ConstraintsViolatedException) {
                    return xGuard.apply((ConstraintsViolatedException) e);
                }

                return e.getLocalizedMessage();
            }

            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();

        }

        List<FieldError> errorList = bindingResult.getFieldErrors();
        if (null != errorList && !errorList.isEmpty()) {

            Function<FieldError, String> messageConvert = fieldError -> String.format("参数%s的值不合法", fieldError.getField());
            return errorList.stream().map(messageConvert).collect(Collectors.joining(";"));
        }

        return EMPTY;
    }

    private static final String EMPTY = "";

}
