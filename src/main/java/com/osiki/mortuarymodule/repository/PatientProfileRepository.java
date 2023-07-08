package com.osiki.mortuarymodule.repository;

import com.osiki.mortuarymodule.model.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {
}
