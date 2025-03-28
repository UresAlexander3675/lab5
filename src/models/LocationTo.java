package models;

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
     */
    public LocationTo(Long x, Integer y, double z, String name){
        this.z = z;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Конструктор по умолчанию
     */
    public LocationTo(){
        this.x = 0L;
        this.y = 0;
        this.z = 0.0;
        this.name = "default";
    }



    public void setZ(double z){
        this.z = z;
    }
    public void setX(Long x){
        this.x = x;
    }
    public void setY(Integer y){
        this.y = y;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocationTo{" + "x=" + x + ", y=" + y + ", z=" + z + ", name='" + name + '\'' + '}';
    }
}
