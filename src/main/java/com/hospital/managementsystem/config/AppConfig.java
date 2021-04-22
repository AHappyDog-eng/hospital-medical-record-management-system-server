package com.hospital.managementsystem.config;

import com.hospital.managementsystem.domin.upload.XGuard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ning.wang
 * @date 2021/3/22 19:44
 */
@Configuration
public class AppConfig {

    @Bean
    public XGuard xGuard() {
        return new XGuard();
    }

}
