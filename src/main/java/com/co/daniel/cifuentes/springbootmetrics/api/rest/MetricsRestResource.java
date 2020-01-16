package com.co.daniel.cifuentes.springbootmetrics.api.rest;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/service")
public class MetricsRestResource {

    @Autowired
    MeterRegistry registry;

    @GetMapping(path = "/sleep")
    public ResponseEntity<String> sleepRandomTime() throws InterruptedException {

        Double ran = Math.random() * 1000;
        Thread.sleep((ran.longValue()));
        return new ResponseEntity<>(ran.toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/heap/{value}")
    public ResponseEntity<String> heap( @PathVariable("value") Integer value) {

        String heap = "";
        for(int i = 0; i<=value; i++){
            heap = heap + i +" ";
        }

        return new ResponseEntity<>("OK", HttpStatus.OK);

    }

    @GetMapping(path = "/counter1")
    public ResponseEntity<String> count1(){
        registry.counter("dc.total.request", "name", "counter1").increment();
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(path = "/counter2")
    public ResponseEntity<String> count2(){
        registry.counter("dc.total.request", "name","counter2").increment();
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
