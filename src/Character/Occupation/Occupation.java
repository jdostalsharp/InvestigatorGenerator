package Character.Occupation;

import java.util.ArrayList;

/**
 * A class representing an occupation
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public class Occupation {
    private String name;
    private String description;
    private String majorSkill;
    private String minorSkill;
    private String minorSkillExtra;
    private int creditMax;
    private int creditMin;
    private final ArrayList<String> contacts;
    private final ArrayList<String> skills;

    /**
     * Constructor for an occupation with two secondary skills
     * @param name String !(null)
     * @param description
     * @param majorSkill
     * @param minorSkill
     * @param minorSkillExtra
     * @param creditMax
     * @param creditMin
     */
    public Occupation(String name, String description, String majorSkill, String minorSkill,
                      String minorSkillExtra, int creditMax, int creditMin) {
        this.name = name;
        this.description = description;
        this.majorSkill = majorSkill;
        this.minorSkill = minorSkill;
        this.minorSkillExtra = minorSkillExtra;
        this.creditMax = creditMax;
        this.creditMin = creditMin;
        this.contacts = new ArrayList<String>();
        this.skills = new ArrayList<String>();
    }

    /**
     * Constructor for an occupation with a single secondary skill
     * @param name
     * @param description
     * @param majorSkill
     * @param minorSkill
     * @param creditMax
     * @param creditMin
     */
    public Occupation(String name, String description, String majorSkill, String minorSkill,
                      int creditMax, int creditMin) {
        this.name = name;
        this.description = description;
        this.majorSkill = majorSkill;
        this.minorSkill = minorSkill;
        this.minorSkillExtra = null;
        this.creditMax = creditMax;
        this.creditMin = creditMin;
        this.contacts = new ArrayList<String>();
        this.skills = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public String getMajorSkill() {
        return majorSkill;
    }

    public String getMinorSkill() {
        return minorSkill;
    }

    public String getMinorSkillExtra() { return  minorSkillExtra; }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMajorSkill(String majorSkill) {
        this.majorSkill = majorSkill;
    }

    public void setMinorSkill(String minorSkill) {
        this.minorSkill = minorSkill;
    }

    public void setMinorSkillExtra(String minorSkillExtra) { this.minorSkillExtra = minorSkillExtra; }

    public void setCreditMax(int creditMax) {
        this.creditMax = creditMax;
    }

    public void setCreditMin(int creditMin) {
        this.creditMin = creditMin;
    }

    public void addContacts(String contact) {
        contacts.add(contact);
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        try {
            Occupation occ = (Occupation) other;
            return name.equals(occ.getName());
        }
        catch (ClassCastException cce) {
            return false;
        }
    }

    @Override
    public String toString() {
        /** String builder for skills */
        StringBuilder sbs = new StringBuilder();
        for (String skill : skills) {
            sbs.append(" " + skill);
            sbs.append(",");
        }

        /** String builder for contacts */
        StringBuilder sbc = new StringBuilder();
        for (String contact : contacts) {
            sbc.append(" " + contact);
            sbc.append(",");
        }

        String s = "";

        if (minorSkillExtra.equals(null)) {
            s = name + "\n" + "Description\n" + description + "\n\n" +
                        "Occupation Skill Points: " + majorSkill + " x 2 + " + minorSkill + " x 2\n\n" +
                        "Credit Rating: " + creditMin + "-" + creditMax + "\n\n" +
                        "Suggested Contacts:" + sbc.toString() + "\n\n" +
                        "Skills:" + sbs.toString() + "\n";
        } else {
            s = name + "\n" + "Description\n" + description + "\n\n" +
                        "Occupation Skill Points: " + majorSkill + " x 2 + " + "(" + minorSkill +
                        " x 2 or " + minorSkillExtra + " x 2)\n\n" +
                        "Credit Rating: " + creditMin + "-" + creditMax + "\n\n" +
                        "Suggested Contacts:" + sbc.toString() + "\n\n" +
                        "Skills:" + sbs.toString() + "\n";
        }
        return s;
    }

    @Override
    public Object clone() {
        Occupation clone = new Occupation(name, description, majorSkill, minorSkill, minorSkillExtra, creditMax, creditMax);
            for (String skill : skills)
                clone.skills.add(skill);
            for (String con : contacts)
                clone.contacts.add(con);

            return clone;
    }

}
