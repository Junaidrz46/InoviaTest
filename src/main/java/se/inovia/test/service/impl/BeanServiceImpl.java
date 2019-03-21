package se.inovia.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.inovia.test.model.Bean;
import se.inovia.test.repository.BeanRepository;
import se.inovia.test.service.BeanService;

import java.util.List;
import java.util.Optional;

@Service
public class BeanServiceImpl<be> implements BeanService {

    @Autowired
    BeanRepository beanRepository;

    @Override
    public void saveBean(Bean bean) {
        beanRepository.save(bean);
    }

    @Override
    public List<Bean> findall() {
        return beanRepository.findAll();
    }

    @Override
    public Optional<Bean> findBeanById(Long Id) {
        return beanRepository.findById(Id);
    }

    @Override
    public Optional<Bean> findBeanByField1(String field1) {
        return beanRepository.findBeanByField1(field1);
    }

    @Override
    public Optional<Bean> findBeanByField2(String field2) {
        return beanRepository.findBeanByField2(field2);
    }

    @Override
    public Optional<Bean> findBeanByField1AndField2(String field1, String field2) {
        return beanRepository.findBeanByField1AndField2(field1,field2);
    }


}
