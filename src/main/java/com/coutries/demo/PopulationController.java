package com.coutries.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// /population
@RestController
@RequestMapping("/population")
public class PopulationController {

    @RequestMapping("/size")
    public ArrayList<Country> getPopGreater(@RequestParam(value = "people") double people){
        return DemoApplication.countryList.findCountry(c -> c.getPopulation() >= people);
    }

    @RequestMapping("/min")
    public Country getMinPop(){
        Country minPop = DemoApplication.countryList.countryList.get(0);
        for(Country c : DemoApplication.countryList.countryList){
            if(c.getPopulation() < minPop.getPopulation()){
                minPop = c;
            }
        }

        return minPop;
    }

    @RequestMapping("/max")
    public Country getMaxPop(){
        Country maxPop = DemoApplication.countryList.countryList.get(1);
        for(Country c : DemoApplication.countryList.countryList){
            if(c.getPopulation() > maxPop.getPopulation()){
                maxPop = c;
            }
        }

        return maxPop;
    }
}
