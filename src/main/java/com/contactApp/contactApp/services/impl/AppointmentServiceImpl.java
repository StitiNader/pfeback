package com.contactApp.contactApp.services.impl;

import com.contactApp.contactApp.model.Appointment;
import com.contactApp.contactApp.repository.AppointmentRepository;
import com.contactApp.contactApp.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Appointment not found"));
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Integer id,Appointment appointment) {
        Appointment oldAppointment = getAppointmentById(id);
        appointment.setId(oldAppointment.getId());
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer id) {
         appointmentRepository.deleteById(id);
    }
}
