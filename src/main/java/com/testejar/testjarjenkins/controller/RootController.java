package com.testejar.testjarjenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testejar.testjarjenkins.service.RootService;
import com.testejar.testjarjenkins.service.SleepService;

@RestController
@RequestMapping
public class RootController{
	
	@Autowired
	private SleepService service;
	
	@Autowired
	private RootService rService;

	@GetMapping(value = "/time")
	public Long time(@RequestParam Long ms) throws Exception {
		Long result = this.service.doSleep(ms);
		return result;
	}
	
	@GetMapping(value = "/hello")
	public String hello() {
		return rService.hello();
	}
	
	/*
	//actuator
	public static void main(String[] args) throws InterruptedException, IOException{
		JvmMetrics.builder().register(); // initialize the out-of-the-box JVM metrics

        Counter counter = Counter.builder()
                .name("my_count_total")
                .help("example counter")
                .labelNames("status")
                .register();

        counter.labelValues("ok").inc();
        counter.labelValues("ok").inc();
        counter.labelValues("error").inc();

        HTTPServer server = HTTPServer.builder()
                .port(9400)
                .buildAndStart();

        System.out.println("HTTPServer listening on port http://localhost:" + server.getPort() + "/metrics");

        Thread.currentThread().join();
	}
	*/

}
