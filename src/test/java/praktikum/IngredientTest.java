package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters (name = "Тип ингредиента: {0}; Наименование ингредиента: {1}; Стоимость ингредиента: {2}")
    public static Object[][] dataTest() {
        return new Object[][]{
                {FILLING, "сыр чеддер", 1000},
                {SAUCE, "mayonnaise", 158.99f}
        };
    }

    /**
     * Тест проверяет корректность получения стоимости ингредиента.
     */
    @Test
    public void getPriceTest() {
        Ingredient ingredientTest = new Ingredient(type, name, price);

        assertEquals("Некорректная стоимость", price, ingredientTest.getPrice(), 0);
    }

    /**
     * Тест проверяет корректность получения наименования ингредиента.
     */
    @Test
    public void getNameTest() {
        Ingredient ingredientTest = new Ingredient(type, name, price);

        assertEquals("Некорректное наименование", name, ingredientTest.getName());
    }

    /**
     * Тест проверяет корректность получения типа ингредиента.
     */
    @Test
    public void getTypeTest() {
        Ingredient ingredientTest = new Ingredient(type, name, price);

        assertEquals("Некорректный тип ингредиента", type, ingredientTest.getType());
    }

}
