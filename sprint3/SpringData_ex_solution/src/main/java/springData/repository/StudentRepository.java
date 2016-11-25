package springData.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springData.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findById(int id);
    List<Student> findByFullName(String fullName);
}