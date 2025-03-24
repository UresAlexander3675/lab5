package controller;

import java.util.*;
import models.*;

/**
 * Класс, работающий с коллекцией маршрутов
 */
public class RouteManager {
    private LinkedHashMap<Long, Route> linkedHashMap = new LinkedHashMap<>();
    private final Date initializationDate = new Date();
    private FileManager fileManager;

    /**
     * Констпуктор RouteManager
     * @param fileManager объект класса FileManager
     */
    public RouteManager(FileManager fileManager){
        this.fileManager = fileManager;
    }

    /**
     * Этот метод добавляет в коллекцию LinkedHashMap новый объект типа Route и его ID
     * @param route Объект типа Route, который нужно добавить
     */
    public void addRoute(Route route) {
        linkedHashMap.put(route.getId(), route);
    }

    /**
     * Метод, удаляющий маршрут из коллекции, и возвращающий true/false, для понимания есть ли такой маршрут или нет
     * @param id ID маршрута, который нужно удалить
     * @return если существует маршрут с таким ID - true, иначе - false
     */
    public boolean removeRoute(Long id) {
        if(linkedHashMap.containsKey(id)){
            linkedHashMap.remove(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод, который возвращает ID последнего маршрута
     * @return значение ID последнего маршрута в коллекции
     */
    public Long getLastID(){
        long id = 0;
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getKey() > id){
                id = entry.getKey();
            }
        }
        return id;
    }

    /**
     * Метод, очищаеющий все элементы коллекции
     */
    public void clearRoutes() {
        linkedHashMap.clear();
    }

    /**
     * Метод, выводящий все элементы коллекции
     */
    public void showRoutes() {
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            System.out.println("ID: " + entry.getKey() + " Route: " + entry.getValue());
        }
    }

    public Date getDateOfInitialization() {
        return initializationDate;
    }

    public int getSize() {
        return linkedHashMap.size();
    }

    public LinkedHashMap<Long, Route> getLinkedHashMap() {
        return linkedHashMap;
    }

    /**
     * Метод, удаляющий все элементы коллекции, ID которых будет больше заданного
     * @param id ID, относительно которого нужно удалять маршруты
     */
    public void removeGreaterKey(Long id){
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getKey() > id){
                linkedHashMap.remove(entry.getKey());
            }
        }
    }

    /**
     * Метод, удаляющий маршруты с определенным маршрутом
     * @param distance Дистанция, маршруты с такой дистанцией должны быть удалены
     */
    public void removeByDistance(double distance){
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getValue().getDistance() == distance){
                linkedHashMap.remove(entry.getKey());
            }
        }
    }

    /**
     * Вывод информации о коллекции
     */
    public void showInfo(){
        System.out.println("Information about this Collection");
        System.out.println("Type: LinkedHashMap<Long, Route>");
        System.out.println("Date of initialization: " + getDateOfInitialization());
        System.out.println("Number of elements: " + linkedHashMap.size());
    }

    /**
     * Метод, возвразаюший уникальные дистанции, находящиеся в коллекции
     */
    public void printUniqueDistances(){
        Set<Double> distances = new HashSet<>();
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            distances.add(entry.getValue().getDistance());
        }
        for(Double i: distances){
            System.out.println("Distance: " + i);
        }
    }

    /**
     * Метод, выводящий все маршруты по заданному имени
     * @param name Имя, по которому ищем
     */
    public void filterByName(String name){
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getValue().getName().contains(name)){
                System.out.println(entry.getValue());
            }
        }
    }

    /**
     * Метод, показывающий наличие ключа в коллекции
     * @param id ID, по которому мы ищем ключ
     * @return true - если маршрут есть, false - если маршрута нет
     */
    public boolean containsID(Long id){
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getValue().getId() == id){
                return true;
            }
        }
        return false;
    }

    public Route getRouteByID(Long id){
        for(Map.Entry<Long, Route> entry: linkedHashMap.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Метод, обновляющий данные маршрута
     * @param id ID маршрута, который нужно обновить
     * @param oldRoute старый Маршрут
     * @param newRoute новый маршрут
     */
    public void updateRoute(Long id, Route oldRoute, Route newRoute){
        if(linkedHashMap.containsValue(oldRoute)){
            linkedHashMap.remove(oldRoute.getId());
            linkedHashMap.put(id, newRoute);
        } else {
            System.out.println("Данный маршрут не найден");
        }

    }

    /**
     * Метод, удаляющий все элементы, дистанции который больше заданной дистанции
     * @param id Заданный ID, относительно которой удаляем элементы коллекции
     */
    public void removeGreater(Long id){
        Route ourRoute = linkedHashMap.get(id);
        linkedHashMap.entrySet().removeIf(entry -> ourRoute.getDistance() < entry.getValue().getDistance());
    }

    /**
     * Метод, загружающий коллекцию в файл
     */
    public void load() {
        linkedHashMap = fileManager.load();
        System.out.println("Данные загружены из файла.");
    }

}

