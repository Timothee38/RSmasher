package timothee38.rsmasher;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class PlayerCommand implements Listener {
	Plugin plugin;
	rsmasher myMasher = new rsmasher();
	public PlayerCommand(rsmasher rsmasher) {
		this.plugin = rsmasher;
	}
	
	public void onPlayerCommand(PlayerCommandPreprocessEvent v){
		Player pl = v.getPlayer();
		String msg = v.getMessage();
		String[] args = msg.split(" ");
		
		if(args[0].equalsIgnoreCase("/join")){
			System.out.println("test");
			myMasher.red.addPlayer(pl);
		}
	}

}
