package net.emeoigo.studentmanagement;

import net.emeoigo.studentmanagement.model.Student;
import net.emeoigo.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student student=new Student();
		student.setFirstName("Daniel");
		student.setLastName("James");
		student.setEmail("emeoigo@gmail.com");
		studentRepository.save(student);

		Student student1=new Student();
		student1.setFirstName("Edwin");
		student1.setLastName("Chris");
		student1.setEmail("oigoc60@gmail.com");
		studentRepository.save(student1);


	}
}
