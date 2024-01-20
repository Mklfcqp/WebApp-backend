package com.webapp.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    // repository
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).get();
    }


    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
