/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.appmedical.web;

import co.com.appmedical.modelo.Cita;
import co.com.appmedical.servicios.CitaService;
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
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CitaController {
    
     @Autowired
    private CitaService citaService;
     
       @GetMapping("/all")
    public List<Cita> getCita(){
        return citaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cita> getCita(@PathVariable("id") int Id) {
        return citaService.getCita(Id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita save(@RequestBody Cita cita) {
        return citaService.save(cita);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita update(@RequestBody Cita cita) {
        return citaService.update(cita);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return citaService.deleteCita(Id);
    }
    
     
     
    
    
}
