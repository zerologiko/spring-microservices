package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		Map <String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		//BASIC call another microservice using REST and a direct URL (will be replaced by Feign Client)
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariable);
		CurrencyConversionBean resp = responseEntity.getBody();

		CurrencyConversionBean result = new CurrencyConversionBean(resp.getId(),resp.getFrom(), resp.getTo(), resp.getConversionMultiple(), quantity, quantity.multiply(resp.getConversionMultiple()));
		result.setPort(resp.getPort());

		// Just log something to see if Sleuth is setting unique identifier
		logger.info("{}", result);

		return result;
	}

	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		CurrencyConversionBean resp = currencyExchangeProxy.retrieveExchangeValue(from, to);

		CurrencyConversionBean result = new CurrencyConversionBean(resp.getId(),resp.getFrom(), resp.getTo(), resp.getConversionMultiple(), quantity, quantity.multiply(resp.getConversionMultiple()));
		result.setPort(resp.getPort());

		return result;
	}

}
