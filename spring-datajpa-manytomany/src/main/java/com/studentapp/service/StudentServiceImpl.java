package com.studentapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.model.CourseLevel;
import com.studentapp.model.Mode;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements IStudentService {

	private final ModelMapper mapper;
	private final IStudentRepository studentRepository;

	@Override
	public void addStudent(StudentDto studentDto) {
		Student student = mapper.map(studentDto, Student.class);
		System.out.println(student);
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		Student student = mapper.map(studentDto, Student.class);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	
	public StudentDto getById(int studentId) {
		Student student = studentRepository.findById(studentId)
			.orElseThrow(()-> new RuntimeException("invalid Id"));
		return mapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAll() {
		return studentRepository.findAll()
				.stream()
				.map(student->mapper.map(student, StudentDto.class))
				.toList();
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseNameAndLevel(String courseName, CourseLevel level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseNameAndMode(String courseName, Mode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
