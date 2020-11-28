package com.moduscreate.stockmarket;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class StockOperationDeserializer extends ObjectMapperDeserializer<StockOperation> {

    public StockOperationDeserializer() {
        super(StockOperation.class);
    }

}
