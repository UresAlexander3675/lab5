package commands;

import controller.*;

/**
 * Команда save : сохранить коллекцию в файл
 */
public class SaveCommand implements Commands {
    private FileManager fileManager;
    private RouteManager routeManager;

    /**
     * Конструктор SaveCommand
     * @param fileManager объект класса FileManager
     * @param routeManager объект класса RouteManager
     */
    public SaveCommand(FileManager fileManager, RouteManager routeManager) {
        this.fileManager = fileManager;
        this.routeManager = routeManager;
    }

    /**
     * Выполняет команды по сохранению файла
     *
     * @param args название команды
     */
    @Override
    public void execute(String[] args) {
        fileManager.save(routeManager.getLinkedHashMap());
        System.out.println("Коллекция успешно сохранена в файл.");
    }
}
