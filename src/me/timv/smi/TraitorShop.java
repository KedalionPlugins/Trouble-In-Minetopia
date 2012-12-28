package me.timv.smi;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TraitorShop {
	static ProjectileLaunchEvent event;
	static ProjectileHitEvent hit;
	static PoisonArrow poison = new PoisonArrow();
	
	public TraitorShop(CommandSender sender, Command command, String commandLabel, String[] args) {
		onCommand(sender, command, commandLabel, args);
	}
	
	public static boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		Player buy = null;
		if(Stats.isTraitor() == "Traitor!") {
		
		Inventory inv = buy.getInventory();
		ItemStack arrow = new ItemStack(Material.ARROW, 20);
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemStack bow = new ItemStack(Material.BOW, 1);
		
		if(command.getName().equalsIgnoreCase("traitorshop")) {
			buy.sendMessage(ChatColor.GREEN + "---------------------------"); //The Traitor Shop! - Ked
			buy.sendMessage(ChatColor.GREEN + "Your Points: " + TraitorFunctions.traitorPoints);
			buy.sendMessage(ChatColor.GREEN + "Use /traitorshop (item) to buy an item.");
			buy.sendMessage(ChatColor.GREEN + "Poison Arrows presented by [KedArrows] (type poisonarrows) - 5 points");
			buy.sendMessage(ChatColor.GREEN + "Sword (type sword) - 2 points");
			buy.sendMessage(ChatColor.GREEN + "Bow (type bow) - 3 points");
			buy.sendMessage(ChatColor.GREEN + "---------------------------");
			if(args[0] == "poisonarrows") {
				if(TraitorFunctions.traitorPoints == 5) {
					TraitorFunctions.traitorPoints = 0;
					buy.sendMessage("You bought a Poison Arrow!");
					inv.addItem(arrow);
					if(event != null) {
						poison.onPlayerHit(hit, buy);
					}
				} else {
					if(TraitorFunctions.traitorPoints < 5) {
						buy.sendMessage("You don't have enough points to buy this!");
						}
					} 
				} else {
					if(TraitorFunctions.traitorPoints > 5) {
						TraitorFunctions.traitorPoints = TraitorFunctions.traitorPoints-5;
						buy.sendMessage("You bought a Poison Arrow!");
						inv.addItem(arrow);
						if(event != null) {
							poison.onPlayerHit(hit, buy);
						}
						if(args[0] == "sword") {
							if(TraitorFunctions.traitorPoints == 2) {
								TraitorFunctions.traitorPoints = 0;
								buy.sendMessage("You bought a Stone Sword!");
								inv.addItem(sword);
							}
						} else {
							if(TraitorFunctions.traitorPoints < 2) {
								buy.sendMessage("You don't have enough points to buy this!");
							} else {
							if(TraitorFunctions.traitorPoints > 2) {
								TraitorFunctions.traitorPoints = TraitorFunctions.traitorPoints-2;
								buy.sendMessage("You bought a Stone Sword!");
								inv.addItem(sword);
									
								}
								if(args[0] == "bow") {
									if(TraitorFunctions.traitorPoints == 3) {
										TraitorFunctions.traitorPoints = 0;
										buy.sendMessage("You bought a Bow!");
										inv.addItem(bow);
										
									} else {
										if(TraitorFunctions.traitorPoints < 3) {
											buy.sendMessage("You don't have enough points!");
										} else {
											if(TraitorFunctions.traitorPoints > 3) {
												TraitorFunctions.traitorPoints = TraitorFunctions.traitorPoints-3;
												buy.sendMessage("You bought a Bow!");
												inv.addItem(bow);
											}
										}
									}
								}
							} 
							
						}
					}
				}
			} else {
            buy.sendMessage(ChatColor.RED + "You're not a Traitor!");
			}
		}
		return false;
	}
}
