package com.booking.system.controller;

import com.booking.system.entity.Doctor;
import com.booking.system.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        super();
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String listDoctors(Model model){
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }

    @GetMapping("/doctors/new")
    public String createDoctorForm(Model model){
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "create_doctor";
    }

    @PostMapping("/doctors")
    public String Doctor (@ModelAttribute("doctor") Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctorFrom(@PathVariable Long id, Model model){
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "edit_Doctor";
    }

    @PostMapping("doctors/{id}")
    public String updateDoctor (@PathVariable Long id, @ModelAttribute("doctor") Doctor doctor, Model model){
        Doctor existingDoctor = doctorService.getDoctorById(id);
        existingDoctor.setId(id);
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
        existingDoctor.setEmail(doctor.getEmail());

        doctorService.updateDoctor((existingDoctor));
        return "redirect:/doctors";
    }

    @GetMapping("doctors/{id}")
    public String deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }
}
