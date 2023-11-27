package net.emeoigo.studentmanagement.controller;

import net.emeoigo.studentmanagement.exception.ResourceNotFoundException;
import net.emeoigo.studentmanagement.model.Student;
import net.emeoigo.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public List<Student>getAllStudents(){

        return studentRepository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable long id){
        Student student=studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student does not exist: " +id));
        return ResponseEntity.ok(student);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails){
        Student updateStudent=studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student does not exist: " +id));
        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmail(studentDetails.getEmail());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteStudent(@PathVariable long id){
        Student student=studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student does not exist with ID: "+id));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
