/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.appmedical.repositorios.crud;

import co.com.appmedical.modelo.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 57322
 */
public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
    
}
 