package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Student;

public interface IStudent {

	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

}
