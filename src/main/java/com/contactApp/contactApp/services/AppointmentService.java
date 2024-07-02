package com.contactApp.contactApp.services;

import com.contactApp.contactApp.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Integer id);

    Appointment addAppointment(Appointment appointment);

    Appointment updateAppointment(Integer id,Appointment appointment);

    void deleteAppointment(Integer id);
}
