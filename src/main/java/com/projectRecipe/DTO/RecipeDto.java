package com.projectRecipe.DTO;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.projectRecipe.model.Recipe;


public class RecipeDto {

     private Long id;
     private String name;
     private String picture;
     private String description;
     private Set<RecipeIngredientDto> ingredients = new HashSet<>();
     private Set<String> instructions = new HashSet<>();



     public RecipeDto() {

     }
     //



     public RecipeDto(Recipe recipe) {
          this.id = recipe
               .getId();
          this.name = recipe
               .getName();
          this.picture = recipe
               .getPicture();
          this.description = recipe
               .getDescription();

          // 1 - get Set<RecipeIngredient>
          // 2 = concert iterable into stream()
          // 3 = map string with constructor of RecipeIngredientDto
          // 4 = collect input into container
          // 5 = collector is converted to a set
          this.ingredients = recipe
               .getIngredients()
               .stream()
               .map(RecipeIngredientDto::new)
               .collect(Collectors
                    .toSet());
          this.instructions = recipe
               .getInstructions();
     }



     public Recipe toRecipe() {
          Recipe recipe = new Recipe();
          recipe
               .setId(this.id);
          recipe
               .setName(this.name);
          recipe
               .setPicture(this.picture);
          recipe
               .setDescription(this.description);
          recipe
               .setIngredients(this
                    .getIngredients()
                    .stream()
                    .map(RecipeIngredientDto::toRecipeIngredient)
                    .collect(Collectors
                         .toSet()));
          recipe
               .setInstructions(this.instructions);
          return recipe;
     }



     public Long getId() {
          return id;
     }



     public void setId(Long id) {
          this.id = id;
     }



     public String getName() {
          return name;
     }



     public void setName(String name) {
          this.name = name;
     }



     public String getPicture() {
          return picture;
     }



     public void setPicture(String picture) {
          this.picture = picture;
     }



     public String getDescription() {
          return description;
     }



     public void setDescription(String description) {
          this.description = description;
     }



     public Set<RecipeIngredientDto> getIngredients() {
          return ingredients;
     }



     public void setIngredients(Set<RecipeIngredientDto> ingredientDtos) {
          this.ingredients = ingredientDtos;
     }



     public Set<String> getInstructions() {
          return instructions;
     }



     public void setInstructions(Set<String> instructions) {
          this.instructions = instructions;
     }



     @Override
     public boolean equals(Object o) {
          if(this == o) return true;
          if(o == null || getClass() != o
               .getClass()) return false;
          RecipeDto recipeDto = (RecipeDto) o;
          return Objects
               .equals(id, recipeDto.id)
                    && Objects
                         .equals(name, recipeDto.name)
                    && Objects
                         .equals(picture, recipeDto.picture)
                    && Objects
                         .equals(description, recipeDto.description)
                    && Objects
                         .equals(ingredients, recipeDto.ingredients)
                    && Objects
                         .equals(instructions, recipeDto.instructions);
     }



     @Override
     public int hashCode() {
          return Objects
               .hash(id, name, picture, description, ingredients, instructions);
     }



     @Override
     public String toString() {
          return ToStringBuilder
               .reflectionToString(this);
     }
}
