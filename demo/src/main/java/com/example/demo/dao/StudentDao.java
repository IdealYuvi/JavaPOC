package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertStudent(UUID id, Student student);

    default int insertStudent(Student student) {
        UUID id = UUID.randomUUID();
        return insertStudent(id, student);
    }

    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(UUID id);

    int deleteStudentById(UUID id);

    int updateStudentById(UUID id, Student student);

}
