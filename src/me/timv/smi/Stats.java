package me.timv.smi;
import java.util.ArrayList;

import java.util.Random;


import org.bukkit.event.entity.ProjectileHitEvent;

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
import org.bukkit.event.entity.ProjectileLaunchEvent;
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
import org.bukkit.event.player.PlayerJoinEvent;
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

public class Stats {
	static Player player = null;
	static int points;
	static int karma;
	public static void giveStats() {
			player.sendMessage("-------------------");
			player.sendMessage("Your're a: " + isTraitor());
			player.sendMessage("Points: " + points);
			player.sendMessage("Karma: " + karma);
			player.sendMessage("-------------------");
		
		
	}
	
	public static String isTraitor() {
		if(TraitorFunctions.traitors.contains(player.getDisplayName())) {
			points = TraitorFunctions.traitorPoints;
			karma = TraitorFunctions.traitorKarma;
			return "Traitor!";
		} else {
			points = InnocentFunctions.innocentPoints;
			karma = InnocentFunctions.innocentKarma;
			return "Innocent!";
		}
		
		
	}
}
