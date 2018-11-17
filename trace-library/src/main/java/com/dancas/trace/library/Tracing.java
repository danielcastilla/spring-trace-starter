package com.dancas.trace.library;


import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;


public class Tracing {

    private TracerConfig tracerConfig;

    public Tracing(TracerConfig tracerConfig){
        this.tracerConfig = tracerConfig;
    }

    public String trace(){
        return "pasa";
    }


    public void createTrace(Tracer tracer, String tag, String method){

        Span newSpan = tracer.nextSpan().name("calculateTax");
        tracer.withSpanInScope(newSpan.start());

            newSpan.tag("taxValue", method);

            newSpan.annotate("methodEventLog");

            newSpan.finish();
        }

}
