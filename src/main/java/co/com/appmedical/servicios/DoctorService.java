/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.servicios;

import co.com.appmedical.modelo.Doctor;
import co.com.appmedical.repositorios.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57322
 */
@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    
    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    
    public Doctor getById(int id){
        Optional<Doctor> doctor = doctorRepository.getById(id);
        return doctor.orElse(new Doctor());
       
    }
    
    public boolean delete(int id) {
        System.out.println("deleting Doctor with id: " + id);
        boolean del = doctorRepository.getById(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
        return del;
    }
    
    
    public Doctor update(Doctor doctor) {
        if (doctor.getID() != null) {
            Optional<Doctor> doctorConsultada = doctorRepository.getById(doctor.getID());
            if (doctorConsultada.isPresent()) {
                if (doctor.getNombre() != null) {
                    doctorConsultada.get().setNombre(doctor.getNombre());
                }
                if (doctor.getApellido() != null) {
                    doctorConsultada.get().setApellido(doctor.getApellido());
                }
                if (doctor.getEspecialidad() != null) {
                    doctorConsultada.get().setEspecialidad(doctor.getEspecialidad());
                }
                if (doctor.getConsultorio() != null) {
                    doctorConsultada.get().setConsultorio(doctor.getConsultorio());
                }
                if (doctor.getEmail() != null) {
                    doctorConsultada.get().setEmail(doctor.getEmail());
                }
                
                return doctorRepository.save(doctorConsultada.get());
            }
        }
        return doctor;
    }
    
}
