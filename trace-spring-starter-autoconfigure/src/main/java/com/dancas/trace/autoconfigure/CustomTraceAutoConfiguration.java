package com.dancas.trace.autoconfigure;


import com.dancas.trace.library.TracerConfig;
import com.dancas.trace.library.Tracing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Tracing.class)
@EnableConfigurationProperties(TraceProperties.class)
public class CustomTraceAutoConfiguration {

    @Autowired
    private TraceProperties traceProperties;

    @Bean
    @ConditionalOnMissingBean
    public TracerConfig tracerConfig(){
        TracerConfig tracerConfig = new TracerConfig();
        return tracerConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Tracing tracing(TracerConfig tracerConfig){
        return new Tracing(tracerConfig);
    }

}
