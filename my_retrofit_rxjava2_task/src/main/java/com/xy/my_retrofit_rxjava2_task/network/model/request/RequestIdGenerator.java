package com.xy.my_retrofit_rxjava2_task.network.model.request;

import java.util.UUID;

public class RequestIdGenerator {

    public RequestIdGenerator() {
    }

    public static String newRequestId() {
        return String.format("03%010d", Math.abs(UUID.randomUUID().hashCode()));
    }
}
