package com.example.laboratorio.model;

public class Monitor {
    private String id;
    private String name;
    private Integer loans;

    public Monitor(String id, String name, Integer loans) {
        this.id = id;
        this.name = name;
        this.loans = loans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoans() {
        return loans;
    }

    public void setLoans(Integer loans) {
        this.loans = loans;
    }
}
