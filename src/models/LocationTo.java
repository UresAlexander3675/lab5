package models;

import exceptions.*;

/**
 * Класс, представляющий место, от которого идет маршрут
 */
public class LocationTo {
    private Long x;
    private Integer y;
    private double z;
    private String name;

    /**
     * Конструктор LocationTo
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     * @param name название места
     * @throws NullFieldException ошибка, когда поле - null
     */
    public LocationTo(Long x, Integer y, double z, String name) throws NullFieldException {
        this.z = z;
        if(!(x == null)){
            this.x = x;
        } else {
            throw new NullFieldException("Coordinate x mustn't be null");
        }
        if(!(y == null)){
            this.y = y;
        } else {
            throw new NullFieldException("Coordinate y mustn't be null");
        }
        if(!(name.isEmpty() || name == null)){
            this.name = name;
        } else {
            throw new FieldMoreThanConstantException("Name mustn't be empty or null");
        }
    }

    /**
     * Конструктор по умолчанию
     * @throws NullFieldException ошибка. когда поле - null
     */
    public LocationTo() throws NullFieldException {
        this.x = 0L;
        this.y = 0;
        this.z = 0.0;
        this.name = "default";
    }



    public void setZ(double z){
        this.z = z;
    }
    public void setX(Long x) throws NullFieldException{
        if(!(x == null)){
            this.x = x;
        } else {
            throw new NullFieldException("Coordinate x mustn't be null");
        }
    }
    public void setY(Integer y) throws NullFieldException{
        if(!(y == null)){
            this.y = y;
        } else {
            throw new NullFieldException("Coordinate y mustn't be null");
        }
    }
    public void setName(String name) throws FieldMoreThanConstantException{
        if(!(name.isEmpty() || name == null)){
            this.name = name;
        } else {
            throw new FieldMoreThanConstantException("Name mustn't be empty or null");
        }
    }

    @Override
    public String toString() {
        return "LocationTo{" + "x=" + x + ", y=" + y + ", z=" + z + ", name='" + name + '\'' + '}';
    }
}
