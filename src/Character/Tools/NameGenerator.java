package Character.Tools;

import Character.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

public class NameGenerator {
    /** First name /
    private String firstName = "Fuzzy";
    /** Last Name /
    private String lastName = "Herman";
    /** Middle Name /
    private String middleName = "Potato";
    */
    /** Female names list */
    private String FEMALE_FIRST_NAME_FILE = "./data/femaleFirstNames.txt";
    /** Male names list */
    private String MALE_FIRST_NAME_FILE = "./data/maleFirstNames.txt";
    /** Gender Neutral names list */
    private String NEUTRAL_FIRST_NAME_FILE = ".data/neutralFirstNames.txt";
    /** Last name list */
    private String LAST_NAME_FILE = "./data/lastNames.txt";
    /** Random generator */
    private Random random;
    /** First name list */
    private List<String> firstNames;
    /** Last name list */
    private List<String> lastNames;
    /** Gender : MALE; FEMALE; NONBINARY */
    private Gender gender;

    public NameGenerator(Gender gender) {
        firstNames = new ArrayList<String>();
        lastNames = new ArrayList<String>();
        this.gender = gender;
        this.random = new Random();
        this.random.setSeed(currentTimeMillis());
    }

    /**
     * Makes a list of all the firstnames in *FirstNames.txt file
     * @param gender MALE; FENALE; NONBINARY; if a different gender is used as input, NONBINARY will be default
     */
    public void setFirstNamesList(Gender gender) {
        File firstNameFile;
        /** Set the name file to the appropriate gender */
        if(gender == Gender.MALE) {
            firstNameFile = new File(MALE_FIRST_NAME_FILE);
        } else if (gender == Gender.FEMALE) {
            firstNameFile = new File(FEMALE_FIRST_NAME_FILE);
        } else {
            firstNameFile = new File(NEUTRAL_FIRST_NAME_FILE);
        }

        /** Scan each line in as a new name String in list of names */
        try {
            for (Scanner scan = new Scanner(firstNameFile); scan.hasNext(); ) {
                this.firstNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    /**
     * Makes a list of all the last names in *LastNameFile.txt
     */
    public void setLastNamesList() {
        try {
            for (Scanner scan = new Scanner(new File(LAST_NAME_FILE)); scan.hasNext(); ) {
                this.lastNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    /**
     * Gets a random first name from the list of first names
     * @param firstNames list of first names to choose a name from
     * @return a First name string
     */
    private String randomFirstName(List<String> firstNames) {
        int size = firstNames.size();
        return firstNames.get(Math.abs(this.random.nextInt()) % (size));
    }

    /**
     * Gets a random last name from the list of last names
     * @param lastNames list of last names to choose a name from
     * @return a Last name string.
     */
    public String randomLastName(List<String> lastNames) {
        int size = lastNames.size();
        return lastNames.get(Math.abs(this.random.nextInt()) % (size));
    }

    /**
     * Gets a random middle name from the list of first names
     * @param firstNames list of first names to be used as middle names to choose
     *                   a name from
     * @return a Middle name string.
     */
    public String randomMiddleName (List<String> firstNames) {
        int size = firstNames.size();
        return firstNames.get(Math.abs(this.random.nextInt()) % (size));
    }


}
