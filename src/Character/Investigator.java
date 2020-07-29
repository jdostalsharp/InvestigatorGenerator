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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
