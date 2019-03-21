package se.inovia.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.inovia.test.model.Bean;
import se.inovia.test.service.BeanService;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest")
public class Controllers {

    @Autowired
    BeanService beanService;

    @RequestMapping("/welcome")
    public String getWelcomeMessage() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(new Date());
        System.out.println("Hello World !"+formattedDate);
        return "Hello World !"+formattedDate;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> insertBeanData(@RequestBody Bean bean){
        beanService.saveBean(bean);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + bean.getId())
                .buildAndExpand().toUri());

        return new ResponseEntity<>(bean, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/findAllBeans")
    public List<Bean> getBeanObject(){
        return beanService.findall();
    }

    @GetMapping("/findBeanById")
    public Optional<Bean> getBeanById(@RequestParam("Id") Long Id){
        System.out.println("Field1 Value : "+Id);
        return beanService.findBeanById(Id);
    }

    @GetMapping("/findBeanByField1")
    public Optional<Bean> getBeanByField1(@RequestParam("field1") String field1){
        System.out.println("Field1 Value : "+field1);
        return beanService.findBeanByField1(field1);
    }

    @GetMapping("/findBeanByField2")
    public Optional<Bean> getBeanByField2(@RequestParam("field2") String field2){
        System.out.println("Field2 Value : "+field2);
        return beanService.findBeanByField2(field2);
    }

    @GetMapping("/findBeanByField1AndField2")
    public Optional<Bean> getBeanByField1AndField2(@RequestParam("field1") String field1,
                                                   @RequestParam("field2") String field2){

        System.out.println("Field2 Value : "+field2);
        return beanService.findBeanByField2(field2);
    }



}
