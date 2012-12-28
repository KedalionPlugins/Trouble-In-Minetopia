package me.timv.smi;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerInteractEvent;

public class Detective {
	Detective detective;
	Player player = (Player) this.detective;
	Inventory inv = player.getInventory();
	ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
	ItemStack armor = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
	ItemStack book = new ItemStack(Material.BOOK, 1);
	PlayerInteractEvent event;
	
	public Detective(Player player) {
		this.player = player;
		onDetectiveSpawn();
	}
	
	public void onDetectiveSpawn() {
		inv.addItem(sword);
		inv.addItem(armor);
		Bukkit.getServer().broadcastMessage("[Trouble In Minetopia] " + player.getDisplayName() + "Is the detective!");
	}
	
	public void hitDetective(EntityDamageByEntityEvent event) {
		Player guy = (Player) event.getDamager();
		Player target = (Player) event;
		
		if(target.isDead()) {
			
		if(guy != null && TraitorFunctions.traitors.contains(guy.getDisplayName())) {
			Bukkit.getServer().broadcastMessage("The Detective was killed by a Traitor!");
		}
		else if(guy != null && InnocentFunctions.isInnocent) {
			Bukkit.getServer().broadcastMessage("The Detective was killed by an Innocent!");
			}
		}
	}
	
	public String isTraitor(Player guy) {
		if(TraitorFunctions.traitors.contains(guy.getDisplayName())) {
			return "Traitor";
		} else {
			return "Innocent";
		}
	}
	
	public void dropBook(Player dead, boolean isDead) {
		while(dead.isDead()) {
			inv.addItem(book);
			Action action = event.getAction();
			Player killer = dead.getKiller();
			if(player.getItemInHand() == book) {
				if(action == Action.RIGHT_CLICK_BLOCK) {
					player.sendMessage("----------------------------------------");
					player.sendMessage("Player Name: " + dead.getDisplayName());
					player.sendMessage("Status: " + isTraitor(dead));
					player.sendMessage("Killer: " + killer.getDisplayName());
					player.sendMessage("----------------------------------------");
				}
			}
		}
	}
}
