package dev.roeliefantje.hackedclient.mixin;

import dev.roeliefantje.hackedclient.ClientMain;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ExampleMixin {

	@Inject(at = @At("HEAD"), method = "send(Lnet/minecraft/network/Packet;)V")
	private void inject_print(Packet<?> p, CallbackInfo info) {
		if(p instanceof PlayerMoveC2SPacket){
			PlayerMoveC2SPacket moveP = (PlayerMoveC2SPacket) p;
			if(moveP.changesPosition()){
				String x = String.valueOf(moveP.getX(0));
				String y = String.valueOf(moveP.getY(0));
				String z = String.valueOf(moveP.getZ(0));

				String message = String.format("X: %s Y: %s Z: %s", x, y, z);
				ClientMain.LOGGER.info(message);
			}


//			ClientMain.LOGGER.info();
		}
//		} else {
////			ClientMain.LOGGER.info(p.getClass().getName());
//		}

	}
}
