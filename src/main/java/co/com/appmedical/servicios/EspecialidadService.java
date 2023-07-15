/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.servicios;


import co.com.appmedical.modelo.Especialidad;
import co.com.appmedical.repositorios.EspecialidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57322
 */
@Service
public class EspecialidadService {
     @Autowired
     private EspecialidadRepository especialidadRepository;
     
    public List<Especialidad> getAll(){
        return especialidadRepository.getAll();
    }
      
    public Optional<Especialidad> getEspecialidad(int Id) {
        return especialidadRepository.getEspecialidad(Id);
    }
       
    public Especialidad save(Especialidad especialidad){
        if(especialidad.getId()==null){
            return especialidadRepository.save(especialidad);
        }else{
            Optional<Especialidad> e= especialidadRepository.getEspecialidad(especialidad.getId());
            if(e.isEmpty()){
                return especialidadRepository.save(especialidad);
            }else{
                return especialidad;
            }
        }
    }
    
    public Especialidad update(Especialidad especialidad){
        if(especialidad.getId()!=null){
            Optional<Especialidad> e= especialidadRepository.getEspecialidad(especialidad.getId());
            if(!e.isEmpty()){
                if(especialidad.getNombre()!=null){
                    e.get().setNombre(especialidad.getNombre());
                }
                especialidadRepository.save(e.get());
                return e.get();
            }else{
                return especialidad;
            }
        }else{
            return especialidad;
        }
    }
    
    public boolean deleteEspecialidad(int Id) {
        Boolean aBoolean = getEspecialidad(Id).map(especialidad -> {
            especialidadRepository.delete(especialidad);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
         
}
