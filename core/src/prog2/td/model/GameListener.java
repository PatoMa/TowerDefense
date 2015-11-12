package prog2.td.model;

/**
 * Created by Pato on 10/31/15.
 */
public interface GameListener {

    public void minionKilled(Minion minion);

    public void towerAdded(Tower tower);

    public void minionAdded(Minion minion);
}
