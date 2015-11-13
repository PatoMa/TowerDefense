package prog2.td.model.Tower;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Game;
import prog2.td.model.Tower.Projectile.SimpleProjectile;
import prog2.td.model.Tower.Tower;

/**
 * Created by Pato on 10/31/15.
 */
public class TowerDart extends Tower {
    public TowerDart(Vector2 center, Game game) {
        super(center, game, 100, 1, new SimpleProjectile());
    }
}
