package com.mod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class GlowingMixin {
    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void makeGlow(CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity) (Object) this;
        MinecraftClient client = MinecraftClient.getInstance();
        
        if (entity instanceof PlayerEntity && entity != client.player) {
            cir.setReturnValue(true);
        }
    }
}
