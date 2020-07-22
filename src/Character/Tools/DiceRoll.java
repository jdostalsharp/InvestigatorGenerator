package Character.Tools;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

/**
 * A class representing an random dice roller of any sided dice
 * @author Jeremy Dostal-Sharp
 * @version (23/03/2020)
 */
public class DiceRoll {
    private Random randomInt;

    public DiceRoll() {
        this.randomInt = new Random();
        this.randomInt.setSeed(currentTimeMillis());
    }
/**
 * Random dice roll.
 *
 * @param diceSides an int to signify the number of sides the dice has.
 * @returns A Random number in the range of 1 - diceSides.
 */
    public int getDiceRoll(int diceSides) {
        if (diceSides <= 0) {
            return 1;
        }
        int diceRoll = ((Math.abs(randomInt.nextInt()) % diceSides) + 1);
        return diceRoll;
    }
}
