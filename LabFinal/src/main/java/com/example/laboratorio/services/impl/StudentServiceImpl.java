package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements UserService {
    ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    @Override
    public void addStudent(String id, String name, String email, String number, String career, Integer semester) {
        studentObservableList.add(new Student(id, name, email, number, career, semester));
    }
    @Override
    public ObservableList<Student> getStudentObservableList() {
        return studentObservableList;
    }
}
