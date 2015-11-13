package prog2.td.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import prog2.td.model.Entity;
import prog2.td.model.GameListener;
import prog2.td.model.Minion.Minion;
import prog2.td.model.Tower.Tower;

import java.util.HashMap;

/**
 * Created by Pato on 10/31/15.
 */
public class UIManager implements GameListener {

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Texture towerTexture;
    private Texture minionTexture;
    private Texture background;
    private final Vector2 boundaries = new Vector2(600, 400);

    private HashMap<Entity, UIEntity> entities = new HashMap<Entity, UIEntity>();

    private OrthographicCamera camera;

    public Vector2 getBoundaries() {
        return this.boundaries;
    }
    public UIManager() {
        background = new Texture("assets/background.png");
        towerTexture = new Texture("assets/plant.png");
        minionTexture = new Texture("assets/zombie.png");


        camera = new OrthographicCamera();
        camera.setToOrtho(false, boundaries.x, boundaries.y);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

    }

    public void draw() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
        camera.update();
        //batch.setProjectionMatrix(camera.combined);


        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        for(UIEntity uiEntity: entities.values()) {
            uiEntity.draw(this);
        }


    }

    @Override
    public void minionKilled(Minion minion) {
        entities.remove(minion);
    }

    @Override
    public void towerAdded(Tower tower) {
        entities.put(tower, new UITowerEntity<Tower>(towerTexture, tower));
    }

    @Override
    public void minionAdded(Minion minion) {
        entities.put(minion, new UIEntity<Minion>(minionTexture, minion));
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }
}
