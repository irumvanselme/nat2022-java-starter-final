package rw.ac.rca.nat2022.anselme.server.services;

import rw.ac.rca.nat2022.anselme.server.models.Student;
import rw.ac.rca.nat2022.anselme.server.utils.dtos.CreateStudentDTO;

import java.util.List;

public interface IStudentSevice {
    List<Student> all();

    Student create(CreateStudentDTO student);

    Student link(Long id, Long courseId);

    Student unlink(Long id, Long courseId);
}
