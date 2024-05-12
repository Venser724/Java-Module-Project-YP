import java.util.ArrayList;

public class Formatter {

    static String getFormattedOutput(float price) {
        int resultInt = (int) price;

        String rubles;
        if (resultInt <= 19 && resultInt >= 11) {
            rubles = "рублей";
        } else if (resultInt % 10 >= 2 && resultInt % 10 <= 4) {
            rubles = "рубля";
        } else if (resultInt % 10 == 1) {
            rubles = "рубль";
        } else {
            rubles = "рублей";
        }
        return String.format("С каждого по %.2f %s", price, rubles);
    }

    static String getFormattedGoods(ArrayList<Good> goods) {
        StringBuilder result = new StringBuilder();
        result.append("Добавленные товары:\n");
        for (Good good : goods) {
            result.append(good.name).append('\n');
        }
        return result.toString().trim();
    }
}
