package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }

    public int deleteStudent(UUID id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(UUID id, Student newStudent) {
        return studentDao.updateStudentById(id, newStudent);
    }
}
