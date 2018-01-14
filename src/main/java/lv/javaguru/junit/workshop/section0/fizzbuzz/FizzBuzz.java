package lv.javaguru.junit.workshop.section0.fizzbuzz;

public class FizzBuzz {

    public String getResult(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return "" + number;
    }

}
