package me.timv.smi;
import java.net.InetSocketAddress;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;


public class TIMVPlayerJoinListener implements Listener{
 private TIMV plugin;
 private int p;
 Player ep = null;
  private GameStartHandler gsh = new GameStartHandler(plugin);

public TIMVPlayerJoinListener(TIMV plugin, int p)
 {
	 this.plugin = plugin;
	 this.p = p;
	 plugin.getServer().getPluginManager().registerEvents(this, plugin);
 }

  @EventHandler
 public void onPlayerLogin(PlayerLoginEvent event) {	  	
  p++;
  if(gsh.isStarted() == false)
{
   p++;
   String dep = ep.getDisplayName();
   plugin.getConfig().addDefault("player.passes." + ep, 0);
   plugin.getConfig().options().copyDefaults(true);
   plugin.saveConfig();
     gsh.start();
}else{
ep.kickPlayer("Server is Ingame");
}
}
}
