package de.volpers.recipemaster.util

import com.volpers.recipemaster.api.model.Recipe
import com.volpers.recipemaster.api.model.RecipeCategory
import de.volpers.recipemaster.recipes.model.RecipeEntity
import org.springframework.stereotype.Component

@Component
class RecipeEntityMapper {

    fun entityToDTO(recipeEntity:RecipeEntity)
    = Recipe(
        recipeEntity.title,
        recipeEntity.identifier,
        RecipeCategory(recipeEntity.category) ,
        recipeEntity.picture,
        recipeEntity.description,
        recipeEntity.link,
        recipeEntity.createdAt
    )

    fun dtoToEntity(recipeDTO:Recipe, identifier:String)
    = RecipeEntity.Builder()
        .identifier(identifier)
        .title(recipeDTO.title)
        .category("Test")
        .link(recipeDTO.link)
        .description(recipeDTO.description)
        .picture(recipeDTO.picture)
        .build()
}