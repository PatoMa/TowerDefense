package prog2.td.model;

/**
 * Created by Pato on 10/31/15.
 */
public class Player {
    private int money;
    private int lives;
    private int level;

    public Player() {
        money = 0;
        level = 1;
        lives = 50;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int x) {
        money += x;
    }

    public void spendMoney(int x) {
        money -= x;
    }

    public boolean isOver() {
        return lives <= 0;
    }

    public void spendLife() {
        lives--;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLives() {
        return lives;
    }

    public void printString(){
        System.out.println("Vida: " + getLives() + " Plata: " + getMoney());
    }

    public void setLives(int i) {
        System.out.println("L"+i);
        lives = i;
    }
}
