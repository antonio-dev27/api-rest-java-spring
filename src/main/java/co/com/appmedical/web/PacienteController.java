/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.web;

import co.com.appmedical.modelo.Paciente;
import co.com.appmedical.servicios.PacienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 57322
 */
@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PacienteController {
    
    @Autowired   
    private PacienteService pacienteService;
    
     @GetMapping("/all")
    public List<Paciente> getPaciente(){
        return pacienteService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPaciente(@PathVariable("id") int Id) {
        return pacienteService.getPaciente(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente save(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente update(@RequestBody Paciente paciente) {
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return pacienteService.deletePaciente(Id);
    }
    
}
