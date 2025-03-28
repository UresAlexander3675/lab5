package models;


/**
 * Класс, представляющий координаты маршрута
 */
public class Coordinates {
    private int x;
    private float y;

    /**
     * Конструктор Coordinates
     * @param x координата X
     * @param y координата Y
     */
    public Coordinates(int x, float y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){
        this.x = 0;
        this.y = 0.0f;
    }


    public int getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}
