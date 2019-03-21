package se.inovia.test.model;

import javax.persistence.Id;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Bean")
public class Bean implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "Id", unique = true, nullable = false)
    Long Id;
    @Column(name = "field1")
    String field1;
    @Column(name = "field2")
    String field2;

    public Bean(){
    }

    /*public Bean(Long Id,String field1, String field2) {
        this.Id = Id;
        this.field1 = field1;
        this.field2 = field2;
    }*/


    public Bean(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id){
        this.Id = id;
    }

    public String getField1(){
        return field1;
    }

    public void setField1(String field1){
        this.field1 = field1;
    }

    public String getField2(){
        return field2;
    }

    public void setField2(String field2){
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "Id='" + Id + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
