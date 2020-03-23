package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversionBean;

// This will enable direct call to currency-exchange-service without API Gateway
// @FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// Feign: just tell service name and URI and the client is done.
	// the proxy take the name of the service and use Eureka naming server to call it.
	// No URL of currency-exchange-service are hardcoded in the application

	// Without API gateway, directly to currency-exchange-service
	// @GetMapping("currency-exchange/from/{from}/to/{to}")

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
