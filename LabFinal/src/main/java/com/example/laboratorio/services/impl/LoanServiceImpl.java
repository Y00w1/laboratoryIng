package com.example.laboratorio.services.impl;

import com.example.laboratorio.controllers.ModelFactoryController;
import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.LoanService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

public class LoanServiceImpl implements LoanService{

    MonitorServiceImpl monitorService = new MonitorServiceImpl();
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    ObservableList<Loan> loanObservableList = FXCollections.observableArrayList();

    int codeGenerator;

    @Override
    public int getCodeGenerator() {
        codeGenerator+=1;
        return codeGenerator;
    }

    @Override
    public ObservableList<Loan> getLoanObservableList() {
        return loanObservableList;
    }

    @Override
    public Boolean addLoan(String element, String student, Integer amount, Integer id, ObservableList<Element> elements, ObservableList<Student> students) {
        Element element1 = validateElement(elements, element);
        Student student1 = validateStudent(students, student);
        if (element1.getAmount()>=amount){
            loanObservableList.add(new Loan(element1.getName(), student1.getName(), monitorService.getMonitor().getName(), amount, id, element1.getId(), student1.getId()));
            return true;
        }else {
            System.out.println("Invalid amount");
            return false;
        }
    }

    @Override
    public void searchLoan(FilteredList<Loan> loanFilteredList, TextField textField) {
        textField.textProperty().addListener((prop, old, text)->{
            loanFilteredList.setPredicate(loan -> {
                if (text==null || text.isEmpty()) return true;
                String element = loan.getElement().toLowerCase();
                return element.contains(text.toLowerCase());
            });
        });
    }

    public Element validateElement(ObservableList<Element> elements, String element) {
        Element element2 = null;
        for (Element element1 : elements) {
            if (element1.getId().equals(element)) {
                element2 = element1;
            }
        }
        return element2;
    }

    @Override
    public Student validateStudent(ObservableList<Student> students, String student) {
        Student stu2 = null;
        for (Student stu : students) {
            if (stu.getId().equals(student)) {
                stu2 = stu;
            }
        }
        return stu2;
    }
    @Override
    public void reloadTable(ObservableList<Element> elements, ObservableList<Student> students){
        for (Loan loan: loanObservableList){
            for (Element element:elements){
                if (loan.getIdElement().equals(element.getId())){
                    loan.setElement(element.getName());
                    loan.setIdElement(element.getId());
                }
            }
            for (Student student:students){
                if (loan.getIdStudent().equals(student.getId())){
                    loan.setStudent(student.getName());
                    loan.setIdStudent(student.getId());
                }
            }
        }
    }
}

