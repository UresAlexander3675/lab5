package commands;

import controller.*;
import models.*;

import static models.Route.inputNewRoute;

/**
 * Команда insert null {element} : добавить новый элемент с заданным ключом
 */
public class InsertCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор InsertCommand
     * @param routeManager коллекция маршрутов
     */
    public InsertCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команды из указанного файла.
     * @param args название команды
     */
    @Override
    public void execute(String[] args){
        Long idLast = routeManager.getLastID();
        Route routeToAdd = inputNewRoute(idLast);
        routeToAdd.setId(routeToAdd.getId() + 1);
        routeManager.addRoute(routeToAdd);
        System.out.println("Маршрут добавлен: " + routeToAdd);
    }
}
