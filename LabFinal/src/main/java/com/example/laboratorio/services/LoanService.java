package com.example.laboratorio.services;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;

public interface LoanService {
    ObservableList<Loan> getLoanObservableList();
    void addLoan(Element element, Student student, Monitor monitor, Integer amount);
}
