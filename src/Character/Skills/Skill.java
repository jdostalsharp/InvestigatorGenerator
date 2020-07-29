package Character.Skills;

/**
 * An class representing a investigator skill
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public class Skill {
    /** Name of the skill */
    private String name;
    /** Value of the skill */
    private int value;

    /**
     * Constructor for a skill
     * @param name Name of the skill.
     * @param value Skill level.
     */
    public Skill(String name, int value) {
        this.name = name;
        if (value >= 0 && value < 100) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    /**
     * Gets the name of the skill
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the skill
     * @param name != null
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the skill
     * @return skill value
     */
    public int getValue() {
        return value;
    }

    /**
     * Set the value of the skill
     * @param value >= 0 && < 100
     */
    public void setValue(int value) {
        if (value >= 0 && value < 100) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        try {
            Skill s = (Skill) other;
            return name.equals(s.getName());
        }
        catch (ClassCastException cce) {
            return false;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Skill clone = new Skill(name, value);
        return clone;
    }

    @Override
    public String toString() {
        String skill = name + ": " + value + "%\n";
        return skill;
    }
}
