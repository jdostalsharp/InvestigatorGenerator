package Character;

/**
 * A class representing an investigators stats
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public class Stats {
    private int strength;
    private int constitution;
    private int size;
    private int dexterity;
    private int appearance;
    private int intelligence;
    private int power;
    private int education;
    private int luck;

    public Stats() {
        this.strength = 0;
        this.constitution = 0;
        this.size = 0;
        this.dexterity = 0;
        this.appearance = 0;
        this.intelligence = 0;
        this.power =0;
        this.education = 0;
        this.luck =0;
    }

    /**
     * Generates a random value for each of the characters stats
     */
    public void generateStats() {

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
