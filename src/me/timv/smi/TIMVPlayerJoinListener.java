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
 public void onPlayerLogin(PlayerJoinEvent event) {	  	
  p++;
  if(gsh.isStarted() == false)
{
if(plugin.getServer().getOnlinePlayers().lenght == 23)
{
	gsh.setStarted(true);
	// is it implemented? When not pls change it
	pl.assagin();
	// Right spelling?
	// pls export it and hand it to me via mediafire
}
}else{
ep.kickPlayer("Server is Ingame");
}
}
}
