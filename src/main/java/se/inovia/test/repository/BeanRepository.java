package se.inovia.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import se.inovia.test.model.Bean;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeanRepository extends JpaRepository<Bean, Long> {
    @Override
    Optional<Bean> findById(Long Id);

    @Override
    List<Bean> findAll();

    Optional<Bean> findBeanByField1(String field1);
    Optional<Bean> findBeanByField2(String field2);
    Optional<Bean> findBeanByField1AndField2(String field1,String field2);
}
