
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.*;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;
import sun.org.mozilla.javascript.internal.ContextFactory;

import java.awt.*;

/**
 * Created by Thamar on 16.06.2015.
 */
public class CowShooterListener implements Listener {
    private Plugin plugin;
    public CowShooterListener(JavaPlugin myPlugin){
        plugin = myPlugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        //if either air or an block has been clicked with left mousebutton
            if(event.getAction()== Action.LEFT_CLICK_AIR || event.getAction()==Action.LEFT_CLICK_BLOCK) {
                Player p=event.getPlayer();
                if(p.getItemInHand().getType()== Material.LEATHER){
                    Location l=p.getLocation();
                    Vector v=l.getDirection();
                    l.setY(l.getY()+1);

                    v.multiply(3);

                    Cow c= p.getWorld().spawn(l,Cow.class);

                    PotionEffect potion= new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE,1);
                    c.addPotionEffect(potion);
                    c.setVelocity(v);
                    c.setFireTicks(100);

                    //start the cow task
                    BukkitRunnable task=new CowTask(p.getWorld(),c);
                    task.runTaskTimer(plugin,0L,0L);



                }
            }
    }





}

