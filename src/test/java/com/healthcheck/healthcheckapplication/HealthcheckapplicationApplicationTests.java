package com.healthcheck.healthcheckapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthcheckapplicationApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void up() {
		Health health = new Health.Builder().up().build();
		//assertThat(health.getStatus()).isEqualTo(Status.UP);
		//assertThat(health.getDetails()).isEmpty();
	}

}
