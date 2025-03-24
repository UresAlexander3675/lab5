package commands;

import controller.*;

/**
 * Команда clear : очистить коллекцию
 */
public class ClearCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор класса ClearCommand
     * @param routeManager коллекция маршрутов
     */
    public ClearCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }


    /**
     * Выполняет команды из указанного файла.
     * @param args название команды
     */
    @Override
    public void execute(String[] args){
        routeManager.clearRoutes();
        System.out.println("Маршруты очищены");
    }
}
