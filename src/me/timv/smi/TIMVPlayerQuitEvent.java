package me.timv.smi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class TIMVPlayerQuitEvent implements Listener {
	// private TIMV plugin;

	 public TIMVPlayerQuitEvent(TIMV plugin)
	  {
	 	// this.plugin = plugin;
	 	 plugin.getServer().getPluginManager().registerEvents(this, plugin);
	  }

	   

	@EventHandler
	 public void onPlayerRespawn(PlayerQuitEvent event)
	   {
	 	// Player ep = event.getPlayer();
	 	// ep.setBanned(true);
	   }




	 }

