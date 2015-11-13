package prog2.td.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Minion.Minion;
import prog2.td.model.Tower.Tower;
import prog2.td.model.Tower.TowerDart;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pato on 10/31/15.
 */
public class Game {
    private Collection<Tower> towers = new HashSet<Tower>();
    private Collection<Minion> minions = new HashSet<Minion>();

    private List<GameListener> listeners = new LinkedList<GameListener>();

    private Vector2 boundaries;
    private Player player = new Player();
    private Path path = new Path();

    public Game(Vector2 boundaries) {
        this.boundaries = boundaries;
    }

    public void init() {
        addTower(new TowerDart(new Vector2(200, 200), this));
        addMinion(new Minion(new Vector2(0, 120), this));
    }

    public void update(Graphics graphics) {
        for(Tower t: towers) {
            t.update(graphics.getDeltaTime());
        }
        for(Minion m: minions) {
            m.update(graphics.getDeltaTime());
            if (m.isKilled()) {
                minions.remove(m);
                for (GameListener gl: listeners)
                    gl.minionKilled(m);
            }
        }
    }

    public Vector2 getBoundaries() {
        return boundaries;
    }

    public List<Minion> getMinionsInRange(Tower tower) {
        List<Minion> ret = new LinkedList<Minion>();

        for(Minion m:minions) {
            if (tower.getDistance(m) < tower.getRange()) {
                ret.add(m);
            }
        }
        return ret;
    }

    public void addTower(Tower tower) {
        this.towers.add(tower);
        for(GameListener gl: listeners)
            gl.towerAdded(tower);
    }

    public void addMinion(Minion minion) {
        minions.add(minion);
        for(GameListener gl: listeners)
            gl.minionAdded(minion);

    }

    public void addGameListeners(GameListener gameListener) {
        listeners.add(gameListener);
    }

}
