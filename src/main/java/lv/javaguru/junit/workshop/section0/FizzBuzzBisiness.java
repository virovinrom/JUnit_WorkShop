package lv.javaguru.junit.workshop.section0;

public class FizzBuzzBisiness {


    public String calculation(int number) {

        if (isDevidedBy9(number)) {
            return "Fizz";
        } else if (isDevidedBy15(number)) {
            return "FizzBuzz";
        } else if (isDevidedBy10(number)) {
            return "Buzz";
        }
        return "" + number;
    }

    public boolean isDevidedBy9(int number) {
        return number % 9 == 0;
    }

    public boolean isDevidedBy15(int number) {
        return number % 15 == 0;
    }

    public boolean isDevidedBy10(int number) {
        return number % 10 == 0;
    }
}
