package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientTypeName;
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType, String ingredientTypeName) {

        this.ingredientType = ingredientType;
        this.ingredientTypeName = ingredientTypeName;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Object[][] dataTest() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }


    @Test
    public void valueOf() {
        assertEquals("Некорректный тип ингредиента", ingredientType, IngredientType.valueOf(ingredientTypeName));
    }
}
