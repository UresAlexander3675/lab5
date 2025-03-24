package commands;

import controller.*;

/**
 * Команда show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор класса ShowCommand
     * @param routeManager коллекция маршрутов
     */
    public ShowCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команду вывода информации о коллекциях маршрутов
     *
     * @param args название маршрута
     */
    @Override
    public void execute(String[] args){
        routeManager.showRoutes();
    }
}
