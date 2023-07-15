/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.servicios;

import co.com.appmedical.modelo.Paciente;
import co.com.appmedical.repositorios.PacienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57322
 */
@Service
public class PacienteService {
    @Autowired
     private PacienteRepository pacienteRepository;
    
         public List<Paciente> getAll(){
        return pacienteRepository.getAll();
    }
     
      public Optional<Paciente> getPaciente(int Id) {
        return pacienteRepository.getPaciente(Id);
    }

    public Paciente save(Paciente paciente){
        if(paciente.getId()==null){
            return pacienteRepository.save(paciente);
        }else{
            Optional<Paciente> e= pacienteRepository.getPaciente(paciente.getId());
            if(e.isEmpty()){
                return pacienteRepository.save(paciente);
            }else{
                return paciente;
            }
        }
    }

    public Paciente update(Paciente paciente){
        if(paciente.getId()!=null){
            Optional<Paciente> e= pacienteRepository.getPaciente(paciente.getId());
            if(!e.isEmpty()){
                if(paciente.getNombre()!=null){
                    e.get().setNombre(paciente.getNombre());
                }
                if(paciente.getApellido()!=null){
                    e.get().setApellido(paciente.getApellido());
                }
                if(paciente.getCedula()!=null){
                    e.get().setCedula(paciente.getCedula());
                }
                if(paciente.getEdad()!=null){
                    e.get().setEdad(paciente.getEdad());
                }
                if(paciente.getTelefono()!=null){
                    e.get().setTelefono(paciente.getTelefono());
                }
                pacienteRepository.save(e.get());
                return e.get();
            }else{
                return paciente;
            }
        }else{
            return paciente;
        }
    }

   
     public boolean deletePaciente(int Id) {
        Boolean aBoolean = getPaciente(Id).map(paciente -> {
            pacienteRepository.delete(paciente);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
       
    

