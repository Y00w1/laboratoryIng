package com.example.laboratorio.services;

import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;

public interface UserService {
    void addStudent(String id, String name, String email, String number, String career, Integer semester);
    ObservableList<Student> getStudentObservableList();
}
