package springData;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springData.domain.Module;
import springData.domain.Student;
import springData.repository.ModuleRepository;
import springData.repository.StudentRepository;

@SpringBootApplication
public class SpringDataExerciseApp implements CommandLineRunner { 

	@Autowired ModuleRepository moduleRepo;
	@Autowired StudentRepository studentRepo;

	public static void main(String[] args) {
        SpringApplication.run(SpringDataExerciseApp.class, args);
        
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
    	// TODO: Exercise 3.a
    	
    	// TODO: Exercise 3.b
    }   

}
