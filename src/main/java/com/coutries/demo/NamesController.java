package com.coutries.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// /names
@RestController
@RequestMapping("/names")
public class NamesController {

    private void sortCountry(){
        DemoApplication.countryList.countryList.sort((c1, c2) ->
                c1.getName().compareToIgnoreCase(c2.getName()));
    }
    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries(){
        this.sortCountry();
        return DemoApplication.countryList.countryList;
    }
// /names/begin?letter=
    @RequestMapping("/begin")
    public ArrayList<Country> getAllBeginWith(
            @RequestParam(value = "letter") String firstLetter){
        this.sortCountry();
        return DemoApplication.countryList.findCountry(c -> String.valueOf(c.getName().charAt(0)).equals(firstLetter.toUpperCase()));

    }

//    /names/size?letters=
    @RequestMapping("/size")
    public ArrayList<Country> getAllWithLength(
            @RequestParam(value = "letters") String letters){
        int length = letters.length();
        this.sortCountry();
        return DemoApplication.countryList.findCountry(c -> c.getName().length() >= length);
    }
}
