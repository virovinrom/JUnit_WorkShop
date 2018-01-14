package lv.javaguru.junit.workshop.section0.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySorterTest {
    private ArraySorter arraySorter;
    @Before
    public void init() {
        arraySorter = new ArraySorter();
    }
    @Test
    public void sort() throws Exception {
        int[] array = {1,5,4};
        arraySorter.sort((array));
        assertEquals(array[0],1);
        assertEquals(array[1],4);
        assertEquals(array[2],5);
    }
    @Test
    public void test2(){
        int[] array = {4};
        arraySorter.sort((array));
        assertEquals(array[0],4);

    }
    @Test
    public void test3(){
        int[] array = {-10,-5,4};
        arraySorter.sort((array));
        assertEquals(array[0],-10);
        assertEquals(array[1],-5);
        assertEquals(array[2],4);


    }
    @Test
    public void test4(){
        int[] array = {};
        arraySorter.sort((array));
        assertEquals(array.length,0);

    }

}