import net.minecraft.server.v1_7_R4.BlockMobSpawner;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Thamar on 16.06.2015.
 */
public class CowShooter extends JavaPlugin{
    public static Logger log =Logger.getLogger("Minecraft");

    public void onEnable(){
        log.info("[CowShooter] enabling...");
        getServer().getPluginManager().registerEvents(new CowShooterListener(this),this);
    }


}
