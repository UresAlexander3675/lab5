package commands;

/**
 * Команда exit : завершить программу (без сохранения в файл)
 */
public class ExitCommand implements Commands {
    /**
     * Выполняет команды из указанного файла.
     * @param args название команды
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Выход из программы...");
        System.exit(0);
    }
}
