/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.repositorios;

import co.com.appmedical.modelo.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.appmedical.repositorios.crud.DoctorCrudRepository;

/**
 *
 * @author 57322
 * 
 */
@Repository
public class DoctorRepository {
    
    @Autowired
    private DoctorCrudRepository repo;
    
    public List<Doctor> getAll(){
        return (List<Doctor>)repo.findAll();
    }
    
    public Optional<Doctor> getById(int id) {
        return repo.findById(id);
    }
    
    public Doctor save(Doctor doctor){
        return repo.save(doctor);
    }
    
    public void delete(Doctor doctor){
        repo.delete(doctor);
    }   
    
}
