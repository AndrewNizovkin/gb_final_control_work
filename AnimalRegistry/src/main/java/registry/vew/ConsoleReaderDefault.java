package registry.vew;

import registry.presenter.ConsoleReader;

import java.util.Scanner;

public class ConsoleReaderDefault implements ConsoleReader {
    @Override
    public String getStringFromConsole(String message) {
        System.out.print(message + "-> ");
        Scanner myScanner = new Scanner(System.in);
        String line;
            line = myScanner.nextLine();
            if (line.equals("")) {
            System.out.println("Пустые строки вводить нельзя");
            line = getStringFromConsole(message);
        }
        return line;
    }

    @Override
    public int getNumberFromConsole(String message) {
        String input = getStringFromConsole(message);
        while (!input.matches("[0-9]*")) {
            System.out.println("Введите натуральное число");
            input = getStringFromConsole(message);
        }
        return Integer.parseInt(input);
    }
}
