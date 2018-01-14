package lv.javaguru.junit.workshop.section0;

import lv.javaguru.junit.workshop.section0.sorting.ArraySorter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzBisinessTest {
    private FizzBuzzBisiness fizzBuzzBisiness = new FizzBuzzBisiness();

    @Test
    public void test1(){
        assertEquals(fizzBuzzBisiness.calculation(9),"Fizz");
    }
    @Test
    public void test2(){
        assertEquals(fizzBuzzBisiness.calculation(15),"FizzBuzz");
    }
    @Test
    public void test3(){
        assertEquals(fizzBuzzBisiness.calculation(10),"Buzz");
    }
    @Test
    public void test4(){
        assertEquals(fizzBuzzBisiness.calculation(11),"11");
    }
}