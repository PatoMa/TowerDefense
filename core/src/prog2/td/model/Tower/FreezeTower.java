package prog2.td.model.Tower;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Game;
import prog2.td.model.Tower.Projectile.FreezeRay;

/**
 * Created by Pato on 11/13/15.
 */
public class FreezeTower extends Tower{
    public FreezeTower(Vector2 center, Game game){
        super(center, game);
        projectile = new FreezeRay();
    }
}
