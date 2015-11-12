package prog2.td.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import prog2.td.model.Entity;

/**
 * Created by Pato on 10/31/15.
 */
public class UIEntity<T extends Entity> {

    private T model;
    private Texture texture;


    public UIEntity(Texture texture, T model){
        this.model = model;
        this.texture = texture;
    }

    public void draw(UIManager uiManager) {
        Rectangle r = getModel().getPosition();

        uiManager.getBatch().begin();
        uiManager.getBatch().draw(texture, r.x, r.y, r.getWidth(), r.getHeight());
        uiManager.getBatch().end();

        uiManager.getShapeRenderer().setColor(Color.YELLOW);
        uiManager.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);
        uiManager.getShapeRenderer().rect(r.x, r.y, r.getWidth(), r.getHeight());
        uiManager.getShapeRenderer().end();
    }

    public T getModel() {
        return model;
    }


}
