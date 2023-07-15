package co.com.appmedical.web;

import co.com.appmedical.modelo.Doctor;
import co.com.appmedical.servicios.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 57322
 */
@RestController
@RequestMapping("/api/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorService.getAll();      
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(doctorService.delete(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }
}
