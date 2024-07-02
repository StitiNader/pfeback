package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.model.Appointment;
import com.contactApp.contactApp.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointments());
    }


    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(appointment));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment updatedAppointment, @PathVariable("id") Integer id) {
        Appointment updatedAppointmentResult = appointmentService.updateAppointment(id, updatedAppointment);
        return ResponseEntity.ok(updatedAppointmentResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Integer id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAppointmentById(id));
    }

}
