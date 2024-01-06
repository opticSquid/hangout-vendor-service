package com.hangout.core.vendorservice.config;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

// Example of plugging in a custom handler that in this case will print a statement before and after all observations take place
@Component
@Slf4j
public class ObservationLogHandler implements ObservationHandler<Observation.Context> {

    @Override
    public void onStart(Observation.Context context) {
        log.info("Before running the observation for context [{}], pageNumber [{}]", context.getName(), getPageNumber(context));
    }

    @Override
    public void onStop(Observation.Context context) {
        log.info("After running the observation for context [{}], pageNumber [{}]", context.getName(), getPageNumber(context));
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    private String getPageNumber(Observation.Context context) {
        return StreamSupport.stream(context.getLowCardinalityKeyValues().spliterator(), false).filter(keyValue -> "pageNumber".equals(keyValue.getKey())).map(KeyValue::getValue).findFirst().orElse("UNKNOWN");

}
