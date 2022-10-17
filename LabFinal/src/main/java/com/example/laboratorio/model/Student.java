package com.example.laboratorio.model;

public class Student {
    private String id;
    private String name;
    private String email;
    private String number;
    private Integer loans = 0;
    private String career;
    private Integer semester;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getLoans() {
        return loans;
    }

    public void setLoans(Integer loans) {
        this.loans = loans;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Student(String id, String name, String email, String number, String career, Integer semester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.career = career;
        this.semester = semester;
    }
}
