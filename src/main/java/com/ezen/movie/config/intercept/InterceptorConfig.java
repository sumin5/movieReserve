package com.ezen.movie.config.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    String [] excludePattern = {"/assets/**","/img/**"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.loginInterceptor())
                .order(1)
                .addPathPatterns("/reserve/**","/myPage/**")
                .excludePathPatterns(excludePattern);



    }
}
