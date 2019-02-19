package com.coutries.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    static CountryList countryList;
    public static void main(String[] args) {
        System.out.println();
        countryList = new CountryList();
        SpringApplication.run(DemoApplication.class, args);
    }


}
