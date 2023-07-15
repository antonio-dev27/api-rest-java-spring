/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.repositorios;


import co.com.appmedical.modelo.Especialidad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.appmedical.repositorios.crud.EspecialidadCrudRepository;

/**
 *
 * @author 57322
 */
@Repository
public class EspecialidadRepository {
    @Autowired
    private EspecialidadCrudRepository repo;
    
    public List<Especialidad> getAll(){
        return (List<Especialidad>) repo.findAll();
    }
    public Optional<Especialidad> getEspecialidad(int id){
        return repo.findById(id);
    }

    public Especialidad save(Especialidad especialidad){
        return repo.save(especialidad);
    }
    public void delete(Especialidad especialidad){
        repo.delete(especialidad);
    }
    
}
