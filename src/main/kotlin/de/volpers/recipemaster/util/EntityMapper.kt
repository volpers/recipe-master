package de.volpers.recipemaster.util

import com.volpers.recipemaster.api.model.Recipe
import com.volpers.recipemaster.api.model.RecipeCategory
import de.volpers.recipemaster.recipes.model.RecipeEntity
import org.springframework.stereotype.Component

@Component
class EntityMapper {

    fun recipeEntityToDTO(recipeEntity:RecipeEntity)
    = Recipe(
        recipeEntity.identifier,
        recipeEntity.title,
        RecipeCategory(recipeEntity.category) ,
        recipeEntity.picture,
        recipeEntity.description,
        recipeEntity.link,
        recipeEntity.createdAt
    )

    fun dtoToEntity(recipeDTO:Recipe, identifier:String)
    = RecipeEntity()
}