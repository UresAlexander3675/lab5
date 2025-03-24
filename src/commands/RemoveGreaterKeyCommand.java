package commands;

import controller.*;

/**
 * Команда remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный
 */
public class RemoveGreaterKeyCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор RemoveGreaterKeyCommand
     * @param routeManager коллекция маршрутов
     */
    public RemoveGreaterKeyCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команду удаления всех ключей, превышающих заданный
     *
     * @param args ID, вводимый с командной строки
     */
    @Override
    public void execute(String[] args){
        if (args.length < 1) {
            System.out.println("Error: укажите ключ маршрута для удаления.");
            return;
        }
        Long key = Long.parseLong(args[0]);
        routeManager.removeGreaterKey(key);
    }
}
