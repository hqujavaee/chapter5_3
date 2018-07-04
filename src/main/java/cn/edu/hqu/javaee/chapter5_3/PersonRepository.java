package cn.edu.hqu.javaee.chapter5_3;

import java.util.Optional;

import javax.naming.Name;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Name>{
}
