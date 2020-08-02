package Character.Skills;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Class representing a Skill 'database'.
 * 'database merely refers to a searchable collection,
 * that can be stored and loaded from a file.
 *
 * @see Skill
 *
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */

public class SkillDatabase {
    /** The database collection is represented as a set */
    private Set<Skill> database;

    /** File path to database */
    private final String dbFileName;

    /**
     * Invariant: database != null && dcFilename != null
     */

    /**
     * Creates a new SkillDatabase with the given string
     * for the file path.
     *
     * @param filename file path to database store.
     */
    public SkillDatabase(String filename) {
        database = new HashSet<Skill>();
        dbFileName = filename;
    }

    /**
     * Load a database Set object from file.
     * @throws FileNotFoundException
     * @throws Exception
     */
    public void load() throws FileNotFoundException, Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(dbFileName));

        try {
            database = (Set<Skill>) input.readObject();
        }
        catch (ClassCastException cce) {
            throw new Exception(("Data file corrupt or unavailable"));
        }

        input.close();
    }

    /**
     * Save a database Set object to file
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(dbFileName));
        output.writeObject(database);
        output.close();
    }

    /**
     * Add an Skill to the database.
     *
     * @param skill the occupation to add
     */
    public void add(Skill skill) {database.add(skill); }

    /**
     * Remove a Skill from the database
     *
     * @param skill the occupation to remove
     */
    public void remove(Skill skill) { database.remove(skill); }

    /**
     * Update an Skill in the database if present, adds if not present.
     * @param skill the occupation to update.
     */
    public void update(Skill skill) {
        if (database.contains(skill)) {
            database.remove(skill);
        }
        database.add(skill);
    }

    /**
     * Search the occupation database for a character with the given name
     * @require name != null && database != null
     * @ensure occupation with given name in DB => \result = occupation found &&
     *         occupation with given bame not in DB => \result = null
     * @param name the character nae to search for
     * @return character object found or null
     */
    public Skill search(String name) {
        try {
            for (Skill skill : database)
                if (name.equals(skill.getName()))
                    return (Skill) skill.clone();
        } catch (ClassCastException | CloneNotSupportedException cce) {}

        return null;
    }

    /**
     * Returns a sorted list of the occupations in the database.
     * @return Returns a list of the occupations in the database.
     */
    public List<String> getSkillNames() {
        List<String> names = new ArrayList<String>();
        for (Skill skill : database) {
            names.add(skill.getName());
        }
        names.sort(String::compareToIgnoreCase);
        return names;
    }

    @Override
    public String toString() {
        String result = String.format("Skill Database [%s]", dbFileName);
        if (database.isEmpty()) {
            result += "\n Empty";
        }
        for (Skill skill : database) {
            result += String.format("\n %s", skill.toString());
        }

        return result;
    }
}

