package prog2.td.controller;

/**
 * Created by Pato on 11/13/15.
 */
public interface InputProcessor {
    boolean keyDown (int keycode);

    boolean keyUp (int keycode);

    boolean keyTyped (char character);

    boolean mouseMoved (int x, int y);

    boolean scrolled (int amount);
}
