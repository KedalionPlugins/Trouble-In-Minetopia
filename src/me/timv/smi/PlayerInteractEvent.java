package me.timv.smi;
import me.timv.smi.PlayerInteractEvent;


import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
public class PlayerInteractEvent implements Listener{
	 //private TIMV plugin;
	 Random generator = new Random();
	public PlayerInteractEvent(TIMV plugin)
	 {
		// this.plugin = plugin;
		 plugin.getServer().getPluginManager().registerEvents(this, plugin);
	 }

	    @EventHandler
	    public void onInventoryOpenEvent(InventoryOpenEvent e){
	        if (e.getInventory().getHolder() instanceof Chest){
	            Player ep = (Player) e.getPlayer();
	            int gn = generator.nextInt(4);
	        if(gn == 0)
	        {
        		ep.closeInventory();
	        	ep.getInventory().addItem(new ItemStack(262, 64));
	        	ep.getInventory().addItem(new ItemStack(261));
	        }
	        else if(gn == 1)
	        {
        		ep.closeInventory();
	        	ep.getInventory().addItem(new ItemStack(268));		
	        }
	        else if(gn == 2)
	        {
        		ep.closeInventory();
	        	ep.getInventory().addItem(new ItemStack(272));		
	        }
	        else if(gn == 3)
	        {
        		ep.closeInventory();
	        	ep.getInventory().addItem(new ItemStack(267));		
	        }
	        
	        }
	        else if(e.getInventory().getHolder() instanceof DoubleChest)
	        {
	        	Player ep = (Player) e.getPlayer();
	        	if(generator.nextInt(10000) == 5000)
	        	{
	        	ep.closeInventory();
	        	ep.getInventory().addItem(new ItemStack(276));
	        	}
	        	else
	        	{
	        		if(!(ep.getHealth() == 20))
	        		{
		        	ep.closeInventory();
	        		ep.setHealth(0);
	        		Location bs = ep.getBedSpawnLocation();
	        		ep.teleport(bs);

	        		}
	        		}
	        		ep.setHealth(1);
	        	}
	        }
	    }
