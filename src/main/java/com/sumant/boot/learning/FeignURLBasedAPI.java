package com.sumant.boot.learning;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test", url = "http://localhost:8090")
public interface FeignURLBasedAPI {

	@RequestMapping(value = "hello")
	String hello();

}
