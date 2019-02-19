package com.coutries.demo;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private double landMass;
    private double medAge;

    public Country(String name, long population, double landMass, double medAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medAge = medAge;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getLandMass() {
        return landMass;
    }

    public void setLandMass(double landMass) {
        this.landMass = landMass;
    }

    public double getMedAge() {
        return medAge;
    }

    public void setMedAge(double medAge) {
        this.medAge = medAge;
    }
}
