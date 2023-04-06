package de.volpers.recipemaster.recipes

import com.volpers.recipemaster.api.model.Recipe
import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeNotFoundException
import de.volpers.recipemaster.recipes.model.RecipeRepository
import de.volpers.recipemaster.util.RecipeEntityMapper
import org.springframework.stereotype.Service

@Service
class RecipeRetrievalService(
    private val recipeRepository: RecipeRepository,
    private val recipeEntityMapper: RecipeEntityMapper
){
    fun getRecipe(recipeIdentifier: String): Recipe {
        if(recipeRepository.existsByIdentifier(recipeIdentifier)) {
            return recipeEntityMapper.entityToDTO(recipeRepository.findByIdentifier(recipeIdentifier))
        }
        throw RecipeNotFoundException()
    }
}
