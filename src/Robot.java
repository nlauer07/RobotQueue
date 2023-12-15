/*
 * Written by Nick Lauer
 */
public class Robot {
    private int x, y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    // Getter methods for encapsulation
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
}