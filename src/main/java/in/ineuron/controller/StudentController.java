package in.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.StudentImpl;

@RestController
@RequestMapping("/std")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentImpl service;

	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		service.saveStudent(student);
		return " one student is added ";
	}

	@GetMapping("/get")
	public List<Student> getAllStudent() {
		return service.getAllStudent();

	}
	

}
