package Character.Occupation;

import java.util.ArrayList;

/**
 * A class representing an occupation
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */
public class Occupation {
    /** The name of the occupation */
    private String name;
    /** The Description regarding the occupation */
    private String description;
    /** The main skill used to calculate skill points */
    //TODO Change this to a skill object
    private String majorSkill;
    /** The secondary skill to calculate skill points */
    //TODO Change this to a skill object
    private String minorSkill;
    /** The optional secondary skill to calculate skill points
     *  Can be null
     */
    //TODO Change this to a skill object
    private String minorSkillExtra;
    /** Maximum credit score allowed for this occupation */
    private int creditMax;
    /** Minimum credit score for this occupation */
    private int creditMin;
    /** List of available contacts for this occupation */
    private final ArrayList<String> contacts;
    /** List of skills that can be increased for this occupation */
    private final ArrayList<String> skills;

    /**
     * Constructor for an occupation with two secondary skills
     * @param name the name of the occupation. != null
     * @param description the description of the occupation. != null
     * @param majorSkill the main skill used for this occupation
     * @param minorSkill the secondary skill used for this occupation
     * @param minorSkillExtra the optional secondary skill for this occupation
     * @param creditMax the maximum credit score this occupation can have
     *                  > 1 && < 100
     * @param creditMin the minimum credit score this occupation can have
     *                  > 0 && < creditMax
     */
    public Occupation(String name, String description, String majorSkill, String minorSkill,
                      String minorSkillExtra, int creditMax, int creditMin) {
        this.name = name;
        this.description = description;
        this.majorSkill = majorSkill;
        this.minorSkill = minorSkill;
        this.minorSkillExtra = minorSkillExtra;

        if (creditMax > 1 && creditMax < 100) {
            this.creditMax = creditMax;
        } else {
            this.creditMax = 50;
        }

        if (creditMin > 0 && creditMin < creditMax) {
            this.creditMin = creditMin;
        } else {
            this.creditMin = (this.creditMax - 1);
        }

        this.contacts = new ArrayList<String>();
        this.skills = new ArrayList<String>();
    }

    /**
     * Constructor for an occupation with a single secondary skill
     * @param name the name of the occupation. != null
     * @param description the description of the occupation. != null
     * @param majorSkill the main skill used for this occupation
     * @param minorSkill the secondary skill used for this occupation
     * @param creditMax the maximum credit score this occupation can have
     *                  > 1 && < 100
     * @param creditMin the minimum credit score this occupation can have
     *                  > 0 && < creditMax
     */
    public Occupation(String name, String description, String majorSkill, String minorSkill,
                      int creditMax, int creditMin) {
        this.name = name;
        this.description = description;
        this.majorSkill = majorSkill;
        this.minorSkill = minorSkill;
        this.minorSkillExtra = null;
        if (creditMax > 1 && creditMax < 100) {
            this.creditMax = creditMax;
        } else {
            this.creditMax = 50;
        }

        if (creditMin > 0 && creditMin < creditMax) {
            this.creditMin = creditMin;
        } else {
            this.creditMin = (this.creditMax - 1);
        }
        this.contacts = new ArrayList<String>();
        this.skills = new ArrayList<String>();
    }

    /**
     * @return the occupation name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the occupations description
     */
    public String getDescription() { return description; }

    /**
     * @return the major skill
     */
    public String getMajorSkill() {
        return majorSkill;
    }

    /**
     * @return the minor skill
     */
    public String getMinorSkill() {
        return minorSkill;
    }

    /**
     * @return the optional minor skill || null
     */
    public String getMinorSkillExtra() {
        return  minorSkillExtra;
    }

    /**
     * @return The max credit score this occupation can have
     */
    public int getCreditMax() {
        return creditMax;
    }

    /**
     * @return The minimum credit score this occupation can have
     */
    public int getCreditMin() {
        return creditMin;
    }

    /**
     * @return the list of contacts
     */
    public ArrayList<String> getContactsArray() {
        return contacts;
    }

    /**
     * @return The list of skills that this occupation can choose from
     */
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * Sets the name of this occupation
     * @param name != null
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of this occupation
     * @param description != null
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the major skill of this occupation
     * @param majorSkill != null && be in list of skills
     */
    //TODO Change this to a skill object
    public void setMajorSkill(String majorSkill) {
        this.majorSkill = majorSkill;
    }

    /**
     * Sets the minor skill of this occupation
     * @param minorSkill != null && be in the list of skills
     */
    //TODO CHange this to a skill object
    public void setMinorSkill(String minorSkill) {
        this.minorSkill = minorSkill;
    }

    /**
     * Sets the optional minor skill
     * @param minorSkillExtra be in the list of skills
     */
    //TODO Change this to a skill object
    public void setMinorSkillExtra(String minorSkillExtra) { this.minorSkillExtra = minorSkillExtra; }

    /**
     * Sets the maximum credit score for this occupation
     * @param creditMax > 1 && < 100
     */
    public void setCreditMax(int creditMax) {
        this.creditMax = creditMax;
    }

    /**
     * Sets the minimum credit score for this occuaption
     * @param creditMin >= 0 && < creditMax
     */
    public void setCreditMin(int creditMin) {
        this.creditMin = creditMin;
    }

    /**
     * Adds a contact to the list of contacts for this occupation
     * @param contact != null
     */
    public void addContacts(String contact) {
        contacts.add(contact);
    }

    /**
     * Adds a skill to the list of usable skills for this occupation
     * @param skill be in the list of skills
     */
    //TODO Change to a skill object
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
        //TODO change this to get the name of a skill object
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
