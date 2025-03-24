package commands;

import controller.*;

public class RemoveByDistanceCommand implements Commands{
    private RouteManager routeManager;

    public RemoveByDistanceCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    @Override
    public void execute(String[] args){
        if (args.length < 1) {
            System.out.println("Error: укажите дистанцию маршрута для удаления.");
            return;
        }
        double key = Double.parseDouble(args[0]);
        routeManager.removeByDistance(key);
    }
}
