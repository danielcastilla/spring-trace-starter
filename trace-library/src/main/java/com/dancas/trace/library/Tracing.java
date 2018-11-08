package com.dancas.trace.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;

public class Tracing {

    private TracerConfig tracerConfig;

    public Tracing(TracerConfig tracerConfig){
        this.tracerConfig = tracerConfig;
    }

    public String trace(){
        return "pasa";
    }


    public void createTrace(Tracer tracer, String tag, String method){

        Span newSpan = tracer.createSpan(method);
        tracer.addTag("uno", tag);
        newSpan.logEvent("class");
        tracer.close(newSpan);

    }
}
