package com.tienda;


import java.util.Locale;
import org.springframework.context.MessageSource;

 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

 

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

 

@Configuration
public class projectconfig implements WebMvcConfigurer{

    // Los siguientes metodos se utilizan para incorporar la tematica de internacionalizacion

    // localeResolver se utiliza para gestionar el cambio de idioma

    // @Bean es una forma de crear un objeto omnipresente en la clase... sin tener que hacer new

    @Bean
    public LocaleResolver localeResolver(){

        var slr = new SessionLocaleResolver();

        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");


        return slr;
    }
    @Bean
    public LocaleChangeInterceptor localChangeInterceptor(){
     var lci = new LocaleChangeInterceptor();
     lci.setParamName("lang");

     return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localChangeInterceptor());
    };

    @Bean("messageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }

}