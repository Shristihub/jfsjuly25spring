package com.studentapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.model.Course;
import com.studentapp.model.CourseDto;
import com.studentapp.repository.ICourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements ICourseService {
	private final ModelMapper mapper;
	private final ICourseRepository courseRepository;


	@Override
	public void addCourse(CourseDto courseDto) {
		Course course= mapper.map(courseDto, Course.class);
		courseRepository.save(course);

	}

	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course= mapper.map(courseDto, Course.class);
		courseRepository.save(course);


	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);

	}

	@Override
	@Transactional
	public CourseDto getById(int courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(()-> new RuntimeException("invalid Id"));
			return mapper.map(course, CourseDto.class);
	}

	@Override
	@Transactional
	public List<CourseDto> getAll() {
		return courseRepository.findAll()
				.stream()
				.map(course->mapper.map(course, CourseDto.class))
				.toList();
	}

	

}
