package com.coutries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// /names
@RestController
@RequestMapping("/names")
public class NamesController {

    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries(){
        DemoApplication.countryList.countryList.sort((c1, c2) ->
                c1.getName().compareToIgnoreCase(c2.getName()));
        return DemoApplication.countryList.countryList;
    }
// /names/begin?letter=
    @RequestMapping("/begin")
    public ArrayList<Country> getAllBeginWith(
            @RequestParam(value = "letter") String firstLetter){
        return DemoApplication.countryList.findCountry(c -> String.valueOf(c.getName().charAt(0)).equals(firstLetter.toUpperCase()));

    }
}
