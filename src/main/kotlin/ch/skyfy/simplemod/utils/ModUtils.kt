package ch.skyfy.simplemod.utils

import net.minecraft.server.network.ServerPlayerEntity

object ModUtils {

    fun getPlayerNameWithUUID(spe: ServerPlayerEntity) = "${spe.name.string}#${spe.uuidAsString}"

}