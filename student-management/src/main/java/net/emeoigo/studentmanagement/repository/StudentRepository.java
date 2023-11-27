package net.emeoigo.studentmanagement.repository;

import net.emeoigo.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
