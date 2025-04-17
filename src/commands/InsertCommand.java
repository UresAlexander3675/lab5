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
        Route routeToAdd;
        if (args.length > 0) {
            try{
                String[] information = args[0].split(";");
                if (information.length < 11){
                    System.err.println("Error: недостаточно данных для insert или Вы ввели команду неверно");
                    return;
                }
                Long id = routeManager.getLastID() + 1;
                String name = information[0];
                int x = Integer.parseInt(information[1]);
                float y = Float.parseFloat(information[2]);
                double fromX = Double.parseDouble(information[3]);
                int fromY = Integer.parseInt(information[4]);
                String fromName = information[5];
                Long toX = Long.parseLong(information[6]);
                Integer toY = Integer.parseInt(information[7]);
                double toZ = Double.parseDouble(information[8]);
                String toName = information[9];
                double distance = Double.parseDouble(information[10]);

                routeToAdd = new Route(id, name, new Coordinates(x, y), new LocationFrom(fromX, fromY, fromName), new LocationTo(toX, toY, toZ, toName), distance);
                routeManager.addRoute(routeToAdd);
            } catch (Exception e){
                System.err.println("Скрипт написан неверно");
            }
        } else {
            Long idLast = routeManager.getLastID();
            routeToAdd = inputNewRoute(idLast);
            if (routeToAdd == null){
                System.err.println("Маршрут не создан");
                return;
            }
            routeToAdd.setId(routeToAdd.getId() + 1);
            routeManager.addRoute(routeToAdd);
            System.out.println("Маршрут добавлен: " + routeToAdd + ".");
        }

    }
}
