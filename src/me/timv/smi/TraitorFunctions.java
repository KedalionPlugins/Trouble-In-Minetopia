package me.timv.smi;
import java.util.ArrayList;
import java.util.Random;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.fusesource.jansi.Ansi.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class TraitorFunctions implements Traitor {
	static Player innocent = null;
	static Player traitor = null;
	Player other = null;
	Inventory traitorInventory;
	static boolean isTraitor;
	static boolean isInnocent;
	public static int traitorPoints; //Singular for each traitor - Ked
	public static int traitorKarma;
	public static int innocentKarma;
	public static int innocentPoints;
	static ArrayList traitors = new ArrayList();
	
	Random random = new Random(14);
	ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	
	
	public TraitorFunctions(Player trait) {
		onTraitorSpawn(trait);
	}

	@Override
	public void onTraitorSpawn(Player player) {
		if(traitors.contains(player.getDisplayName()));
		{
			isTraitor = true;
		} 
		while(isTraitor = true) {
		traitorInventory.addItem(item);
		traitor.sendMessage(ChatColor.RED + "[Console] Support us at our official website: troubleinminetopia.tk - Kedalion(Head Developer)");		
		}
			
	}

	@Override 
	public void hitTraitor (EntityDamageByEntityEvent event) {
		Player guy = guy = (Player) event.getDamager();
		Player target = (Player) event;
		
		if(guy != null && isTraitor && target != null && isTraitor && traitors.contains(guy.getDisplayName()) && traitors.contains(target.getDisplayName())) {
				guy.sendMessage(Color.RED + "[Console] " + target.getDisplayName() + "Is a fellow traitor. You might not want to hit him!");
				
		} else {
			if(target.isDead()) {
				Location l = target.getLocation();
				l.getWorld().strikeLightningEffect(l); //Lightning effect on kill - Ked
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "[Trouble In Minetopia] A Traitor was killed by a Traitor!");
				traitorPoints = traitorPoints-1;
				traitorKarma = traitorKarma-1;
			} else {
				if(guy != null && isTraitor && target != null && isInnocent && traitors.contains(guy.getDisplayName())) {
					Location l = target.getLocation();
					l.getWorld().strikeLightningEffect(l); //Lightning effect on kill - Ked
					Bukkit.getServer().broadcastMessage(ChatColor.RED + "[Trouble in Minetopia] An Innocent was killed by a Traitor!");
					traitorPoints = traitorPoints+1;
					//TODO PUT THE TARGET SOMEWHERE
				}
			}
		} 
	}
}
		




	
	
