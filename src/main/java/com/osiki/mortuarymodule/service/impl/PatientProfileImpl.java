package com.osiki.mortuarymodule.service.impl;

import com.osiki.mortuarymodule.model.PatientProfile;
import com.osiki.mortuarymodule.repository.PatientProfileRepository;
import com.osiki.mortuarymodule.service.PatientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileImpl implements PatientProfileService {

    @Autowired
    private PatientProfileRepository patientProfileRepository;

    public PatientProfileImpl(PatientProfileRepository patientProfileRepository) {
        super();
        this.patientProfileRepository = patientProfileRepository;
    }

    @Override
    public List<PatientProfile> getAllPerson() {
        return patientProfileRepository.findAll();
    }

    @Override
    public PatientProfile savePatientProfile(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return patientProfileRepository.findById(id).get();
    }

    @Override
    public PatientProfile updatePatientProfile(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }

    @Override
    public void deletePatientProfileById(Long id) {
        patientProfileRepository.deleteById(id);
    }
}
