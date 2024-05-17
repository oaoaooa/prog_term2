package command;

import command.interfaces.Command;
import java.io.IOException;

public class HelpCommand implements Command {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    String argument;

    @Override
    public void executeFromConsole(String argument) throws IOException {
        this.argument = argument;
        System.out.println(ANSI_YELLOW+ "help " + ANSI_RESET + " : вывести справку по доступным командам");
        System.out.println(ANSI_YELLOW+ "exit " + ANSI_RESET + " : завершить программу (без сохранения в файл)");
        System.out.println(ANSI_YELLOW+ "show " + ANSI_RESET + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println(ANSI_YELLOW+ "insert " + ANSI_RESET + " : добавить новый элемент с заданным ключом");
        System.out.println(ANSI_YELLOW+ "save " + ANSI_RESET + " : сохранить коллекцию в файл");
        System.out.println(ANSI_YELLOW+ "info " + ANSI_RESET + " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println(ANSI_YELLOW+ "update id {element} " + ANSI_RESET + " : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println(ANSI_YELLOW+ "execute_script file_name " + ANSI_RESET + " : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println(ANSI_YELLOW+ "clear " + ANSI_RESET + " : очистить коллекцию");
        System.out.println(ANSI_YELLOW+ "remove_key null " + ANSI_RESET + "  : удалить элемент из коллекции по его ключу");
        System.out.println(ANSI_YELLOW+ "history " + ANSI_RESET + "  : история команд");
        System.out.println(ANSI_YELLOW+ "max_by_health " + ANSI_RESET + "  : максимальное значение здоровья");
        System.out.println(ANSI_YELLOW+ "filter_starts_with_name chapter " + ANSI_RESET + " : вывести элементы, значение поля chapter которых меньше заданного");
        System.out.println(ANSI_YELLOW+ "print_field_ascending_weapon_type " + ANSI_RESET + " : вывести значения поля category всех элементов в порядке убывания");
    }

    @Override
    public void executeFromFile(String argument) throws IOException {
        executeFromConsole(argument);
    }
}