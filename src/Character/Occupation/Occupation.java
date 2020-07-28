package Character.Occupation;

import java.util.ArrayList;

/**
 * A class representing an occupation
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public abstract class Occupation {
    private String name;
    private String majorSkill;
    private String minorSkill;
    private int creditMax;
    private int creditMin;
    private ArrayList<String> contacts;
    private ArrayList<String> skills;

    /**
     * Constructor for aa occupation
     * @param name String !(null) 
     * @param majorSkill
     * @param minorSkill
     * @param creditMax
     * @param creditMin
     */
    public Occupation(String name, String majorSkill, String minorSkill, int creditMax, int creditMin) {
        this.name = name;
        this.majorSkill = majorSkill;
        this.minorSkill = minorSkill;
        this.creditMax = creditMax;
        this.creditMin = creditMin;
        this.contacts = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMajorSkill() {
        return majorSkill;
    }

    public String getMinorSkill() {
        return minorSkill;
    }

    public int getCreditMax() {
        return creditMax;
    }

    public int getCreditMin() {
        return creditMin;
    }

    public ArrayList<String> getContactsArray() {
        return contacts;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

}
