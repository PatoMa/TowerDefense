package prog2.td.model.Tower;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Entity;
import prog2.td.model.Game;
import prog2.td.model.Minion.Minion;
import prog2.td.model.Tower.Projectile.Projectile;

import java.util.List;

/**
 * Created by Pato on 10/31/15.
 */
public abstract class Tower extends Entity {
    private float range;
    private float delay;
    private float timer = 0;
    protected Projectile projectile;
    private static final float WIDTH = 32;
    private static final float HEIGHT = 33;
    private int upgradeSpeed = 0;
    private int upgradeRange = 0;
    private int upgradeDamage = 0;

    private Minion target;

    public Tower(Vector2 center, Game game, float range, float delay, Projectile projectile) {
        super(game);
        getPosition().setHeight(HEIGHT);
        getPosition().setWidth(WIDTH);
        getPosition().setCenter(center);
        this.range = range;
        this.delay= delay;
        this.projectile = projectile;
    }


    @Override
    public void update(float timedelta) {
        timer += timedelta;

        if(timer > delay) {
            if(target != null && getDistance(target) > range) {
                target = null;
            }


            if(target == null || target.isKilled()) {
                List<Minion> inRange = getGame().getMinionsInRange(this);

                if (!inRange.isEmpty()) {
                    target = inRange.get(0);
                }
            }

            if(target != null && !target.isKilled()) {
                attack(target);

                if(target.isKilled()) {
                    target = null;
                }

            }
            timer = 0;
        }

    }

    public void upgradeRange(){
        upgradeRange++;
        setRange(getRange()*2);
    }

    public boolean isAttacking() {
        return target != null && !target.isKilled();
    }

    public void attack(Minion minion) {
        minion.damage(projectile.getDamage());
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

}
