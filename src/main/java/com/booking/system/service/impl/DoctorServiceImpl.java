package com.booking.system.service.impl;

import com.booking.system.entity.Doctor;
import com.booking.system.repository.DoctorRepository;
import com.booking.system.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    public DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
