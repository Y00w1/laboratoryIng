package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.LoanService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoanServiceImpl implements LoanService {
    ObservableList<Loan> loanObservableList = FXCollections.observableArrayList();
    @Override
    public ObservableList<Loan> getLoanObservableList() {
        return loanObservableList;
    }

    @Override
    public void addLoan(Element element, Student student, Monitor monitor, Integer amount) {
        loanObservableList.add(new Loan(element, student, monitor, amount));
    }
}
