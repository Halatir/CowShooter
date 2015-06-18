import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Cow;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Thamar on 16.06.2015.
 */
public class CowTask extends BukkitRunnable{
   private World world;
    private Cow c;

    public CowTask(World myWorld, Cow myCow) {
        c=myCow;
        world=myWorld;
    }
    public void run(){
        Location l=c.getLocation();
        l.setY(l.getY()-0.3);
        Block b= l.getBlock();
        if(b.getType()!=Material.AIR){
            world.createExplosion(l,10);
        }
    }
}
