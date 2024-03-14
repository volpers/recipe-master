package de.volpers.recipemaster.recipes

import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeNotFoundException
import de.volpers.recipemaster.recipes.model.RecipeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecipeDeletionService(
    private val recipeRepository: RecipeRepository
) {
    @Transactional
    fun deleteRecipe(recipeIdentifier: String) {
       if(recipeRepository.existsByIdentifier(recipeIdentifier)) {
           recipeRepository.deleteByIdentifier(recipeIdentifier)
       }
        throw RecipeNotFoundException()
    }
}