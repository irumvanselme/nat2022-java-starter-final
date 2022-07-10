package rw.ac.rca.nat2022.anselme.server.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rw.ac.rca.nat2022.anselme.server.models.Course;
import rw.ac.rca.nat2022.anselme.server.models.Student;
import rw.ac.rca.nat2022.anselme.server.repositories.IStudentRepository;
import rw.ac.rca.nat2022.anselme.server.services.ICourseService;
import rw.ac.rca.nat2022.anselme.server.services.IStudentSevice;
import rw.ac.rca.nat2022.anselme.server.utils.dtos.CreateStudentDTO;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentSevice {

    private final IStudentRepository studentRepository;

    private final ICourseService courseService;

    public StudentServiceImpl(IStudentRepository studentRepository, ICourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(CreateStudentDTO student) {
        Student studentInfo = new ModelMapper().map(student, Student.class);
        return studentRepository.save(studentInfo);
    }

    @Override
    public Student link(Long id, Long courseId) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseService.findById(courseId);

        student.getCourses().add(course);

        return studentRepository.save(student);
    }

    @Override
    public Student unlink(Long id, Long courseId) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseService.findById(courseId);

        student.getCourses().remove(course);

        return studentRepository.save(student);
    }
}
