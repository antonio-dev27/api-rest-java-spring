/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.servicios;

import co.com.appmedical.modelo.Cita;
import co.com.appmedical.repositorios.CitaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57322
 */
@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    
    public List<Cita> getAll(){
        return citaRepository.getAll();
    }
    
    public Optional<Cita> getCita(int citaId) {
        return citaRepository.getCita(citaId);
    }
    
    public Cita save(Cita cita){
        if(cita.getId()==null){
            return citaRepository.save(cita);
        }else{
            Optional<Cita> e= citaRepository.getCita(cita.getId());
            if(e.isEmpty()){
                return citaRepository.save(cita);
            }else{
                return cita;
            }
        }
    }
    
    public Cita update(Cita cita){
        if(cita.getId()!=null){
            Optional<Cita> e= citaRepository.getCita(cita.getId());
            if(!e.isEmpty()){

                if(cita.getFechaInicio()!=null){
                    e.get().setFechaInicio(cita.getFechaInicio());
                }
                if(cita.getFechaFinal()!=null){
                    e.get().setFechaFinal(cita.getFechaFinal());
                }
                citaRepository.save(e.get());
                return e.get(); 
            }else{
            return cita;
            }           
        }else{
            return cita;
        }
    }
    
    
    public boolean deleteCita(int Id) {
        Boolean aBoolean = getCita(Id).map(cita -> {
            citaRepository.delete(cita);
            return true;
        }).orElse(false);
        return aBoolean;
       }
}
