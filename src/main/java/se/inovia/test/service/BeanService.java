package se.inovia.test.service;

import se.inovia.test.model.Bean;

import java.util.List;
import java.util.Optional;

public interface BeanService {
    public void saveBean(Bean bean);
    public List<Bean>findall();
    Optional<Bean> findBeanById(Long Id);
    Optional<Bean> findBeanByField1(String field1);
    Optional<Bean> findBeanByField2(String field2);
    Optional<Bean> findBeanByField1AndField2(String field1,String field2);
}
