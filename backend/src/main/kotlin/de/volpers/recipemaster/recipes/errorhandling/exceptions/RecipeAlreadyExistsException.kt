package de.volpers.recipemaster.recipes.errorhandling.exceptions

class RecipeAlreadyExistsException : RuntimeException() {

    override val message: String
        get() = "Recipe already exists."
}