package view;

import java.awt.*;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MemoryElementView {

    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private boolean withInsideDescription = false;
    private boolean onePiece = false;
    private boolean visible = false;

    private int fromPoint;
    private int toPoint;

    public MemoryElementView(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isOnePiece() {
        return onePiece;
    }

    public void setOnePiece(boolean onePiece) {
        this.onePiece = onePiece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(int fromPoint) {
        this.fromPoint = fromPoint;
    }

    public int getToPoint() {
        return toPoint;
    }

    public void setToPoint(int toPoint) {
        this.toPoint = toPoint;
    }

    public boolean isWithInsideDescription() {
        return withInsideDescription;
    }

    public void setWithInsideDescription(boolean withInsideDescription) {
        this.withInsideDescription = withInsideDescription;
    }
}

