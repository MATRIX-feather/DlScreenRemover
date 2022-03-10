package io.github.matrixfeather.dlscreenremover.mixin;

import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DownloadingTerrainScreen.class)
public abstract class MixinDownloadingTerrainScreen extends Screen
{
    protected MixinDownloadingTerrainScreen(Text title)
    {
        super(NarratorManager.EMPTY);
    }

    @Inject
    (
            at = @At("HEAD"),
            method = "tick",
            cancellable = true
    )
    private void onScreenTick(CallbackInfo ci)
    {
        close();
        ci.cancel();
    }
}
