package commands;

import controller.*;
import models.Route;

import static models.Route.inputNewRoute;

/**
 *Команда update id {element} : обновить значение элемента коллекции, id которого равен заданному
 */
public class UpdateCommand implements Commands{
    private RouteManager manager;

    /**
     * Конструктор класса UpdateCommand
     * @param routeManager коллекция маршрутов
     */
    public UpdateCommand(RouteManager routeManager){
        this.manager = routeManager;
    }

    /**
     * Выполняет команды по обновлении коллекции
     *
     * @param args ID элемента, который нужно обновить
     */
    @Override
    public void execute(String[] args){
        if (args.length < 1) {
            System.out.println("Ошибка: укажите ключ.");
            return;
        }
        Long id = Long.parseLong(args[0]);
        if (!manager.containsID(id)) {
            System.out.println("Ошибка: маршрут с таким ключом не найден.");
            return;
        }
        Route oldRoute = manager.getRouteByID(id);
        System.out.println("Текущий маршрут: " + oldRoute);
        Route newRoute = inputNewRoute(id);
        manager.updateRoute(id, oldRoute, newRoute);
        System.out.println("Новый маршрут: " + newRoute);
    }
}
