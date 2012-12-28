package me.timv.smi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Points {
	/*Explenation: Each person has their own points..but when someone kills a traitor it affects the whole*/
	/*Basically, if you mess up everyone goes down with you. - Ked*/
	int points;
	int karma;
	Player innocent = null;
	Player traitor = null;
	int innocentPoints;
	int innocentKarma;
	static boolean innocentWin;
	static boolean traitorWin;
	static boolean tie;
	static int i;
	public void getPoints() {
		TraitorFunctions.traitorPoints = this.points;
		TraitorFunctions.traitorKarma = this.karma;
		final int traitorPoints = points-karma;
		InnocentFunctions.innocentPoints = this.innocentPoints;
		InnocentFunctions.innocentKarma = this.innocentKarma;
		final int innocentFinal = innocentPoints-innocentKarma;
		if(innocentFinal < traitorPoints) {
			traitorWin = true;
		}
		
		if(traitorPoints > innocentFinal) {
			innocentWin = true;
		}
		
		if(innocentFinal == traitorPoints) {
			tie = true;
		}
		
	}
	
	public void innocentWin() {
		if(innocentPoints > 15) {
			Bukkit.getServer().broadcastMessage("[Trouble In Minetopia] " + innocent.getDisplayName() + "One the game for the Innocent!");
			Bukkit.getServer().broadcastMessage("---------------------------------");
			Bukkit.getServer().broadcastMessage("Winner: " + innocent.getDisplayName() + "");
			Bukkit.getServer().broadcastMessage("Points: " + innocentPoints);
			Bukkit.getServer().broadcastMessage("Karma: " + innocentKarma);
			Bukkit.getServer().broadcastMessage("The Traitors Were: " + TraitorFunctions.traitors);
			Bukkit.getServer().broadcastMessage("Did you have fun? Support our team and our open-source project!");
			for(i = 0;i>Bukkit.getServer().getOnlinePlayers().length;)
			{
				Player[] igpls = Bukkit.getServer().getOnlinePlayers();
				igpls[i].kickPlayer("Server is reloading!");
			}
			Bukkit.getServer().reload(); //Restart the server
		}
	}
	
	public void traitorWin() {
		if(points > 15) {
			Bukkit.getServer().broadcastMessage("[Trouble In Minetopia] " + traitor.getDisplayName() + "One the game for the Traitors!");
			Bukkit.getServer().broadcastMessage("---------------------------------");
			Bukkit.getServer().broadcastMessage("Did you have fun? Support our team and our open-source project!");
			Bukkit.getServer().broadcastMessage("Winner: " + traitor.getDisplayName() + "");
			Bukkit.getServer().broadcastMessage("Points: " + points);
			Bukkit.getServer().broadcastMessage("Karma: " + karma);
			Bukkit.getServer().broadcastMessage("The Other Traitors Were: " + TraitorFunctions.traitors);
						{
				Player[] igpls = Bukkit.getServer().getOnlinePlayers();
				igpls[i].kickPlayer("Server is reloading!");
			}
			Bukkit.getServer().reload(); //Restart the server
		}
	}
}
