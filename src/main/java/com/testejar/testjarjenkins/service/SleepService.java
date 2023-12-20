package com.testejar.testjarjenkins.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.observation.annotation.Observed;

@Service
public class SleepService {
	
	@Timed(value = "do.sleep.method.timed")
	@Observed(name = "do.sleep.method.timed", contextualName = "do-sleep-method-span", lowCardinalityKeyValues = {"low", "low"})
	public Long doSleep(Long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return ms;
	}
}
