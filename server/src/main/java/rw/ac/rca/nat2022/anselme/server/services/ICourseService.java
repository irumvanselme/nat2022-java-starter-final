package rw.ac.rca.nat2022.anselme.server.services;

import rw.ac.rca.nat2022.anselme.server.models.Course;
import rw.ac.rca.nat2022.anselme.server.utils.dtos.CreateCourseDTO;

import java.util.List;

public interface ICourseService {

    List<Course> all();

    Course create(CreateCourseDTO course);

    Course findById(Long courseId);
}
