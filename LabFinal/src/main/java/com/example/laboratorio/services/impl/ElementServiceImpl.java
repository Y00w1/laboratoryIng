package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.services.ElementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ElementServiceImpl implements ElementService {
    private List<Element> listElement  = new ArrayList<>();
    public ElementServiceImpl() {
        this.listElement = listElement;
    }

    public List<Element> getListElement() {
        return listElement;
    }

    public void setListElement(List<Element> listElement) {
        this.listElement = listElement;
    }

    ObservableList<Element> elementObservableList= FXCollections.observableArrayList();
    @Override
    public void buttonAddE(String name, Integer amount, String material, Double price) {
        elementObservableList.add(new Element(name, amount, material, price));
        Element element = new Element(name, amount, material, price);
        listElement.add(element);
    }

    @Override
    public ObservableList<Element> getObservableListElement() {
        return elementObservableList;
    }
}
