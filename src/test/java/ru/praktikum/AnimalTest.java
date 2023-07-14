package ru.praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test(expected = Exception.class)
    public void getFoodThrowExceptionTest() throws Exception {
        animal.getFood("неизвестный вид животного");
    }

    @Test
    public void getFamilyTest() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

}