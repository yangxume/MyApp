package com.xy.retrofit.net.interceptor;

import java.util.UUID;

public class RequestIdGenerator {

    public RequestIdGenerator() {
    }

    public static String newRequestId() {
        return String.format("03%010d", Math.abs(UUID.randomUUID().hashCode()));
    }

}
