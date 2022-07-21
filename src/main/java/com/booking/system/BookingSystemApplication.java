package com.booking.system;

import com.booking.system.entity.Doctor;
import com.booking.system.repository.DoctorRepository;
import com.booking.system.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookingSystemApplication.class, args);
	}

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
//		Doctor doctor1 = new Doctor("Sasika", "Dilum", "0715156233", "sas@gmail.com");
//		doctorRepository.save(doctor1);
	}
}
