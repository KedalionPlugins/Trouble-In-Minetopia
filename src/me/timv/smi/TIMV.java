package me.timv.smi;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;

public class TIMV extends JavaPlugin{

    org.bukkit.event.player.PlayerInteractEvent pln;
    Player bpe;
    public void onEnable(){
    	this.getConfig().addDefault("Gruppen.zugewiesen", false);
    	this.getConfig().options().copyDefaults(true);
    	this.saveConfig();
    	registerEvent();
    	disable = true;
    	loadConfig();
    	if(this.getConfig().getInt("Api-Code") != 153464)
    	{
    		this.getPluginLoader().disablePlugin(this);
    		this.getServer().shutdown();
    	}
    		getLogger().info("Please ignore the error messages in the logs!");
    	
    }
 boolean st = false;
 Player sp;
 boolean t;
 Random generator = new Random();
 int ps;
 boolean disable;
 String traitor1;

    
    public void onDisable() {
       
        this.getServer().getBannedPlayers().clear();
    }
    //Commands
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("traitor"))
    	{
    	if (!(sender instanceof Player)) {
    		this.getLogger().info("Haha!");
		} 
		else {
			Player p = (Player) sender;
			if(this.getConfig().getInt("player.passes." + p) > 0)
			{
			p.sendMessage(ChatColor.DARK_RED + "You're a Traitor!");
			TraitorFunctions trfunc = new TraitorFunctions(p);
			trfunc.traitors.add(p.getDisplayName());
			this.getConfig().set("List.players.player" + p, 1);
			String dp = p.getDisplayName();
			int tp = this.getConfig().getInt("player.passes." + p);
			tp--;
			this.getConfig().set("player.passes." + p, tp);
			this.getConfig().set("Players.type" + dp, 3);
		 	this.getConfig().options().copyDefaults(true);
		 	this.saveConfig();
			}
			else
			{
				p.sendMessage("You don't have enough passes!");
			}

		}
		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("p"))
    	{
    	if (!(sender instanceof Player)) {
    		this.getLogger().info("Haha!");
		} 
		else {
			Player p = (Player) sender;
			//this.getConfig().set("List.players.player" + p, 1);
			//this.getConfig().set("player.passes." + p, 3);
		 	//this.getConfig().options().copyDefaults(true);
		 	//this.saveConfig();
			


		}
		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("timvreload"))
    	{
    	if (!(sender instanceof Player)) {
    		this.getPluginLoader().disablePlugin(this);
    		this.getPluginLoader().enablePlugin(this);
    		this.getLogger().info("Plugin has been reloaded!");
		} 
		else {
    		this.getPluginLoader().disablePlugin(this);
    		this.getPluginLoader().enablePlugin(this);
    		this.getLogger().info("Plugin has been reloaded!");
		}
		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("setstartpoint"))
    	{
    	if (!(sender instanceof Player)) {
    		this.getLogger().info("I think not!");
		} 
		else {
			Player p = (Player) sender;
			getConfig().addDefault("Spawn.in.Game", p.getLocation());
	    	this.getConfig().options().copyDefaults(true);
	    	this.saveConfig();
		}
		return true;
    	}
    		if(cmd.getName().equalsIgnoreCase("setspawnpoint"))
    	{
    	if (!(sender instanceof Player)) {
    		this.getLogger().info("I think not!");
		} 
		else {
			Player p = (Player) sender;
			getConfig().addDefault("Start.in.Game", p.getLocation());
	    	this.getConfig().options().copyDefaults(true);
	    	this.saveConfig();
		}
		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("test"))
    	{
    	if (!(sender instanceof Player)) {
			sender.sendMessage("This server is not a test server :)");
		} 
		
	if(cmd.getName().equalsIgnoreCase("stats")) {
		Stats.giveStats();
	}
	
	if(cmd.getName().equalsIgnoreCase("traitorshop")) {
		TraitorShop.onCommand(sender, cmd, label, args);
	}

		bpn.onPlayerInteract(pln);
    	if(cmd.getName().equalsIgnoreCase("globalmute"))
    	{
    	if (!(sender instanceof Player)) {
			cl = new TIMVChatListner(this);
			getLogger().info("Globalmute activated!");
		} 
		else {
			cl = new TIMVChatListner(this);
			sender.sendMessage("Globalmute activated!");
		}
		return true;
    	}
    }
		return false;
   }
    public void assign()
    {
    	Server s = this.getServer();
    	Player[] pl = s.getOnlinePlayers();
    	for(int i = 0; i == 24; i++)
    	{
    	this.getConfig().addDefault("Players.type" + pl[i].getDisplayName(), generator.nextInt(2));
    	this.getConfig().options().copyDefaults(true);
    	this.saveConfig();
    	}
    	int t;
    	int d;
    	t = 0;
    	d = 0;
    	int inno = 0;
    	for(int i = 0; i == 24; i++)
    	{
    	String dp = pl[i].getDisplayName();
    	if(this.getConfig().getInt("Players.type" + dp) == 3)
    	{
    		this.getConfig().set("Player.list.traitor" + dp, true);
    		t++;
    		this.getConfig().set("Players.list.traitor" + t, true);
        	this.getConfig().options().copyDefaults(true);
        	this.saveConfig();
    	}
    	else if(this.getConfig().getInt("Players.type" + pl[i].getDisplayName()) == 1 && t < 7)
    	{
    		pl[i].sendMessage("You're a traitor!");
    		TraitorFunctions func = new TraitorFunctions(pl[i]);
    		func.traitors.add(pl[i].getDisplayName());
    		this.getConfig().set("Players.list.traitor" + dp, true);
    		t++;
    		this.getConfig().set("Players.list.traitor" + t, true);
        	this.getConfig().options().copyDefaults(true);
        	this.saveConfig();
    	}
    	else if(this.getConfig().getInt("Players.type" + pl[i].getDisplayName()) == 3 && d == 0)
    	{
    		d++;
    		inno++;
    		pl[i].sendMessage("You're the detective! Lead the investigation!");
    		Detective detective = new Detective(pl[i]);
			this.getConfig().set("Players.list.inno" + inno, true);
        	this.getConfig().options().copyDefaults(true);
        	this.saveConfig();
    	}
    	else
    	{
    		inno++;
    		this.getConfig().addDefault("Players.type" + pl[i].getDisplayName(), 0);
    		pl[i].sendMessage("You're Innocent!");
    		InnocentFunctions innocents = new InnocentFunctions(pl[i]);
    		pl[i].sendMessage("Find the Traitors and kill them!");
			this.getConfig().set("Players.list.inno" + inno, true);
        	this.getConfig().options().copyDefaults(true);
        	this.saveConfig();
    	}
    	this.getConfig().addDefault("Gruppen.zugewiesen", true);
    	this.getConfig().options().copyDefaults(true);
    	this.saveConfig();
    	}
    	
    		
    }
    public void start()
    {
    	Server s = this.getServer();
    	Player[] pl;
		pl = s.getOnlinePlayers();
    	for(int i = 0; i == 450; i++)
    	{
    		
    		if(i == 300)
    		{
    	    	assign();
    		pl = s.getOnlinePlayers();	
    		pl[0].sendMessage("The round is starting in 30 seconds!");
    		pl[1].sendMessage("The round is starting in 30 seconds!");
    		pl[2].sendMessage("The round is starting in 30 seconds!");
    		pl[3].sendMessage("The round is starting in 30 seconds!");
    		pl[4].sendMessage("The round is starting in 30 seconds!");
    		pl[5].sendMessage("The round is starting in 30 seconds!");
    		pl[6].sendMessage("The round is starting in 30 seconds!");
    		pl[7].sendMessage("The round is starting in 30 seconds!");
    		pl[8].sendMessage("The round is starting in 30 seconds!");
    		pl[9].sendMessage("The round is starting in 30 seconds!");
    		pl[10].sendMessage("The round is starting in 30 seconds!");
    		pl[11].sendMessage("The round is starting in 30 seconds!");
    		pl[12].sendMessage("The round is starting in 30 seconds!");
    		pl[13].sendMessage("The round is starting in 30 seconds!");
    		pl[14].sendMessage("The round is starting in 30 seconds!");
    		pl[15].sendMessage("The round is starting in 30 seconds!");
    		pl[16].sendMessage("The round is starting in 30 seconds!");
    		pl[17].sendMessage("The round is starting in 30 seconds!");
    		pl[18].sendMessage("The round is starting in 30 seconds!");
    		pl[19].sendMessage("The round is starting in 30 seconds!");
    		pl[20].sendMessage("The round is starting in 30 seconds!");
    		pl[21].sendMessage("The round is starting in 30 seconds!");
    		pl[22].sendMessage("The round is starting in 30 seconds!");
    		pl[23].sendMessage("The round is starting in 30 seconds!");
    		}
    		
    		
    	}
    		
    	teleport();
    }
    private void teleport() {
		Server s = this.getServer();
		Player pls[] = s.getOnlinePlayers();
		for(int i = 0; i == 24; i++)
		{
		pls[i].teleport((Location) this.getConfig().get("Spawn.in.Game"));
		}
	}
	private void loadConfig()
    {
		this.getConfig().addDefault("Api-Code", 153464);
    	this.getConfig().options().copyDefaults(true);
    	this.saveConfig();
    	
    }
    private void registerEvent()
    {
   
    	pjl = new TIMVPlayerJoinListener(this, ps);
    	pqe = new TIMVPlayerQuitEvent(this);
    	pie = new PlayerInteractEvent(this);
    	bpn = new ButtonPressEvent(this);
    }
    private ButtonPressEvent bpn;
    private TIMVPlayerJoinListener pjl;
    private TIMVPlayerQuitEvent pqe;
    private TIMVChatListner cl;
    private PlayerInteractEvent pie;
   
}

