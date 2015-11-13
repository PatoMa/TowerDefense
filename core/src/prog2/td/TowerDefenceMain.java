package prog2.td;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import prog2.td.controller.TowerInputProcessor;
import prog2.td.model.Game;
import prog2.td.ui.UIManager;

public class TowerDefenceMain extends ApplicationAdapter {

	private Game game;
	private UIManager uiManager;
	private TowerInputProcessor towerInputProcessor;


	@Override
	public void create () {
		uiManager = new UIManager();
		game = new Game(uiManager.getBoundaries());
		towerInputProcessor = new TowerInputProcessor(uiManager, game);
		game.addGameListeners(uiManager);
		game.init();
	}

	@Override
	public void render () {
		uiManager.draw();
		Gdx.input.setInputProcessor(towerInputProcessor);
		game.update(Gdx.graphics);



	}
}

