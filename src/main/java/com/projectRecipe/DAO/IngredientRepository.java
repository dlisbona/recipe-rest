package com.projectRecipe.DAO;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.projectRecipe.model.Ingredient;


// Encapsulating storage, retrieval, and search behavior which emulates a collection of objects"
@Repository
public class IngredientRepository {


     // The EntityManager itself is created by the container and injected with annotation
     // Entitymanager manages spring beans
     @PersistenceContext
     private final EntityManager entityManager;



     // Injection Entity manager by constructor
     public IngredientRepository(EntityManager entityManager) {
          this.entityManager = entityManager;
     }



     // EntityManager context is less precise than the session one
     // Sessionfactory manager needs more configuration
     public List<Ingredient> getAll() {
          return entityManager
               .createQuery("from Ingredient", Ingredient.class)
               .getResultList();
     }



     public Optional<Ingredient> getById(Long id) {
          return Optional
               .of(entityManager
                    .find(Ingredient.class, id));
     }



     // If value present, isPresent() will return true and get() will return the value.
     public Optional<Long> create(Ingredient ingredient) {

          if(ingredient
               .getId() == null) {
               return Optional
                    .of((long) ((Session) entityManager)
                         .save(ingredient));
          }

          return Optional
               .empty();
     }



     public Optional<Ingredient> update(Ingredient ingredient) {
          return Optional
               .of((Ingredient) entityManager
                    .merge(ingredient));
     }



     public void delete(Ingredient ingredient) {
          Ingredient ingredientInDB = entityManager
               .find(Ingredient.class, ingredient
                    .getId());
          entityManager
               .remove(ingredientInDB);
     }



     public void deleteById(Long id) {
          Ingredient ingredientInDB = entityManager
               .find(Ingredient.class, id);
          entityManager
               .remove(ingredientInDB);
     }
}
