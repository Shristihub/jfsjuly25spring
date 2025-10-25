package com.doctorapp.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDto;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer>{

	List<Hospital> findByCity(String city);
	List<Hospital> findByHospitalType(String type);
	
	@Query("from Hospital h inner join h.doctors d where d.speciality=?1")
	List<Hospital> findByDoctorSpeciality(String speciality);
	@Query("from Hospital h inner join h.doctors d where d.speciality=?1 and d.experience>?2")
	List<Hospital> findBySpecialityExp(String speciality, int experience);
	@Query("""
			from Hospital h inner join h.doctors d where d.speciality=?1
			and d.fees<?2
			""")
	List<Hospital> findBySpecialityFees(String speciality, double fees);
	
	List<Hospital> findByDoctorLocation(String location);
	List<Hospital> findByDoctorAvailability(LocalTime availability);
	
}
