package rw.ac.rca.nat2022.anselme.server.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.rca.nat2022.anselme.server.models.Course;
import rw.ac.rca.nat2022.anselme.server.repositories.ICourseRepository;
import rw.ac.rca.nat2022.anselme.server.services.ICourseService;
import rw.ac.rca.nat2022.anselme.server.utils.dtos.CreateCourseDTO;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> all() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(CreateCourseDTO course) {
        Course courseInfo = new ModelMapper().map(course, Course.class);
        return courseRepository.save(courseInfo);
    }

    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
