package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Student;
import in.ineuron.repository.StudentRepo;

@Service
public class StudentImpl implements IStudent {

	@Autowired
	private StudentRepo repo;

	@Override
	public Student saveStudent(Student student) {

		return repo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		 
		return repo.findAll();
	}

}
