package rw.ac.rca.nat2022.anselme.server.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.nat2022.anselme.server.services.IStudentSevice;
import rw.ac.rca.nat2022.anselme.server.utils.dtos.CreateStudentDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentSevice studentSevice;


    public StudentController(IStudentSevice studentSevice) {
        this.studentSevice = studentSevice;
    }

    @GetMapping("")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(studentSevice.all());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateStudentDTO student) {
        return ResponseEntity.ok(studentSevice.create(student));
    }

    @PostMapping("/{id}/link/{courseId}")
    public ResponseEntity<?> link(@PathVariable Long id, @PathVariable Long courseId) {
        return ResponseEntity.ok(studentSevice.link(id, courseId));
    }

    @PostMapping("/{id}/unlink/{courseId}")
    public ResponseEntity<?> unlink(@PathVariable Long id, @PathVariable Long courseId) {
        return ResponseEntity.ok(studentSevice.unlink(id, courseId));
    }
}
