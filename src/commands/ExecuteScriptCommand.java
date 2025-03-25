package commands;

import controller.RouteManager;
import controller.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * Команда execute_script file_name :
 * Считывает команды из указанного файла и выполняет их построчно.
 */
public class ExecuteScriptCommand implements Commands {
    private final RouteManager routeManager;
    private final FileManager fileManager;
    private final Map<String, Commands> commands;

    /**
     * Конструктор команды execute_script.
     *
     * @param routeManager менеджер маршрутов
     * @param fileManager менеджер файлов
     * @param commands список всех доступных команд
     */
    public ExecuteScriptCommand(RouteManager routeManager, FileManager fileManager, Map<String, Commands> commands) {
        this.routeManager = routeManager;
        this.fileManager = fileManager;
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: укажите имя файла.");
            return;
        }

        String fileName = args[0];
        File scriptFile = new File(fileName);

        if (!scriptFile.exists() || !scriptFile.isFile()) {
            System.out.println("Ошибка: файл " + fileName + " не найден.");
            return;
        }

        try (Scanner scanner = new Scanner(scriptFile)) {
            System.out.println("Выполяем команды из файла " + fileName);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                }

                String[] parts = input.split(" ", 2);
                String commandName = parts[0];
                String[] commandArgs;
                if(parts.length > 1) {
                    commandArgs = new String[]{parts[1]};
                } else {
                    commandArgs = new String[]{};
                }
                Commands command = commands.get(commandName);
                if (command != null) {
                    command.execute(commandArgs);
                } else {
                    System.out.println("Error: неизвестная команда '" + commandName + "'");
                }
            }

            System.out.println("Выполнение скрипта завершено.");

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: не удалось открыть файл '" + fileName + "'.");
        }
    }
}
