package com.example.laboratorio.model;

public class Loan {
    private Element element;
    private Student student;
    private Monitor monitor;
    private Integer amount;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Loan(Element element, Student student, Monitor monitor, Integer amount) {
        this.element = element;
        this.student = student;
        this.monitor = monitor;
        this.amount = amount;
    }

    public Loan() {
    }
}
