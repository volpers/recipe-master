package de.volpers.recipemaster.recipes

import com.volpers.recipemaster.api.RecipesApi
import com.volpers.recipemaster.api.model.Recipe
import de.volpers.recipemaster.recipes.model.RecipeEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipeController(
    private val recipeCreationService: RecipeCreationService,
    private val recipeDeletionService: RecipeDeletionService,
    private val recipeRetrievalService: RecipeRetrievalService
) : RecipesApi
{
    override fun createRecipe(recipeObject: Recipe): ResponseEntity<Unit> {
        recipeCreationService.createRecipe(recipeObject)
        return ResponseEntity.ok().build()
    }

    override fun deleteRecipe(recipeIdentifier: String): ResponseEntity<Unit> {
        recipeDeletionService.deleteRecipe(recipeIdentifier)
        return ResponseEntity.ok().build()
    }

    override fun putRecipe(recipeIdentifier: String, recipeObject: Recipe): ResponseEntity<Unit> {
        recipeCreationService.updateRecipe(recipeIdentifier, recipeObject)
        return ResponseEntity.ok().build()
    }

    override fun retrieveRecipe(recipeIdentifier: String): ResponseEntity<Recipe> {
        val recipe = recipeRetrievalService.getRecipe(recipeIdentifier)
        return ResponseEntity.ok().body(recipe)
    }
}