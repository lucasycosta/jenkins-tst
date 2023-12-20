
package com.testejar.testjarjenkins.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.binder.MeterBinder;

@RestController

@Component
public class PrometheusController implements MeterBinder {

	@Autowired
	private RootController controller;

	
	//private static MeterRegistry registry;
	
	//static final Counter counter = Counter.builder("test_counted").register(null);
	
	
	@Override
	@Counted(value = "tst.criar")
	@Timed(value = "tst.criar.timing")
	public void bindTo(MeterRegistry meterRegistry) {
		Gauge.builder("filmes_comprados", this, value -> obterQuantidadeFilmesComprados())
				.description("Quantidade de filmes comprados")
				.tags(Tags.of(Tag.of("data", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))))
				.baseUnit("KKKKKKKK").register(meterRegistry);
		
		Counter.builder("test_counted")
			   .description(null)
			   .register(meterRegistry);
	}

	public Integer obterQuantidadeFilmesComprados() {
		return new Random().nextInt(8);
	}
	
}
