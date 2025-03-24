package commands;

import controller.RouteManager;
import controller.FileManager;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * Команда execute_script file_name : выполняет команды из указанного файла.
 * Записывает новые команды в файл перед выполнением.
 */
public class ExecuteScriptCommand implements Commands {
    private final RouteManager routeManager;
    private final FileManager fileManager;
    private final Map<String, Commands> commands;

    /**
     * Конструктор команды ExecuteScriptCommand.
     *
     * @param routeManager Менеджер маршрутов.
     * @param fileManager  Менеджер файлов.
     * @param commands     Список доступных команд.
     */
    public ExecuteScriptCommand(RouteManager routeManager, FileManager fileManager, Map<String, Commands> commands) {
        this.routeManager = routeManager;
        this.fileManager = fileManager;
        this.commands = commands;
    }

    /**
     * Записывает команды в файл и выполняет их.
     * @param args Имя файла скрипта.
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: укажите имя файла.");
            return;
        }

        String fileName = args[0];
        File scriptFile = new File(fileName);
        if (!scriptFile.exists()) {
            System.out.println("Файл не найден. Создаём новый: " + fileName);
            try {
                scriptFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Ошибка создания файла: " + e.getMessage());
                return;
            }
        }

        try (FileWriter writer = new FileWriter(scriptFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команды (введите 'exit' для завершения записи в файл):");

            while (true) {
                System.out.print("> ");
                String userInput = scanner.nextLine().trim();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Запись в файл завершена.");
                    break;
                }

                bufferedWriter.write(userInput + "\n");
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        try (Scanner scanner = new Scanner(scriptFile)) {
            System.out.println("Выполняем команды из файла: " + fileName);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                }

                String[] parts = input.split(" ", 2);
                String commandName = parts[0];
                String argument;
                if(parts.length > 1){
                    argument = parts[1];
                } else {
                    argument = "";
                }

                Commands command = commands.get(commandName);
                if (command != null) {
                    command.execute(argument.isEmpty() ? new String[]{} : new String[]{argument});
                } else {
                    System.out.println("Ошибка: неизвестная команда '" + commandName + "'.");
                }
            }

            System.out.println("Выполнение скрипта завершено.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: не удалось открыть файл '" + fileName + "'.");
        }
    }
}
