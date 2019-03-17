package com.healthcheck.healthcheckapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class HealthcheckapplicationApplication implements HealthIndicator {

	Runtime runtime = Runtime.getRuntime();
	Process process = runtime.exec("git rev-parse HEAD");
	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	String revision = reader.readLine();

	@Value("${info.app.version}")
	String version ;

	public HealthcheckapplicationApplication() throws IOException {
	}

	@Override
	public Health health() {
		try {
			return new Health.Builder().up().withDetail("version", version)
					.withDetail("description", "pre-interview technical test")
					.withDetail("lastcommitsha",revision)
					.build();
		} catch (Exception ex) {
			return new Health.Builder().down(ex).build();
		}
	}
	public static void main(String[] args) {

		SpringApplication.run(HealthcheckapplicationApplication.class, args);
	}

}
