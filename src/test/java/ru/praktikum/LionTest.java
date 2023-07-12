package ru.praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    public static Object[][] getParams() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUpMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самец");
        lion.feline = mockFeline;
        Mockito.when(lion.feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    @Parameters(method = "getParams")
    public void doesHaveManeParamsTest(String sex, boolean hasMane) throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeThrowExceptionTest() {
        try {
            Lion lion = new Lion("Недопустимое значение");
        } catch (Exception ex) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самка");
        lion.feline = mockFeline;
        Mockito.when(lion.feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}