package Character;

import Character.Occupation.Occupation;
import Character.enums.Gender;
/**
 * A class representing an investigator
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */

public class Investigator {
    /** The Investigators name **/
    private String name;
    /** The investigators age **/
    private int age;
    /** the investigators gender **/
    private Gender gender;
    /** The investigators occupation **/
    private Occupation occupation;


    public Investigator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get the name of the character
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the investigator
     * @param name != null
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the investigator
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the investigator
     * @param age > 11  && <= 100
     */
    public void setAge(int age) {
        this.age = age;
    }
}
