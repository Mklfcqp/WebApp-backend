package com.webapp.patient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    public Patient getPatientById(long id);

    public Patient updatePatient(Patient patient);
}
