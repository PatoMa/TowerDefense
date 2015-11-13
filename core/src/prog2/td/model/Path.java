package prog2.td.model;

import com.badlogic.gdx.math.Rectangle;

import java.util.LinkedList;

/**
 * Created by Pato on 11/13/15.
 */
public class Path {
    private LinkedList<Rectangle> rectangleList;

    public Path(){
        rectangleList = new LinkedList<Rectangle>();
        addRectangle(new Rectangle(200,100,50,50));
        addRectangle(new Rectangle(180,400,50,50));
        addRectangle(new Rectangle(500,350,50,50));
        addRectangle(new Rectangle(480,100,50,50));
    }

    public void addRectangle(Rectangle rectangle) {
        rectangleList.add(rectangle);
    }

    public LinkedList<Rectangle> getRectangles(){
        return rectangleList;
    }
}
