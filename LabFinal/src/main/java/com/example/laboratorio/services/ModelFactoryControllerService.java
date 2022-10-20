package com.example.laboratorio.services;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public interface ModelFactoryControllerService {
    //Elements
    void buttonAddE(String name, Integer amount, String type, Double price,String id);
    void buttonDeleteE(Element elementDelete);
    void editElement(int indx,Element element);
    void searchElement(FilteredList<Element> filteredlist, TextField textField);
    Element validateElement(String element);
    void reduceAmountElement(Element element, Integer amount);
    ObservableList<Element> getObservableListElement ();


    //Students
    ObservableList<Student> getObservableListStudent ();
    void btnAddStudent(String id, String name, String email, String number, String career, Integer semester);
    void btnDeleteStudent(Student student);
    void btnEditStudent(Integer indx, Student student);
    void searchStudent(FilteredList<Student> filteredlist, TextField textField);
    void addLoanElement(Element element);

    //Scenes
    void switchScene(ActionEvent e, String resource) throws IOException;
    void switchToStudentScene(ActionEvent e) throws IOException;
    void switchToElementScene(ActionEvent e) throws IOException;
    void switchToLoanScene(ActionEvent e) throws IOException;
    void switchToInformationScene(ActionEvent e) throws IOException;

    //Loan
    Boolean addLoan(String element, String student, Integer amount, Integer id);
    ObservableList<Loan> getObservableListLoan();
    void addLoanStudent(Student student);
    Student validateStudent(String student);
    void searchLoan(FilteredList<Loan> loanFilteredList, TextField textField);

    //Monitor
    Monitor getMonitor();
    void editLoansMonitor();
}
