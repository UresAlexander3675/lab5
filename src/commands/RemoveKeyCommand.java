package commands;

import controller.*;

/**
 * Команда remove_key null : удалить элемент из коллекции по его ключу
 */
public class RemoveKeyCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор RemoveKeyCommand
     * @param routeManager коллекция маршрутов
     */
    public RemoveKeyCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команду по удалению ключа по ID
     *
     * @param args ID, вводимый с командной строки
     */
    @Override
    public void execute(String[] args){
        if (args.length < 1) {
            System.err.println("Ошибка: укажите ключ маршрута для удаления.");
            return;
        }
        Long key = Long.parseLong(args[0]);
        boolean ableToRemove = routeManager.removeRoute(key);
        if (!ableToRemove) {
            System.err.println("Маршрут с таким ключом не найден.");
        }
    }
}
