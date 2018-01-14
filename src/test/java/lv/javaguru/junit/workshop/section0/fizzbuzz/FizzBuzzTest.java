package lv.javaguru.junit.workshop.section0.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void test1() {
        String result = fizzBuzz.getResult(3);
        assertEquals(result, "Fizz");
    }

    @Test
    public void test2() {
        String result = fizzBuzz.getResult(5);
        assertEquals(result, "Buzz");
    }

    @Test
    public void test3() {
        String result = fizzBuzz.getResult(15);
        assertEquals(result, "FizzBuzz");
    }

    @Test
    public void test4() {
        String result = fizzBuzz.getResult(1);
        assertEquals(result, "1");
    }

}