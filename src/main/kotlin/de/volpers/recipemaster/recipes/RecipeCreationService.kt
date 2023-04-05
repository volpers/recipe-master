package de.volpers.recipemaster.recipes

import com.volpers.recipemaster.api.model.Recipe
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.stereotype.Service
import java.time.Clock

@Service
class RecipeCreationService (
    private val clock:Clock
){
    companion object {
        const val IDENTIFIER_LENGTH = 8
    }
    fun createRecipe(recipeObject: Recipe) {
        TODO("Not yet implemented")
    }

    fun updateRecipe(recipeIdentifier: String, recipeObject: Recipe) {
        TODO("Not yet implemented")
    }

    private fun createRecipeIdentifier(recipeTitle:String) : String{
        val hash = DigestUtils.md5Hex(recipeTitle + clock.instant().toString())
        return hash.substring(0, IDENTIFIER_LENGTH)
    }
}