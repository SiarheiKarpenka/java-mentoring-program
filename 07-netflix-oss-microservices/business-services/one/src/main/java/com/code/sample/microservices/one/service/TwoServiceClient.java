package com.code.sample.microservices.one.service;


import com.code.sample.microservices.two.TwoServiceAPI;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "two")
public interface TwoServiceClient extends TwoServiceAPI {
}
