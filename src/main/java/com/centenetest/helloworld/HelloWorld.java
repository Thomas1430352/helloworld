package com.centenetest.helloworld;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

public class HelloWorld {
    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("example-tracer");

    public static void main(String[] args) {
        Span span = tracer.spanBuilder("my-span").startSpan();
        try (Scope scope = span.makeCurrent()) {
            System.out.println("Hello, World!");
        } finally {
            span.end();
        }
    }
}

