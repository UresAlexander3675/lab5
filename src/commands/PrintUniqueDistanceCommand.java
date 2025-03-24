package commands;

import controller.*;

/**
 * Команда print_unique_distance : вывести уникальные значения поля distance всех элементов в коллекции
 */
public class PrintUniqueDistanceCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор PrintUniqueDistanceCommand
     * @param routeManager коллекция маршрутов
     */
    public PrintUniqueDistanceCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команду
     *
     * @param args название команды
     */
    @Override
    public void execute(String[] args){
        routeManager.printUniqueDistances();
    }
}
