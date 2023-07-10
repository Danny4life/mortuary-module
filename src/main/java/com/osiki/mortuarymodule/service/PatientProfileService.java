package com.osiki.mortuarymodule.service;

import com.osiki.mortuarymodule.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {
    List<PatientProfile> getAllPerson();

    PatientProfile savePatientProfile(PatientProfile patientProfile);

    PatientProfile getPatientById(Long id);

    PatientProfile updatePatientProfile(PatientProfile patientProfile);

    void deletePatientProfileById(Long id);
}
