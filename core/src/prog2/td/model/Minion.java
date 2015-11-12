package prog2.td.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Pato on 10/31/15.
 */
public class Minion extends Entity {

    private boolean killed = false;
    private Vector2 velocity;
    private final static float WIDTH = 32;
    private final static float HEIGHT = 51;
    private int hitpoints = 100;

    public Minion(Vector2 center, Game game) {
        super(game);
        getPosition().setHeight(HEIGHT);
        getPosition().setWidth(WIDTH);
        getPosition().setCenter(center);
        this.velocity = new Vector2(-1f, -0.1f);
    }

    @Override
    public void update(float timedelta) {
        if (isKilled()) {
            return;
        }
        Vector2 vect = new Vector2();
        getPosition().getCenter(vect);

        vect.add(velocity);

        checkBoundaries(vect);

        getPosition().setCenter(vect);
    }

    private void checkBoundaries(Vector2 vect) {
        Vector2 bounds = getGame().getBoundaries();

        if(vect.x > bounds.x) {
            vect.x = 0;
        }
        if(vect.x < 0) {
            vect.x = bounds.x;
        }
        if(vect.y > bounds.y) {
            vect.y = 0;
        }
        if(vect.y < 0) {
            vect.y = bounds.y;
        }
    }

    public boolean isKilled() {
        return killed;
    }

    public void damage(int damage) {
        hitpoints--;
        if(hitpoints <= 0) {
            killed = true;
        }
        System.out.println("Being attacked!");
    }

    public void death() {
        Minion minion = new Minion(getPosition().getCenter(new Vector2()), getGame());

        if(minion.velocity.x > 0) {
            minion.velocity.x *= -1;
        }
        getGame().addMinion(minion);
    }

}

