package com.sumant.boot.learning;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest( classes = FeignURLBasedAPITest.FeignConfig.class)
@TestInstance(Lifecycle.PER_CLASS)
public class FeignURLBasedAPITest {

	public static WireMockServer wireMockServer;

	@Autowired
	public FeignURLBasedAPI client;

	@BeforeAll
	public void setup(){
		wireMockServer = new WireMockServer( options().port(8090));
		wireMockServer.start();
	}

	@Test
	public void testMockReturnsHello() {

		wireMockServer.stubFor( get ( urlPathMatching("/hello"))
				.willReturn(aResponse().withStatus(200).withBody("success")));

		String response = client.hello();

		assertThat(response, is("success"));

	}

	@EnableFeignClients(clients = FeignURLBasedAPI.class)
	@Configuration
	@EnableAutoConfiguration
	static class FeignConfig{

	}

}
