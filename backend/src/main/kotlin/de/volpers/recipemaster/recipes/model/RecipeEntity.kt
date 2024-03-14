package de.volpers.recipemaster.recipes.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.OffsetDateTime

@Entity
@Table(name = "recipes")
class RecipeEntity(
    @Column(name = "title")
    var title: String = "",

    @Column(name = "identifier")
    var identifier: String? = "",

    @Column(name = "picture")
    var picture: String? = "",

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "link")
    var link: String? = "",

    @Column(name = "category")
    var category: String? = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @CreatedDate
    @Column(name = "created_at")
    var createdAt: OffsetDateTime? = null

    class Builder {
        private var identifier: String? = ""
        private var title: String = ""
        private var picture: String? = ""
        private var description: String? = ""
        private var link: String? = ""
        private var category: String? = ""

        fun title(title: String) = apply {this.title = title}
        fun identifier(identifier: String?) = apply {this.identifier = identifier}
        fun picture(picture: String?) = apply {this.picture = picture}
        fun description(description: String?) = apply {this.description = description}
        fun link(link: String?) = apply {this.link = link}
        fun category(category: String?) = apply {this.category = category}

        fun build() : RecipeEntity {
            return RecipeEntity(title, identifier, picture, description, link, category)
        }
    }
}