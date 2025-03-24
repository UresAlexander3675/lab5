package models;

import exceptions.*;

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
     * @throws FieldMoreThanConstantException ошибка, когда поле больше определенной константы
     */
    public Coordinates(int x, float y) throws FieldMoreThanConstantException {
        if(x <= -372){
            throw new FieldMoreThanConstantException("Coordinate x must be more, than -372");
        }
        if(y <= -527){
            throw new FieldMoreThanConstantException("Coordinate y be more, than -527");
        }
        this.x = x;
        this.y = y;
    }

    public Coordinates() throws FieldMoreThanConstantException {
        this.x = 0;
        this.y = 0.0f;
    }


    public int getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(int x) throws FieldMoreThanConstantException{
        if(x <= -372){
            throw new FieldMoreThanConstantException("Coordinate x must be more, than -372");
        }
        this.x = x;
    }
    public void setY(float y) throws FieldMoreThanConstantException{
        if(y <= -527){
            throw new FieldMoreThanConstantException("Coordinate y must be more, than -527");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}
