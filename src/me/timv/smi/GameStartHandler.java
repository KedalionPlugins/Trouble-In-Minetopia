package me.timv.smi;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GameStartHandler {
  public TIMV pl;
    int cd = 90;
	int igpls;
	Player[] pls;
	public boolean started = false;
	public GameStartHandler(TIMV timv) {
		this.pl = timv;
	}
	public void start()
	{
		 pls = pl.getServer().getOnlinePlayers();
		 igpls = pls.length;
		if(igpls == 0)
		{
			start();
		}
		if(igpls > 1)
		{
			
			while(igpls < 6)
			{
				
				pls = pl.getServer().getOnlinePlayers();
				igpls = pls.length;
				pl.getServer().broadcastMessage("You need 6 Players to start the Game.");
				pl.getServer().broadcastMessage("There are " + igpls + "/24 Players online");
			}
			pls = pl.getServer().getOnlinePlayers();
			igpls = pls.length;
			pl.getServer().broadcastMessage("You need 6 Players to start the Game.");
			pl.getServer().broadcastMessage("There are " + igpls + "/24 Players online");
			pl.getServer().getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {
				public void run()
				{
		            switch (cd){
		            case 90: Bukkit.getServer().broadcastMessage("The Game starts in 1:30 Minutes. There are " + getIngamePlayers() + "/24 Players online.");
		            break;
		            case 30: Bukkit.getServer().broadcastMessage("The Game starts in 30 Minutes. There are " + getIngamePlayers() + "/24 Players online.");
		            break;
		            case 0: Bukkit.getServer().broadcastMessage("The Game has started. There are " + getIngamePlayers() + "/24 Players online.");
		            break;
		            }
		            cd--;
		            }

				
		        },0L, 20L);
		started = true;
            pl.assign();
            }
			
	}

		
	public int getIngamePlayers()
	{
		pls = pl.getServer().getOnlinePlayers();
		igpls = pls.length;
		return igpls;
	}
	
	
	public boolean isStarted()
	{
return started;
	}  
}
        
	


