package me.timv.smi;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;



public class ButtonPressEvent implements Listener {
   private TIMV plugin;

	 public ButtonPressEvent(TIMV plugin)
	  {
	 	 this.plugin = plugin;
	 	 plugin.getServer().getPluginManager().registerEvents(this, plugin);
	  }

	   

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	    if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        Block clicked = event.getClickedBlock();
	        if (clicked.getType() == Material.STONE_BUTTON) {
	            // this.getConfig().addDefault("Players.type" + pl[i].getDisplayName(), 0);
	        	if(plugin.getConfig().getInt("Players.type" + p.getDisplayName()) == 2 || plugin.getConfig().getInt("Players.type" + p.getDisplayName()) == 3)
	        	{
	        		plugin.getServer().broadcastMessage(ChatColor.DARK_RED + p.getDisplayName() + " is a traitor! We prefer to kill!");
	        	}
	        	else
	        	{
	        		plugin.getServer().broadcastMessage(ChatColor.GREEN + p.getDisplayName() + " is Innocent!");
	        	}
	        }
	    }
	}




}
