package de.volpers.recipemaster

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class RecipeMasterConfiguration {
    @Bean
    fun clock() : Clock {
        return Clock.systemDefaultZone()
    }
}