package dev.jahidhasanco.paging3_dogapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(
    @Json(name = "bred_for")
    val bredFor: String,
    @Json(name = "breed_group")
    val breedGroup: String,
    @Json(name = "height")
    val height: Height,
    @Json(name = "id")
    val id: Int,
    @Json(name = "life_span")
    val lifeSpan: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "reference_image_id")
    val referenceImageId: String,
    @Json(name = "temperament")
    val temperament: String,
    @Json(name = "weight")
    val weight: Weight
)