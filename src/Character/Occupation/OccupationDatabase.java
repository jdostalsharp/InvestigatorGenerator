package Character.Occupation;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Class representing a Occupation 'database'.
 * 'database merely refers to a searchable collection,
 * that can be stored and loaded from a file.
 *
 * @see Occupation
 *
 * @author Jeremy Dostal-Sharp
 * @version (29/07/2020)
 */

public class OccupationDatabase {
    /** The database collection is represented as a set */
    private Set<Occupation> database;

    /** File path to database */
    private final String dbFileName;

    /**
     * Invariant: database != null && dcFilename != null
     */

    /**
     * Creates a new OccuaptionDatabase with the given string
     * for the file path.
     *
     * @param filename file path to database store.
     */
    public OccupationDatabase(String filename) {
        database = new HashSet<Occupation>();
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
            database = (Set<Occupation>) input.readObject();
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
     * Add an Occupation to the database.
     *
     * @param occ the occupation to add
     */
    public void add(Occupation occ) {database.add(occ); }

    /**
     * Remove a Occupation from the database
     *
     * @param occ the occupation to remove
     */
    public void remove(Occupation occ) { database.remove(occ); }

    /**
     * Update an Occupation in the database if present, adds if not present.
     * @param occ the occupation to update.
     */
    public void update(Occupation occ) {
        if (database.contains(occ)) {
            database.remove(occ);
        }
        database.add(occ);
    }

    /**
     * Search the occupation database for a character with the given name
     * @require name != null && database != null
     * @ensure occupation with given name in DB => \result = occupation found &&
     *         occupation with given bame not in DB => \result = null
     * @param name the character nae to search for
     * @return character object found or null
     */
    public Occupation search(String name) {
        try {
            for (Occupation occ : database)
                if (name.equals(occ.getName()))
                    return (Occupation) occ.clone();
        } catch (ClassCastException cce) {}

        return null;
    }

    /**
     * Returns a sorted list of the occupations in the database.
     * @return Returns a list of the occupations in the database.
     */
    public List<String> getOccupationNames() {
        List<String> names = new ArrayList<String>();
        for (Occupation occupation : database) {
            names.add(occupation.getName());
        }
        names.sort(String::compareToIgnoreCase);
        return names;
    }

    @Override
    public String toString() {
        String result = String.format("Occupation Database [%s]", dbFileName);
        if (database.isEmpty()) {
            result += "\n Empty";
        }
        for (Occupation occupation : database) {
            result += String.format("\n %s", occupation.toString());
        }

        return result;
    }
}
