package io.spring.security.sux.springbootsecuritycourse.controllers;

import io.spring.security.sux.springbootsecuritycourse.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "José Madero"),
            new Student(2, "Jorge Kross"),
            new Student(3, "Ricardo Treviño"),
            new Student(4, "Arturo Arredondo")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(X -> studentId.equals(X.getStudentId()) )
                .findFirst().orElseThrow(() -> new IllegalStateException("Student "+studentId+" does not exists."));
    }

}
