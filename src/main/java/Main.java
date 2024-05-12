import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static String GREET = "На сколько человек требуется разделить счёт?";
    private final static String ERRORINCORRECTNUMBER = "Введено некорректное число. \nВведите корректное число.";
    private final static String ADDNEWGOOD = "Добавление товара. Ведите наименование товара или 'Завершить' для перехода к расчёту чека";
    public static void main(String[] args) {
        ArrayList<Good> receipt = new ArrayList<>();


        System.out.println(GREET);
        Scanner scanner = new Scanner(System.in);
        int number = inputNumber(scanner);
        while (number <= 1) {
            System.out.println(ERRORINCORRECTNUMBER);
            number = inputNumber(scanner);
        }


        System.out.println(ADDNEWGOOD);
        String name = scanner.nextLine();
        while (!name.equalsIgnoreCase("завершить")) {
            System.out.println("Введите цену товара:");
            float price = inputFloat(scanner);
            while (price < 0) {
                System.out.println(ERRORINCORRECTNUMBER);
                price = inputFloat(scanner);
            }
            Good good = new Good(price, name);
            receipt.add(good);
            System.out.println(ADDNEWGOOD);
            name = scanner.nextLine();
        }
        float result = Calculator.calculate(receipt, number);
        System.out.println(Formatter.getFormattedGoods(receipt));
        System.out.println(Formatter.getFormattedOutput(result));
    }

    static boolean checkForInt(String string) {
        boolean isWasMinus = false;
        for (int i = 0; i < string.length(); ++i) {
            if (!Character.isDigit(string.charAt(i))) {
                if (!Character.isDigit(string.charAt(i))) {
                    if (string.charAt(i) == '-' && !isWasMinus) {
                        isWasMinus = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int inputNumber(Scanner scanner) {
        String numberOfGuests = scanner.nextLine();
        while (!checkForInt(numberOfGuests)) {
            System.out.println(ERRORINCORRECTNUMBER);
            numberOfGuests = scanner.nextLine();

        }
        return Integer.parseInt(numberOfGuests);
    }

    static boolean checkForFloat(String string) {
        boolean isWasDot = false;
        boolean isWasMinus = false;
        for (int i = 0; i < string.length(); ++i) {
            if (!Character.isDigit(string.charAt(i))) {
                if (string.charAt(i) == '-' && !isWasMinus) {
                    isWasMinus = true;
                } else if (string.charAt(i) == '.' && !isWasDot) {
                    isWasDot = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static float inputFloat(Scanner scanner) {
        String numberOfGuests = scanner.nextLine();
        while (!checkForFloat(numberOfGuests)) {
            System.out.println(ERRORINCORRECTNUMBER);
            numberOfGuests = scanner.nextLine();

        }
        return Float.parseFloat(numberOfGuests);
    }
}
