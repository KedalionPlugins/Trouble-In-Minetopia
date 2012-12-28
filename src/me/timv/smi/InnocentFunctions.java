package me.timv.smi;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InnocentFunctions implements Innocent {
	Player innocent = null;
	Player traitor = null;
	Player other = null;
	Inventory inv;
	static boolean isTraitor;
	static boolean isInnocent;
	public static int traitorPoints; //Singular for each traitor - Ked
	public static int traitorKarma;
	public static int innocentKarma;
	public static int innocentPoints;
	ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);

	public InnocentFunctions(Player player) {
	onInnocentSpawn(player);
	}
	
	@Override
	public void onInnocentSpawn(Player player) {
		if(!(TraitorFunctions.traitors.contains(innocent))) {
			isTraitor = true;
		} else {
			isInnocent = true;
	} 
		while(isInnocent = true) {
			inv.addItem(item);
			innocent.sendMessage(ChatColor.RED + "[Console] Support us at our official website: troubleinminetopia.tk - Kedalion(Head Developer)");
		}
		
	}

	@Override
	public void hitInnocent(EntityDamageByEntityEvent event) {
		Player guy = guy = (Player) event.getDamager();
		Player target = (Player) event;
		
		if(target.isDead()) {
			Location l = target.getLocation();
			l.getWorld().strikeLightningEffect(l);
			if(guy != null && isInnocent && target != null && isInnocent) {
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "[Trouble In Minetopia] An Innocent was killed by an Innocent!");
			innocentPoints = innocentPoints-1;
			innocentKarma = innocentKarma-1;
			}
		
		}
		
		
	}
	
}
