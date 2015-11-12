package prog2.td.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Pato on 10/31/15.
 */
public abstract class Entity {
    private Rectangle position = new Rectangle();
    private Game game;

    public Entity(Game game) {
        this.game = game;
    }


    protected Game getGame() {
        return this.game;
    }

    public abstract void update(float timedelta);

    public Rectangle getPosition() {
        return position;
    }

    public float getDistance(Entity entity) {
        Vector2 own = this.getPosition().getCenter(new Vector2());
        Vector2 other = entity.getPosition().getCenter(new Vector2());

        return own.dst(other);
    }

}
