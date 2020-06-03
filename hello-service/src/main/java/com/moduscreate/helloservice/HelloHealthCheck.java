package com.moduscreate.helloservice;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class HelloHealthCheck implements HealthCheck {

    static boolean respondWithError = false;

    @Override
    public HealthCheckResponse call() {
        if (respondWithError) {
            return HealthCheckResponse.down("server is down");
        } else {
            return HealthCheckResponse.up("server is up");
        }
    }

}