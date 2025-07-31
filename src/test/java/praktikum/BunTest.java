package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.ValuesForTest.NAME_BUN;
import static praktikum.ValuesForTest.PRICE_BUN;

public class BunTest {

    private Bun testBun;

    @Before
    public void init() {
        testBun = new Bun(NAME_BUN, PRICE_BUN);
    }

    /**
    * Тест проверяет корректность получения наименования булочки.
     */
    @Test
    public void getNameTest() {
        assertEquals("Некорректное наименование булочки", NAME_BUN, testBun.getName());
    }
    /**
     * Тест проверяет корректность получения стоимости булочки.
     */
    @Test
    public void getPriceTest() {
        assertEquals("Некорректная стоимость булочки", PRICE_BUN, testBun.getPrice(), 0);
    }
}
