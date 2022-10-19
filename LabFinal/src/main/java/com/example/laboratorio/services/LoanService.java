package com.example.laboratorio.services;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

public interface LoanService {
    Element validateElement(ObservableList<Element> elements, String element);
    Student validateStudent(ObservableList<Student> students, String student);
    ObservableList<Loan> getLoanObservableList();
    int getCodeGenerator();
    Boolean addLoan(String element, String student, Integer amount,Integer id, ObservableList<Element> elements, ObservableList<Student> students);
    void searchLoan(FilteredList<Loan> loanFilteredList, TextField textField);
}
