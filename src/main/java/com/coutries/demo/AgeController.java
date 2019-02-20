package com.coutries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {

    @RequestMapping("/age")
    public ArrayList<Country> getGreaterAge(@RequestParam(value = "age") double age){
        return DemoApplication.countryList.findCountry(c -> c.getMedAge() >= age);
    }

    @RequestMapping("/min")
    public Country getMinAge(){
        DemoApplication.countryList.countryList.sort((c1, c2) -> ((int)(c1.getMedAge() - c2.getMedAge())));
        return DemoApplication.countryList.countryList.get(0);
    }

    @RequestMapping("/max")
    public Country getMaxAge(){
        DemoApplication.countryList.countryList.sort((c1, c2) -> ((int)(c2.getMedAge() - c1.getMedAge())));
        return DemoApplication.countryList.countryList.get(0);
    }
}
