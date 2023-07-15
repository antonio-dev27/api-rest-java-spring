/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.repositorios;

import co.com.appmedical.modelo.Paciente;
import co.com.appmedical.repositorios.crud.PacienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 57322
 */
@Repository
public class PacienteRepository {
    
    @Autowired
    private PacienteCrudRepository repo;
    
    public List<Paciente> getAll(){
        return (List<Paciente>) repo.findAll();
    }
    public Optional<Paciente> getPaciente(int id){
        return repo.findById(id);
    }

    public Paciente save(Paciente paciente){
        return repo.save(paciente);
    }
    public void delete(Paciente paciente){
        repo.delete(paciente);
    }
    
}
