package me.timv.smi;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import java.util.Collection;
import org.bukkit.potion.PotionEffectType;

public class PoisonArrow {
	public static void onPlayerHit(ProjectileHitEvent event, Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 1));
	}
	
}
