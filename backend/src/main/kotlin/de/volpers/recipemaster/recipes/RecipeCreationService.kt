package de.volpers.recipemaster.recipes

import com.volpers.recipemaster.api.model.Recipe
import com.volpers.recipemaster.api.model.RecipeStatusResponse
import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeAlreadyExistsException
import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeNotFoundException
import de.volpers.recipemaster.recipes.model.RecipeEntity
import de.volpers.recipemaster.recipes.model.RecipeRepository
import de.volpers.recipemaster.recipes.model.mapper.RecipeEntityMapper
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecipeCreationService (
    private val recipeRepository: RecipeRepository,
    private val recipeEntityMapper : RecipeEntityMapper
){
    companion object {
        const val IDENTIFIER_LENGTH = 8
    }
    @Transactional
    fun createRecipe(recipeObject: Recipe) : RecipeStatusResponse {
        val identifier = createRecipeIdentifier(recipeObject.title)
        if(recipeRepository.existsByIdentifier(identifier)) {
           throw RecipeAlreadyExistsException()
        }
        val recipe = recipeEntityMapper.dtoToEntity(recipeObject, identifier)
        recipeRepository.save(recipe)
        return RecipeStatusResponse(identifier)
    }

    @Transactional
    fun updateRecipe(recipeIdentifier: String, recipeObject: Recipe) {
        if(!recipeRepository.existsByIdentifier(recipeIdentifier)) {
            throw RecipeNotFoundException()
        }
        val recipe = updateRecipeEntity(recipeIdentifier, recipeObject)
        recipeRepository.save(recipe)
    }

    private fun updateRecipeEntity(recipeIdentifier: String, recipeObject: Recipe): RecipeEntity {
        val recipe = recipeRepository.findByIdentifier(recipeIdentifier)
        recipe.title = recipeObject.title
        recipe.description = recipeObject.description
        recipe.link = recipeObject.link
        recipe.picture = recipeObject.picture
        return recipe
    }

    private fun createRecipeIdentifier(recipeTitle:String) : String{
        val hash = DigestUtils.md5Hex(recipeTitle)
        return hash.substring(0, IDENTIFIER_LENGTH)
    }
}