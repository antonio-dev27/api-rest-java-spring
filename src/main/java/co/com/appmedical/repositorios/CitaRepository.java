/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.repositorios;


import co.com.appmedical.modelo.Cita;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.appmedical.repositorios.crud.CitaCrudRepository;

/**
 *
 * @author 57322
 */
@Repository
public class CitaRepository {
    
    @Autowired
    private CitaCrudRepository repo;
    
    public List<Cita> getAll(){
        return (List<Cita>) repo.findAll();
    }
    public Optional<Cita> getCita(int id){
        return repo.findById(id);
    }
    public Cita save(Cita cita){
        return repo.save(cita);
    }
    public void delete(Cita cita){
        repo.delete(cita);
    }
   
}
