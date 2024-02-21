package com.example.currencyswapservice.model;

public class Health {
    private String name;
    private Boolean isHealthy;

    public Health() {
        this.name = "Currency Rate Service";
        this.isHealthy = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHealthy() {
        return isHealthy;
    }

    public void setHealthy(Boolean healthy) {
        isHealthy = healthy;
    }
}
