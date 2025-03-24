package commands;

import controller.*;
import models.*;

import static models.Route.inputNewRoute;

/**
 * Команда replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого
 */
public class ReplaceIfLowerCommand implements Commands {
    private RouteManager routeManager;

    /**
     * Конструктор ReplaceIfLowerCommand
     * @param routeManager коллекция маршрутов
     */
    public ReplaceIfLowerCommand(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команду замены элемента по ID
     *
     * @param args ID элемента, вводимый с командной строки
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Ошибка: укажите ключ.");
            return;
        }
        Long id = Long.parseLong(args[0]);
        if (!routeManager.containsID(id)) {
            System.out.println("Error: маршрут с таким ключом не найден.");
            return;
        }
        Route oldRoute = routeManager.getRouteByID(id);
        System.out.println("Текущий маршрут: " + oldRoute);

        Route newRoute = inputNewRoute(id);

        if (newRoute.getDistance() < oldRoute.getDistance()) {
            routeManager.updateRoute(id, oldRoute, newRoute);
            System.out.println("Маршрут успешно заменён.");
        } else {
            System.out.println("Новый маршрут больше или равен старому. Замена не выполнена.");
        }
    }
}
