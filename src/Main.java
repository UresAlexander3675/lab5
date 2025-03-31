import commands.*;
import controller.*;
import java.util.*;

/**
 * Главный класс консольного приложения для управления коллекцией маршрутов.
 * Загружает коллекцию из файла, обрабатывает пользовательский ввод команд
 * и выполняет соответствующие действия.
 */
public class Main {
    /**
     * Точка входа в программу.
     * @param args аргументы командной строки (первый аргумент — путь к файлу XML)
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Ошибка: Укажите путь к файлу!");
            return;
        }


        FileManager fileManager = new FileManager("data.xml");
        RouteManager routeManager = new RouteManager(fileManager);
        routeManager.load();
        Map<String, Commands> commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("show", new ShowCommand(routeManager));
        commands.put("insert", new InsertCommand(routeManager));
        commands.put("info", new InfoCommand(routeManager));
        commands.put("update", new UpdateCommand(routeManager));
        commands.put("remove_key", new RemoveKeyCommand(routeManager));
        commands.put("clear", new ClearCommand(routeManager));
        commands.put("save", new SaveCommand(fileManager, routeManager));
        commands.put("execute_script", new ExecuteScriptCommand(routeManager, fileManager, commands));
        commands.put("exit", new ExitCommand());
        commands.put("remove_greater", new RemoveGreaterCommand(routeManager));
        commands.put("replace_if_lower", new ReplaceIfLowerCommand(routeManager));
        commands.put("remove_greater_key", new RemoveGreaterKeyCommand(routeManager));
        commands.put("remove_any_by_distance", new RemoveByDistanceCommand(routeManager));
        commands.put("filter_starts_with_name", new FilterByNameCommand(routeManager));
        commands.put("print_unique_distance", new PrintUniqueDistanceCommand(routeManager));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду (help для списка всех команд):");

        while (true) {
            System.out.print(">>> ");
            if (!scanner.hasNextLine()) {
                break;
            }

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
                if(argument.isEmpty()){
                    command.execute(new String[]{});
                } else {
                    command.execute(new String[]{argument});
                }
            } else {
                System.out.println("Неизвестная команда. Введите 'help' для списка команд.");
            }
        }
    }
}
