package springData.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springData.domain.Module;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
    List<Module> findByCode(String code);
    
    // TODO: Exercise 01
}