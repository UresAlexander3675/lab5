package models;

import exceptions.*;
import java.util.*;

public class Route implements Comparable<Route>{
    private Long id;
    private String name;
    private Coordinates coordinates;
    private final Date creationDate;
    private LocationFrom from;
    private LocationTo to;
    private double distance;

    public Route(Long id, String name, Coordinates coordinates, LocationFrom from, LocationTo to, double distance) throws NullFieldException, FieldMoreThanConstantException {
        this.creationDate = new Date();
        if(!(id == null)){
            this.id = id;
        } else {
            throw new NullFieldException("ID mustn't be null");
        }
        if(!(coordinates == null)){
            this.coordinates = coordinates;
        } else {
            throw new FieldMoreThanConstantException("Coordinates mustn't be null");
        }
        if(!(name == null)){
            this.name = name;
        } else {
            throw new NullFieldException("Name mustn't be null");
        }
        if(!(from == null)){
            this.from = from;
        } else {
            throw new NullFieldException("Location from mustn't be null");
        }
        if(!(to == null)){
            this.to = to;
        } else {
            throw new NullFieldException("Location to mustn't be null");
        }
        if(distance > 1){
            this.distance = distance;
        } else {
            throw new FieldMoreThanConstantException("Distance must be more, than 1");
        }
    }

    public Route(){
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public LocationTo getTo() {
        return to;
    }

    public LocationFrom getFrom() {
        return from;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setName(String name) throws NullFieldException {
        if(!(name == null)){
            this.name = name;
        } else {
            throw new NullFieldException("Name mustn't be null");
        }
    }

    public void setDistance(double distance) throws FieldMoreThanConstantException {
        if(distance > 1){
            this.distance = distance;
        } else {
            throw new FieldMoreThanConstantException("Distance must be more, than 1");
        }
    }

    public void setTo(LocationTo to) throws NullFieldException{
        if(!(to == null)){
            this.to = to;
        } else {
            throw new NullFieldException("Location to mustn't be null");
        }
    }

    public void setFrom(LocationFrom from) throws NullFieldException{
        if(!(from == null)){
            this.from = from;
        } else {
            throw new NullFieldException("Location from mustn't be null");
        }
    }

    public void setId(Long id) throws NullFieldException{
        if(!(id == null)){
            this.id = id;
        } else {
            throw new NullFieldException("ID mustn't be null");
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        if(!(coordinates == null)){
            this.coordinates = coordinates;
        } else {
            throw new FieldMoreThanConstantException("Coordinates mustn't be null");
        }
    }

    @Override
    public int compareTo(Route other){
        return Double.compare(this.getDistance(), other.getDistance());
    }
    /**
     * Этот метод создает новый маршрут
     * @param idLast значение предыдущего ID
     * @return Новый маршрут с новым ID = idLast + 1
     */
    public static Route inputNewRoute(Long idLast){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название маршрута: ");
        String name = scanner.nextLine().trim();
        while(name.isEmpty()) {
            System.out.println(("Error: Название не может быть пустым. Введите снова: "));
            name = scanner.nextLine();
        }
        int x;

        System.out.print("Введите координату X (целое число > -372): ");
        while (true) {
            try {
                x = scanner.nextInt();
                if (x <= -372) {
                    System.err.print("Число должно быть больше -372. Попробуйте снова.");
                    continue;
                }
                System.out.println("Вы ввели корректное число: " + x);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное число.");
                scanner.nextLine();
            }
        }
        float y ;
        System.out.print("Введите координату Y (целое число > -527): ");
        while (true) {
            try {
                y = scanner.nextFloat();
                if (y <= -527) {
                    System.err.println("Число должно быть больше -527. Попробуйте снова.");
                    continue;
                }
                System.out.println("Вы ввели корректное число: " + y);
                break;
            }
            catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное число.");
                scanner.nextLine();
            }
        }
        Coordinates coordinates2 = new Coordinates(x, y);
        System.out.print("Введите координату from (X): ");
        double fromX ;
        while (true) {
            try {
                fromX = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное число.");
                scanner.nextLine();
            }
        }
        System.out.print("Введите координату from (Y): ");
        int fromY;
        while (true) {
            try {
                fromY = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное число.");
                scanner.nextLine();
            }
        }
        System.out.print("Введите точку начала маршрута (до 956 символов): ");
        scanner.nextLine();
        String fromName = scanner.nextLine().trim();
        while (fromName.isEmpty() || (fromName.length() > 956)) {
            System.err.print("Ошибка! Введите корректное точку начала маршрута: ");
            fromName = scanner.nextLine();
        }
        LocationFrom locationFrom = new LocationFrom(fromX, fromY, fromName);
        long toXcoordinate;
        System.out.print("Введите координату to (X): ");
        while (true) {
            try {
                String toX = scanner.nextLine().trim();
                if (toX.isEmpty()) {
                    System.err.println("Введите снова, координата не может быть пустой");
                    continue;
                }
                toXcoordinate = Long.parseLong(toX);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное значение для координаты X.");
            }
        }
        int toYcoordinate;
        System.out.print("Введите координату to (Y): ");
        while (true) {
            try {
                String toY = scanner.nextLine().trim();
                if (toY.isEmpty()) {
                    System.err.println("Введите снова, координата не может быть пустой");
                    continue;
                }
                toYcoordinate = Integer.parseInt(toY);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное значение для координаты Y.");
            }
        }
        double toZcoordinate = 0;
        System.out.print("Введите координату to (Z): ");
        while (true) {
            try {
                String toZ = scanner.nextLine().trim();
                if (toZ.isEmpty()) {
                    break;
                }
                toZcoordinate = Double.parseDouble(toZ);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное значение для координаты Z.");
            }
        }
        String toName ;
        System.out.print("Введите название to (может быть null, но не пустым): ");
        while (true) {
            toName = scanner.nextLine().trim();
            if (!toName.isEmpty()) {
                break;
            } else {
                System.err.println("Название не может быть пустым. Попробуйте снова.");
            }
        }
        LocationTo locationTo = null;
        try {
            locationTo = new LocationTo(toXcoordinate, toYcoordinate, toZcoordinate, toName);
        } catch (FieldMoreThanConstantException | NullFieldException e) {
            System.err.println("Ошибка при создании LocationTo: " + e.getMessage());
        }
        double distance2 ;
        System.out.print("Введите дистанцию маршрута (> 1): ");
        while (true) {
            try {
                distance2 = scanner.nextDouble();
                if (distance2 <= 1) {
                    System.err.println("Ошибка: дистанция должна быть больше 1. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите корректное значение для дистанции.");
                scanner.nextLine();
            }
        }
        return new Route(idLast, toName, coordinates2, locationFrom, locationTo, distance2);
    }
    @Override
    public String toString() {
        return "Route{" + "id=" + id + ", name='" + name + '\'' + ", coordinates=" + coordinates + ", creationDate=" + creationDate + ", from=" + from + ", to=" + to + ", distance=" + distance + '}';
    }
}