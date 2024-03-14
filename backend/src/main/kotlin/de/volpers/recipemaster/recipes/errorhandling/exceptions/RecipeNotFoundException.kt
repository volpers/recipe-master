package de.volpers.recipemaster.recipes.errorhandling.exceptions

class RecipeNotFoundException : RuntimeException() {

    override val message: String
        get() = "Recipe not found."
}