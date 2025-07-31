package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.ValuesForTest.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger testBurger;

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock1, ingredientMock2;

    @Before
    public void setUp() {

        testBurger = new Burger();
    }

    /**
     * Тест проверяет корректность добавления булочки в бургер.
     */
    @Test
    public void setBunsTest(){
        testBurger.setBuns(bunMock);

        assertEquals("Булочка в бургере не соответствует выбранной", bunMock, testBurger.bun);
    }

    /**
     * Тест проверяет корректность добавление ингредиента в бургер.
     */
    @Test
    public void addIngredientTest() {
        testBurger.addIngredient(ingredientMock1);

        assertEquals("Ингредиент не добавлен в бургер", ingredientMock1, testBurger.ingredients.get(0));
    }

    /**
     * Тест проверяет корректность удаления ингредиента из бургера по индексу.
     */
    @Test
    public void removeIngredientTest(){
        testBurger.addIngredient(ingredientMock1);
        testBurger.removeIngredient(0);
        int expectedSize = 0;

        assertEquals("Выбранный ингредиент не удален", expectedSize, testBurger.ingredients.size());
    }

    /**
     * Тест проверяет корректность перемещения ингредиента между позициями в бургере.
     */
    @Test
    public void moveIngredientTest() {
        testBurger.addIngredient(ingredientMock1);
        testBurger.addIngredient(ingredientMock2);
        testBurger.moveIngredient(0, 1);

        assertEquals("Ингредиент в бургере не на своем месте", List.of(ingredientMock2, ingredientMock1), testBurger.ingredients);
    }

    /**
     * Тест проверяет корректность расчета стоимости бургера.
     * Сумма рассчитывается как: (цена булочки * 2) + сумма цен всех ингредиентов.
     */
    @Test
    public void getPriceTest() {
        Mockito.when(bunMock.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(PRICE_INGREDIENT1);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(PRICE_INGREDIENT2);
        testBurger.addIngredient(ingredientMock1);
        testBurger.addIngredient(ingredientMock2);
        testBurger.setBuns(bunMock);

        assertEquals("Некорректная стоимость бургера", PRICE_BUN*2+PRICE_INGREDIENT1+PRICE_INGREDIENT2, testBurger.getPrice(), 0);
    }

    /**
     * Тест проверяет корректность формирование текстового рецепта бургера.
     * Убеждаемся, что рецепт содержит:
     * - Названия булочек и ингредиентов
     * - Типы ингредиентов
     * - Корректное форматирование и порядок элементов
     * - Итоговую стоимость
     */
    @Test
    public void getReceiptTest() {
        Mockito.when(ingredientMock1.getName()).thenReturn(NAME_INGREDIENT);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(PRICE_INGREDIENT1);
        Mockito.when(ingredientMock1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bunMock.getName()).thenReturn(NAME_BUN);
        Mockito.when(bunMock.getPrice()).thenReturn(PRICE_BUN);
        testBurger.setBuns(bunMock);
        testBurger.addIngredient(ingredientMock1);
        String expectedReceipt = "(==== " + NAME_BUN + " ====)\r\n" +
                "= sauce " + NAME_INGREDIENT + " =\r\n" +
                "(==== " + NAME_BUN + " ====)\r\n" +
                "\r\nPrice: " + String.format("%f",testBurger.getPrice()) + "\r\n";

        assertEquals("Некорректный рецепт бургера", expectedReceipt, testBurger.getReceipt());



    }

}
