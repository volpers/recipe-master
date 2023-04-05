package de.volpers.recipemaster.recipes.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : CrudRepository<RecipeEntity, Long> {

}