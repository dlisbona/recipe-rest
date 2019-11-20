package com.projectRecipe.DAO;


import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.projectRecipe.model.Recipe;

@Repository
public class RecipeRepository {

     @PersistenceContext
     private final EntityManager entityManager;



     public RecipeRepository(EntityManager entityManager) {
          this.entityManager = entityManager;
     }



     public List<Recipe> getAll() {
          return entityManager
               .createQuery("from Recipe", Recipe.class)
               .getResultList();
     }



     public Optional<Recipe> getById(Long id) {
          return Optional
               .of(entityManager
                    .find(Recipe.class, id));
     }



     public Optional<Long> create(Recipe recipe) {

          if(recipe
               .getId() == null) {
               return Optional
                    .of((long) ((Session) entityManager)
                         .save(recipe));
          }

          return Optional
               .empty();
     }



     public void update(Recipe recipe) {
          entityManager
               .find(Recipe.class, recipe
                    .getId());
          entityManager
               .merge(recipe);
     }



     public void delete(Recipe recipe) {
          Recipe recipeInDB = entityManager
               .find(Recipe.class, recipe
                    .getId());
          entityManager
               .remove(recipeInDB);
     }



     public void deleteById(Long id) {
          Recipe recipeInDB = entityManager
               .find(Recipe.class, id);
          entityManager
               .remove(recipeInDB);
     }
}
