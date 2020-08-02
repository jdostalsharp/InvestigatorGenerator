package Character;

import Character.Tools.DiceRoll;

/**
 * A class representing an investigators stats
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public class Stats {
    /** Stats */
    private int strength;
    private int constitution;
    private int size;
    private int dexterity;
    private int appearance;
    private int intelligence;
    private int power;
    private int education;
    private int luck;

    /** Random Dice roller */
    private DiceRoll diceRoll;

    /** Static numbers */
    private static int MAX_VALUE = 99;
    private static int MIN_VALUE = 0;

    /**
     *
     */
    public Stats() {
        this.strength = MIN_VALUE;
        this.constitution = MIN_VALUE;
        this.size = MIN_VALUE;
        this.dexterity = MIN_VALUE;
        this.appearance = MIN_VALUE;
        this.intelligence = MIN_VALUE;
        this.power = MIN_VALUE;
        this.education = MIN_VALUE;
        this.luck = MIN_VALUE;

        this.diceRoll = new DiceRoll();
    }

    /**
     * Generates a random value for each of the characters stats in the
     * range for each Stat
     * Strength = [15, 90]
     * Constitution = [15, 90]
     * Size = [40, 90]
     * Dexterity = [15, 90]
     * Appearance = [15, 90]
     * Intelligence = [40, 90]
     * Power = [15, 90]
     * Education = [40, 90]
     * Luck = [15, 90]
     */
    public void generateStats() {
        setStrength(statRoll(3,6) * 5);
        setConstitution(statRoll(3,6) * 5);
        setSize((statRoll(2,6) + 6) * 5);
        setDexterity(statRoll(3,6) * 5);
        setAppearance(statRoll(3,6) * 5);
        setIntelligence((statRoll(2,6) + 6) * 5);
        setPower(statRoll(3,6) * 5);
        setEducation((statRoll(2,6) + 6) * 5);
        setLuck(statRoll(3,6) * 5);
    }

    /**
     * Rolls for a stat depending on the inputs given
     * @param numDiceToRoll how many dice of sides to roll.
     * @param sides the amount of sides on a dice to roll.
     * @return an int >= 0;
     */
    public int statRoll(int numDiceToRoll, int sides) {
        int stat = 0;
        for (int i = 0; i < numDiceToRoll; i++) {
            stat += diceRoll.getDiceRoll(sides);
        }
        return stat;
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterStrength (int alter) {
        int temp = this.strength + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.strength = temp;
        } else if (temp < MIN_VALUE) {
            this.strength = MIN_VALUE;
        } else {
            this.strength = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterConstitution(int alter) {
        int temp = this.constitution + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.constitution = temp;
        } else if (temp < MIN_VALUE) {
            this.constitution = MIN_VALUE;
        } else {
            this.constitution = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterSize(int alter) {
        int temp = this.size + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.size = temp;
        } else if (temp < MIN_VALUE) {
            this.size = MIN_VALUE;
        } else {
            this.size = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterDexterity(int alter) {
        int temp = this.dexterity + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.dexterity = temp;
        } else if (temp < MIN_VALUE) {
            this.dexterity = MIN_VALUE;
        } else {
            this.dexterity = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterAppearance(int alter) {
        int temp = this.appearance + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.appearance = temp;
        } else if (temp < MIN_VALUE) {
            this.appearance = MIN_VALUE;
        } else {
            this.appearance = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterEducation(int alter) {
        int temp = this.education + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.education = temp;
        } else if (temp < MIN_VALUE) {
            this.education = MIN_VALUE;
        } else {
            this.education = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterIntelligence(int alter) {
        int temp = this.intelligence + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.intelligence = temp;
        } else if (temp < MIN_VALUE) {
            this.intelligence = MIN_VALUE;
        } else {
            this.intelligence = MAX_VALUE;
        }
    }

    /**
     * Alter stat by amount cannot be reduced below 0 or increased above 99
     * @param alter can be positive or negative
     */
    public void alterPower(int alter) {
        int temp = this.power + alter;
        if (temp >= MIN_VALUE && temp <= MAX_VALUE) {
            this.power = temp;
        } else if (temp < MIN_VALUE) {
            this.power = MIN_VALUE;
        } else {
            this.power = MAX_VALUE;
        }
    }

    /************************************************Getters and Setters***********************************************/
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
