import java.util.ArrayList;

public class Calculator {
    static float calculate(ArrayList<Good> receipt, int numberOfGuests) {
        float totalPrice = 0;
        for (Good good : receipt) {
            totalPrice += good.price;
        }
        return totalPrice / numberOfGuests;
    }
}
