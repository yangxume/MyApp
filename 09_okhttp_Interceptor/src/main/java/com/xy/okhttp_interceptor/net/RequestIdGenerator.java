package com.xy.okhttp_interceptor.net;

import java.util.UUID;

public class RequestIdGenerator {

    public RequestIdGenerator() {
    }

    public static String newRequestId() {
        return String.format("03%010d", Math.abs(UUID.randomUUID().hashCode()));
    }

}
