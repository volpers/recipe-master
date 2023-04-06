package de.volpers.recipemaster.recipes.errorhandling

import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeAlreadyExistsException
import de.volpers.recipemaster.recipes.errorhandling.exceptions.RecipeNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler
    fun handleRecipeAlreadyExistsException(exception:RecipeAlreadyExistsException) : ResponseEntity<String>{
        return ResponseEntity.badRequest().body(exception.message)
    }

    @ExceptionHandler
    fun handleRecipeNotFoundException(exception: RecipeNotFoundException) : ResponseEntity<String>{
        return ResponseEntity.notFound().build()
    }

}