package timothee38.rsmasher;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;


public class rsmasher extends JavaPlugin{
	public ScoreboardManager sbManager;
	public Scoreboard sboard;
	public Team red;
	public Team blue;
	public Team obs;
	public Objective obj;
	public Score reds;
	public Score blues;
	public Score score;
	public Score score2;
	public Score sc;
	public Player p;
	
	@Override
	public void onEnable(){
		System.out.println("[RSmasher] Demarrage de Redstone Smasher");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerCommand(this), this);

		
		
		sbManager = Bukkit.getScoreboardManager();
		sboard = sbManager.getNewScoreboard();
		
		red = sboard.registerNewTeam("red");
		blue = sboard.registerNewTeam("blue");
		obs = sboard.registerNewTeam("observers");
		
		red.setPrefix(ChatColor.DARK_RED + "");
		blue.setPrefix(ChatColor.DARK_BLUE + "");
		obs.setPrefix(ChatColor.AQUA + "");
		
		obj = sboard.registerNewObjective("test", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.GREEN + "Objectifs");

		
		reds = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "Rouges"));
		reds.setScore(4);
		
		score = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "RRouge"));
		score.setScore(3);
		
		sc = obj.getScore(Bukkit.getOfflinePlayer(" "));
		sc.setScore(2);

		blues = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_BLUE + "Bleus"));
		blues.setScore(1);
		
		score2 = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "RBleu"));
		score2.setScore(0);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			player.setScoreboard(sboard);
			obs.addPlayer(player);
			p.setAllowFlight(true);
		}		
	}
	

	
	public void onDisable(){
		System.out.println("[RSmasher] Arret de Redstone Smasher");		
		
	}


	
	@EventHandler (priority = EventPriority.LOWEST)
	public void blockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();

		if(e.getBlock().getType().equals(Material.REDSTONE_BLOCK)){
			p.sendMessage(ChatColor.RED + "à cassé le bloc de redstone !");
					
		}
	}
}
