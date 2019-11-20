package com.projectRecipe.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "ingredient")
public class Ingredient {
     private Long id;
     private String name;



     public Ingredient() {}



     public Ingredient(String name) {
          this.name = name;
     }



     // primary key
     @Id
     // how primary key value is created
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ingredient_id")
     public Long getId() {
          return id;
     }



     public void setId(Long id) {
          this.id = id;
     }



     @Column(name = "name")
     public String getName() {
          return name;
     }



     public void setName(String name) {
          this.name = name;
     }



     @Override
     public boolean equals(Object o) {
          // test equality reference
          if(this == o) return true;

          // test nullity, test class
          if(o == null || getClass() != o
               .getClass()) return false;

          // preventive cast
          Ingredient that = (Ingredient) o;

          // test object by field return true if equal
          return Objects
               .equals(id, that.id)
                    && Objects
                         .equals(name, that.name);
     }



     // return consistent identification hashcode
     @Override
     public int hashCode() {
          return Objects
               .hash(id, name);
     }



     // override tostring method
     @Override
     public String toString() {
          return ToStringBuilder
               .reflectionToString(this);
     }


}
