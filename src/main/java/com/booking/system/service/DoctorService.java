package com.booking.system.service;

import com.booking.system.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Doctor doctor);

    void deleteDoctorById(Long id);
}
