package com.example.laboratorio.model;

public class Loan {
    private String element;
    private String student;
    private String monitor;
    private Integer amount;
    private Integer id;
    private String idElement;
    private String idStudent;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdElement() {
        return idElement;
    }

    public void setIdElement(String idElement) {
        this.idElement = idElement;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public Loan(String element, String student, String monitor, Integer amount, Integer id, String idElement, String idStudent) {
        this.element = element;
        this.student = student;
        this.monitor = monitor;
        this.amount = amount;
        this.id = id;
        this.idElement = idElement;
        this.idStudent = idStudent;
    }

    public Loan() {
    }
}
