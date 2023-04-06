package de.volpers.recipemaster.recipes.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : CrudRepository<RecipeEntity, Long> {
    fun existsByIdentifier(identifier:String) : Boolean
    fun findByIdentifier(identifier: String) : RecipeEntity
    fun deleteByIdentifier(identifier: String)
    fun updateByIdentifier(identifier: String, recipeEntity: RecipeEntity)
}