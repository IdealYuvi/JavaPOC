package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeStudentDataAccess implements StudentDao{
    private static List<Student> DB = new ArrayList<>();
    @Override
    public int insertStudent(UUID id, Student student) {
        DB.add(new Student(id, student.getName()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return DB;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteStudentById(UUID id) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (studentMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(studentMaybe.get());
        return 1;
    }

    @Override
    public int updateStudentById(UUID id, Student student) {
        return selectStudentById(id)
                .map(s -> {
                    int indexOfStudentToUpdate = DB.indexOf(s);
                    if (indexOfStudentToUpdate >= 0) {
                        DB.set(indexOfStudentToUpdate, new Student(id, student.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
