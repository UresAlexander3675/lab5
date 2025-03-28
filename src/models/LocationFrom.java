package models;

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
     */
    public LocationFrom(double x, Integer y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Конструктор LocationFrom по умолчанию
     */
    public LocationFrom(){
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
    public void setY(int y){
        this.y = y;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocationFrom{" + "x=" + x + ", y=" + y + ", name='" + name + '\'' + '}';
    }
}
