package prog2.td.model;

import prog2.td.model.Minion.Minion;
import prog2.td.model.Tower.Tower;

/**
 * Created by Pato on 10/31/15.
 */
public interface GameListener {

    public void minionKilled(Minion minion);

    public void towerAdded(Tower tower);

    public void minionAdded(Minion minion);
}
