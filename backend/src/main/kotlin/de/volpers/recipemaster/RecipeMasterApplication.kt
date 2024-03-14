package de.volpers.recipemaster

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecipeMasterApplication

fun main(args: Array<String>) {
	runApplication<RecipeMasterApplication>(*args)
}
