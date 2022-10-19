package com.example.laboratorio.services;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

public interface ElementService {
    void buttonAddE(String name, Integer amount, String type, Double price,String id);
    ObservableList<Element> getObservableListElement ();
    void buttonDeleteE(Element elementDelete);
    void editElement(int indx,Element element);
    void searchElement(FilteredList<Element> filteredlist, TextField textField);
    void reduceAmount(Element element, Integer amount);
    Element elementMaxLoans();
    void addLoanElement(Element element);
}
