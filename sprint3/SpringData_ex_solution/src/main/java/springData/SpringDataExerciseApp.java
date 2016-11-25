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
    	Module unmanagedModule = new Module();
    	unmanagedModule.setCode("CO2006");
    	unmanagedModule.setDescription("Software Engineering and System Development");
    	
    	moduleRepo.save(unmanagedModule);
    	
    	Module CO2006 = moduleRepo.findByCode("CO2006").get(0);
    	System.out.println("\n\n\n" + CO2006.getDescription() + "\n\n\n");
    	
    	// TODO: Exercise 3.b
    	Module CO2012 = new Module();
    	CO2012.setCode("CO2012");
    	CO2012.setDescription("Software project management and professionalism");
    	
    	Student student = new Student();
    	student.setFullName("me");
    	student.getModuleList().add(CO2006);
    	CO2006.getStudents().add(student);
    	
    	student.getModuleList().add(CO2012);
    	studentRepo.save(student);
    	CO2012.getStudents().add(student);
    	
    	Module managedModule = moduleRepo.findByCode("CO2012").get(0);
    	System.out.println("\n\n\n" + managedModule.getDescription() + "\n\n\n");
    	for (Student s : managedModule.getStudents()) {
    		System.out.println("\n\n\n" + s.getFullName() + "\n\n\n");
    	}
    }   

}
