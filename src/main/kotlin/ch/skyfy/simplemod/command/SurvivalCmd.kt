package ch.skyfy.simplemod.command

import com.mojang.brigadier.Command
import com.mojang.brigadier.Command.SINGLE_SUCCESS
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.world.GameMode

class SurvivalCmd : Command<ServerCommandSource> {

    companion object {

        fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
            val cmd = literal("survival")
                .requires { source -> source.hasPermissionLevel(0) }
                .executes(SurvivalCmd())

            dispatcher.register(cmd)
        }

    }

    override fun run(context: CommandContext<ServerCommandSource>): Int {
        // here the ? mean, if player is null the changeGameMode is not executed
        context.source.player?.changeGameMode(GameMode.SURVIVAL)

        return SINGLE_SUCCESS
    }

}