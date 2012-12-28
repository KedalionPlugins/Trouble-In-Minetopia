package me.timv.smi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
public class TIMVChatListner implements Listener{


	
		// private TIMV plugin;

		 public TIMVChatListner(TIMV plugin)
		  {
		 	// this.plugin = plugin;
		 	 plugin.getServer().getPluginManager().registerEvents(this, plugin);
		  }

		   

		@EventHandler
		 public void onPlayerChatEvent(PlayerChatEvent event)
		   {
		 	 event.setCancelled(true);
		 	 event.getPlayer().sendMessage("Globalmute is active!");

		   }




		 }

