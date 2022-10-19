package com.example.laboratorio.model;

public class Element {
    private String name;
    private String type;
    private Integer amount;
    private String id;
    private Double price;
    private Integer loans;

    public Integer getLoans() {
        return loans;
    }

    public void setLoans(Integer loans) {
        this.loans = loans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Element(String name, String type, Integer amount, Double price, String id) {
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.price = price;
        this.id = id;
    }
}
