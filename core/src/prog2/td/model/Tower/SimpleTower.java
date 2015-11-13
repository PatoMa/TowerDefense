package prog2.td.model.Tower;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Game;
import prog2.td.model.Tower.Projectile.SimpleProjectile;

/**
 * Created by Pato on 11/13/15.
 */
public class SimpleTower extends Tower {
    public SimpleTower(Vector2 center, Game game){
        super(center, game);
        projectile = new SimpleProjectile();
    }
}
