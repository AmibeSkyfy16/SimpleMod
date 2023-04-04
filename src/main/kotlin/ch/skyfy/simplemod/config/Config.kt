package ch.skyfy.simplemod.config

import ch.skyfy.json5configlib.Validatable
import io.github.xn32.json5k.SerialComment
import kotlinx.serialization.Serializable

@Serializable
data class Config(
    @SerialComment("An useless description")
    val ImAUselessConfig: String = "Hi, im a useless config field"
) : Validatable
