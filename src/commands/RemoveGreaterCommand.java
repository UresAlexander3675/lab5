package commands;

import controller.*;

/**
 * Команда remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
 */

public class RemoveGreaterCommand implements Commands {
    private final RouteManager routeManager;

    /**
     * Конструктор RemoveGreaterCommand
     * @param routeManager коллекция маршрутов
     */
    public RemoveGreaterCommand(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команды
     *
     * @param args ID маршрута
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.err.println("Ошибка: укажите ключ");
            return;
        }

        try {
            long id = Long.parseLong(args[0]);
            routeManager.removeGreater(id);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: ключ должен быть числом.");
        }
    }
}

