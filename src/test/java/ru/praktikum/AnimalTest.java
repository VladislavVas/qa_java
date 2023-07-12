package ru.praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(JUnitParamsRunner.class)
public class AnimalTest {
    private final Animal animal = new Animal();

    public static Object[][] getParams() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    @Parameters(method = "getParams")
    public void getFoodParamsTest(String animalKind, List<String> expectedFoodList) throws Exception {
        assertEquals(expectedFoodList, animal.getFood(animalKind));
    }

    @Test
    public void getFoodThrowExceptionTest() throws Exception {
        Exception ex = assertThrows(
                Exception.class,
                () -> animal.getFood("неизвестный вид животного"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
    }

    @Test
    public void getFamilyTest() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

}