package ch.skyfy.simplemod

import ch.skyfy.json5configlib.ConfigManager
import ch.skyfy.simplemod.command.SurvivalCmd
import ch.skyfy.simplemod.config.Configs
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.ShulkerBoxBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtList
import net.minecraft.util.TypedActionResult
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.nio.file.Path
import kotlin.io.path.*

@Suppress("MemberVisibilityCanBePrivate")
class SimpleModMod : ModInitializer {

    companion object {
        const val MOD_ID: String = "simple_mod"
        val CONFIG_DIRECTORY: Path = FabricLoader.getInstance().configDir.resolve(MOD_ID)
        val LOGGER: Logger = LogManager.getLogger(SimpleModMod::class.java)
    }

    init {
        ConfigManager.loadConfigs(arrayOf(Configs::class.java))
    }

    override fun onInitialize() {
        registerCommands()
    }

    private fun registerCommands() = CommandRegistrationCallback.EVENT.register { dispatcher, _, _ -> SurvivalCmd.register(dispatcher) }


}


