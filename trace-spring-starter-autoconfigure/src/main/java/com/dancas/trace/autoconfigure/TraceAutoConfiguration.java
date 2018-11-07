package com.dancas.trace.autoconfigure;


import com.dancas.trace.library.Tracer;
import com.dancas.trace.library.TracerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Tracer.class)
@EnableConfigurationProperties(TraceProperties.class)
public class TraceAutoConfiguration {

    @Autowired
    private TraceProperties traceProperties;

    @Bean
    @ConditionalOnMissingBean
    public Tracer tracer(TracerConfig tracerConfig){
        return new Tracer(tracerConfig);
    }

}
