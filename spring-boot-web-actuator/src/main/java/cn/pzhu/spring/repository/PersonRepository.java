package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
