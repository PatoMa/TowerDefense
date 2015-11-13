package prog2.td.model.Minion;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Entity;
import prog2.td.model.Game;
import prog2.td.model.Path;

/**
 * Created by Pato on 10/31/15.
 */
public abstract class Minion extends Entity {

    private boolean killed = false;
    private Vector2 velocity;
    private final static float WIDTH = 32;
    private final static float HEIGHT = 51;
    private int hitpoints = 1000;
    private int i = 0;
    private Path path;

    public Minion(Vector2 center, Game game, Path path) {
        super(game);
        getPosition().setHeight(HEIGHT);
        getPosition().setWidth(WIDTH);
        getPosition().setCenter(center);
        this.velocity = new Vector2(1f, 0f);
        this.path = path;
    }

    @Override
    public void update(float timedelta) {
        if (isKilled()) {
            return;
        }
        move();
    }

    private void move() {
        Vector2 vect = new Vector2();
        getPosition().getCenter(vect);
        vect.add(velocity);

        for(int i = 0;i<path.getRectangles().size();i++){
            if(this.getPosition().overlaps(path.getRectangles().get(i))){
                System.out.println("Llego al: " + i);
                if(i==0){
                    velocity.rotate(-90);
                    vect.add(velocity);
                }
                if(i==1){
                    velocity.rotate(90);
                    vect.add(velocity);
                }
                if(i==2){
                    velocity.rotate(90);
                    vect.add(velocity);
                }
                if(i==3){
                    velocity.rotate(-90);
                    vect.add(velocity);
                }
            }

        }


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
        Minion minion = new ZombieMinion(getPosition().getCenter(new Vector2(0,400)), getGame(),path);

        if(minion.velocity.x > 0) {
            minion.velocity.x *= -1;
        }
        getGame().addMinion(minion);
    }

}

