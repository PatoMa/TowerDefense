package prog2.td.model.Tower.Projectile;

/**
 * Created by Pato on 11/13/15.
 */
public class Bomb extends Projectile{
    private double range;

    public Bomb(){
        damage = 10;
        range = 10;
    }

    public double getRange(){
        return range;
    }
}
