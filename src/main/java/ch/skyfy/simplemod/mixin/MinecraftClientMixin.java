package ch.skyfy.simplemod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.stream.Collectors;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {


    @Shadow
    static MinecraftClient instance;

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    public void onSetScreen(Screen screen, CallbackInfo ci) {
        var sw = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        sw.forEach(stackFrame -> {
            if(stackFrame.getMethodName().equalsIgnoreCase("updateNausea") || stackFrame.getMethodName().equalsIgnoreCase("method_18654")){
                if(instance.currentScreen instanceof ChatScreen) ci.cancel();
            }
        });
    }

}
