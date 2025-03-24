package models;

import exceptions.FieldMoreThanConstantException;
import exceptions.NullFieldException;

/**
 * Класс, представляющий конечную точку маршрута
 */
public class LocationFrom {
    private double x;
    private Integer y;
    private String name;

    /**
     * Конструктор LocationFrom
     * @param x координата X
     * @param y координата Y
     * @param name название точки маршрута
     * @throws FieldMoreThanConstantException ошибка, когда поле больше определенной константы
     * @throws NullFieldException ошибка, когда поле - null
     */
    public LocationFrom(double x, Integer y, String name) throws FieldMoreThanConstantException, NullFieldException {
        this.x = x;
        if(!(y == null)){
            this.y = y;
        } else {
            throw new NullFieldException("Coordinate y mustn't be null");
        }
        if(name.length() <= 956){
            this.name = name;
        } else {
            throw new FieldMoreThanConstantException("Name's length must be less than 956");
        }
    }

    /**
     * Конструктор LocationFrom по умолчанию
     * @throws FieldMoreThanConstantException ошибка, когда поле больше определенной константы
     * @throws NullFieldException ошибка, когда поле - null
     */
    public LocationFrom() throws FieldMoreThanConstantException, NullFieldException {
        this.x = 0.0;
        this.y = 0;
        this.name = "default";
    }


    public double getX(){
        return x;
    }
    public Integer getY(){
        return y;
    }
    public String getName(){
        return name;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int x) throws NullFieldException{
        if(!(y == null)){
            this.y = y;
        } else {
            throw new NullFieldException("Coordinate y mustn't be null");
        }
    }
    public void setName(String name) throws FieldMoreThanConstantException{
        if(name.length() <= 956){
            this.name = name;
        } else {
            throw new FieldMoreThanConstantException("Name's length must be less than 956");
        }
    }

    @Override
    public String toString() {
        return "LocationFrom{" + "x=" + x + ", y=" + y + ", name='" + name + '\'' + '}';
    }
}
