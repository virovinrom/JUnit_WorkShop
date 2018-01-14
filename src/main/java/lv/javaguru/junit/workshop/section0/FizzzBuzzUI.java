package lv.javaguru.junit.workshop.section0;

import java.util.Scanner;

public class FizzzBuzzUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        FizzBuzzBisiness fizzBuzzBisiness = new FizzBuzzBisiness();
        String result = fizzBuzzBisiness.calculation(number);
        System.out.println("Result " + result);
    }
}
