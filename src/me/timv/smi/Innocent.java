package me.timv.smi;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface Innocent {
	public void onInnocentSpawn(Player player);
	public void hitInnocent(EntityDamageByEntityEvent event);
}
