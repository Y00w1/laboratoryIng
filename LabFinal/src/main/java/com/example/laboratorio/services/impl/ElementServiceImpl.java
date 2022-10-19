package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.ElementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ElementServiceImpl implements ElementService {

    ObservableList<Element> elementObservableList= FXCollections.observableArrayList();

    @Override
    public ObservableList<Element> getObservableListElement() {
        return elementObservableList;
    }
    boolean band = false;
    @Override
    public void buttonAddE(String name, Integer amount, String type, Double price,String id) {
        if (band){
            for (Element element:elementObservableList){
                if (element.getId().equals(id)){
                    System.out.println("ID unavailable");
                }else {
                    elementObservableList.add(new Element(name,type, amount, price,id));
                }
            }
        }else {
            band=true;
            elementObservableList.add(new Element(name,type, amount, price,id));
        }
    }
    @Override
    public void buttonDeleteE(Element elementDelete){
        elementObservableList.remove(elementDelete);
    }

    @Override
    public void editElement(int id,Element element){
        elementObservableList.set(id,element);
    }

    @Override
    public void searchElement(FilteredList<Element> filteredlist, TextField textField) {
        textField.setPromptText("Search by name");
        textField.textProperty().addListener((prop, old, text)->{
            filteredlist.setPredicate(element ->{
                if (text == null || text.isEmpty()) return true;
                String name = element.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
        }

    @Override
    public void reduceAmount(Element element, Integer amount) {
        if (element.getAmount()>=amount){
            element.setAmount(element.getAmount()-amount);
        }
    }

    @Override
    public void addLoanElement(Element element) {
        element.setLoans(element.getLoans() + 1);
    }

    @Override
    public Element elementMaxLoans() {
        Element maxLoansElement=elementObservableList.get(0);
        for (Element element : elementObservableList) {
            if (maxLoansElement.getLoans() < element.getLoans()) {
                maxLoansElement = element;
            }
        }
        return maxLoansElement;
    }
}