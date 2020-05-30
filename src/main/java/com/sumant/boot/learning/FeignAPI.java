package com.sumant.boot.learning;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test")
public interface FeignAPI {

	@RequestMapping(value = "hello")
	String hello();

}
