package me.timv.smi;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public interface Traitor {
	public void onTraitorSpawn(Player player);
	public void hitTraitor(EntityDamageByEntityEvent event);
}
