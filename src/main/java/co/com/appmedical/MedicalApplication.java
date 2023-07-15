package co.com.appmedical;

import co.com.appmedical.modelo.Doctor;
import co.com.appmedical.repositorios.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"co.com.appmedical"})
public class MedicalApplication { 
    
    
    @Autowired
    private DoctorRepository repoDoctor;
    
    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class, args);
    }
    
    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
           
            List<Doctor> cs = repoDoctor.getAll();
            System.out.println("doctores: "+cs.size());
            
        };
    }

}


    