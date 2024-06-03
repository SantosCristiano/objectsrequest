package br.com.diebold.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import okhttp3.OkHttpClient;

@Configuration
public class TotvsConfiguration {
	
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
	
    @Bean
    Logger.Level feignLoggerlevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("integra", "integra");
    }
}
