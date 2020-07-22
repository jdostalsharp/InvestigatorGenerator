package Character;

import Character.Tools.DiceRoll;
import org.junit.Assert;
import org.junit.Test;

public class DiceRollTests {
    @Test
    public void DiceRollRange() {
        DiceRoll num = new DiceRoll();
        int rolled = num.getDiceRoll(3);
        System.out.println(rolled);
        Assert.assertTrue(rolled > 0);
        Assert.assertTrue(rolled < 4);
    }

    @Test
    public void DiceSideZero() {
        DiceRoll num = new DiceRoll();
        int rolled = num.getDiceRoll(0);
        Assert.assertTrue(rolled == 1);
    }

}
