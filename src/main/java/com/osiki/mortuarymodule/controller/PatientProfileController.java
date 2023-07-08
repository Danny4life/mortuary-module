package com.osiki.mortuarymodule.controller;

import com.osiki.mortuarymodule.model.PatientProfile;
import com.osiki.mortuarymodule.service.PatientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientProfileController {

    @Autowired
    private PatientProfileService patientProfileService;


    public PatientProfileController(PatientProfileService patientProfileService) {
        super();
        this.patientProfileService = patientProfileService;
    }

    @GetMapping("/patientProfile")
    public String listProfile(Model model){
        model.addAttribute("patientProfile", patientProfileService.getAllPerson());

        return "patientProfile";
    }

    @GetMapping("/patients/new")
    public String createPatientForm(Model model){
        PatientProfile patientProfile = new PatientProfile();
        model.addAttribute("patient", patientProfile);

        return "create_profile";
    }

    @PostMapping("/patientProfile")
    public String savePatientProfile(@ModelAttribute("patient") PatientProfile patientProfile){
        patientProfileService.savePatientProfile(patientProfile);

        return "redirect:/patientProfile";

    }

    @GetMapping("/patientProfile/edit/{id}")
    public String editPatientProfile(@PathVariable Long id, Model model){
        model.addAttribute("patient", patientProfileService.getPatientById(id));

        return "edit_patientProfile";

    }

    @PostMapping("/patientProfile/{id}")
    public String updatePatientProfile(@PathVariable Long id,
                                       @ModelAttribute("patient") PatientProfile patientProfile,
                                        Model model){

        // get patient from database by id
        PatientProfile existingPatient = patientProfileService.getPatientById(id);
        existingPatient.setFirstname(patientProfile.getFirstname());
        existingPatient.setLastname(patientProfile.getLastname());
        existingPatient.setAge(patientProfile.getAge());
        existingPatient.setGender(patientProfile.getGender());
        existingPatient.setCauseOfDeath(patientProfile.getCauseOfDeath());
        existingPatient.setDateOfBirth(patientProfile.getDateOfBirth());
        existingPatient.setDateOfDeath(patientProfile.getDateOfDeath());

        // save updated patient object
        patientProfileService.updatePatientProfile(existingPatient);

        return "redirect:/patientProfile";

    }
}
