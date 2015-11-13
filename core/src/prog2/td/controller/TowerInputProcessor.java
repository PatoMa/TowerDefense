package prog2.td.controller;

import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Game;
import prog2.td.model.Tower.SimpleTower;
import prog2.td.ui.UIManager;

/**
 * Created by Pato on 11/13/15.
 */
public class TowerInputProcessor extends MyInputProcessor implements com.badlogic.gdx.InputProcessor {
    UIManager uiManager;
    Game game;

    public TowerInputProcessor(UIManager uiManager, Game game){
        this.uiManager = uiManager;
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 45){
            game.addTower(new SimpleTower(new Vector2(100, 300), game));
            System.out.println("Tower added");
        }
        return true;
    }
}
