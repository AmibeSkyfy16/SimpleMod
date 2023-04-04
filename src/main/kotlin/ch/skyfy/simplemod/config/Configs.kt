package ch.skyfy.simplemod.config

import ch.skyfy.json5configlib.ConfigData
import ch.skyfy.simplemod.SimpleModMod

object Configs {
    @JvmField
    val CONFIG = ConfigData.invokeSpecial<Config>(SimpleModMod.CONFIG_DIRECTORY.resolve("config.json5"), true)
}
