package de.volpers.recipemaster.recipes.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.OffsetDateTime

@Entity
@Table(name = "recipes")
class RecipeEntity(
    @Column(name = "identifier")
    var identifier: String? = null,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "picture")
    var picture: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "link")
    var link: String? = null,

    @Column(name = "category")
    var category: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @CreatedDate
    @Column(name = "created_at")
    var createdAt: OffsetDateTime? = null

    class Builder {
        var identifier: String = ""
        var title: String = ""
        var picture: String = ""
        var description: String = ""
        var link: String = ""
        var category: String = ""

        fun setIdentifier(identifier: String) = apply {this.identifier = identifier}
        fun setTitle(identifier: String) = apply {this.identifier = identifier}
        fun setPicture(identifier: String) = apply {this.identifier = identifier}
        fun setDescription(identifier: String) = apply {this.identifier = identifier}
        fun setLink(identifier: String) = apply {this.identifier = identifier}
        fun setCategory(identifier: String) = apply {this.identifier = identifier}
    }
}