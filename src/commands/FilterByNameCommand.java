package commands;

import controller.*;


/**
 * Команда filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
 */

public class FilterByNameCommand implements Commands{
    private RouteManager routeManager;

    /**
     * Конструктор FilterByNameCommand
     * @param routeManager коллекция маршрутов
     */
    public FilterByNameCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команды из указанного файла.
     * @param args имя маршрута
     */
    @Override
    public void execute(String[] args){
        if (args.length < 1) { //можно try/catch
            System.out.println("Error: укажите имя для вывода подходящих маршрутов.");
            return;
        }
        String name = args[0];
        if(args[0].isEmpty()){
            System.out.println("Укажите имя для вывода подходящих маршрутов.");
        }
        routeManager.filterByName(name);
    }
}
