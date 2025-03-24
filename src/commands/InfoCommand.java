package commands;

import controller.RouteManager;

/**
 * Команда info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand implements Commands{
    private RouteManager routeManager;

    public InfoCommand(RouteManager routeManager){
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команды из указанного файла.
     * @param args название команды
     */
    @Override
    public void execute(String[] args){
        routeManager.showInfo();
    }
}
