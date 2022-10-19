package com.example.laboratorio.services.impl;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements UserService {
    ObservableList<Student> studentObservableList = FXCollections.observableArrayList();

    boolean band = false;
    @Override
    public void addStudent(String id, String name, String email, String number, String career, Integer semester) {
        if (band){
            for (Student student : studentObservableList) {
                if (student.getId().equals(id)) {
                    System.out.println("ID unavailable");
                } else {
                    studentObservableList.add(new Student(id, name, email, number, career, semester));
                }
            }
        }else{
            band=true;
            studentObservableList.add(new Student(id, name, email, number, career, semester));
        }
    }

    @Override
    public ObservableList<Student> getStudentObservableList() {
        return studentObservableList;
    }

    @Override
    public void deleteStudent(Student student) {
        studentObservableList.remove(student);
    }

    @Override
    public void editStudent(Integer indx, Student student) {
        studentObservableList.set(indx, student);
    }

    @Override
    public void searchStudent(FilteredList<Student> filteredlist, TextField textField) {
        textField.textProperty().addListener((prop, old, text) -> {
            filteredlist.setPredicate(student -> {
                if (text == null || text.isEmpty()) return true;
                String name = student.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
    }

    @Override
    public void addLoanStudent(Student student) {
        student.setLoans(student.getLoans() + 1);
    }

    @Override
    public Student studentMaxLoans() {
        Student maxLoansStudent=studentObservableList.get(0);
        for (Student student : studentObservableList) {
            if (maxLoansStudent.getLoans() < student.getLoans()) {
                maxLoansStudent = student;
            }
        }
        return maxLoansStudent;
    }
}
