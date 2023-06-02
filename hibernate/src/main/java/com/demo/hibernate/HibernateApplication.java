package com.demo.hibernate;

import com.demo.hibernate.dao.StudentDAO;
import com.demo.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	Student tempStudent=new Student("Paul","Do", "paul@yahoo.com");
	Student tempStudent2=new Student("Paul","Doe", "paul@yahooe.com");
	Student tempStudent3=new Student("Paul","Does", "paul@yahooee.com");

	public static void main(String[] args) {

		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createMultipleStudent(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAllStudent();
	}

	private void updateStudent(StudentDAO studentDAO, String lastName, int id) {
		Student tempStudent= findStudent(studentDAO,id);
		tempStudent.setLastName(lastName);
		studentDAO.update(tempStudent);

	}

	private void queryForFindStudents(StudentDAO studentDAO, String lastName) {
		List<Student> students=studentDAO.findByLastName(lastName);
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students= studentDAO.findAll();
		for(Student student:students){
			System.out.println(student);
		}
	}

	private Student findStudent(StudentDAO studentDAO,int index){
		return studentDAO.find(index);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");

		ArrayList <Student> studentList = new ArrayList<>();
		studentList.add(tempStudent2);
		studentList.add(tempStudent3);
		studentList.add(tempStudent);

		for (int i=0; i<studentList.size(); i++){
			studentDAO.save(studentList.get(i));
		}
		System.out.println("Saved student" + tempStudent.getId());
	}

	private void removeStudent(StudentDAO studentDAO, int id) {
		System.out.println("deleting Student");
		studentDAO.delete(id);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		studentDAO.save(tempStudent);
		System.out.println("Saved student" + tempStudent.getId());
	}

}
