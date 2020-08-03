package Character.Tools;

import java.util.ArrayList;
import java.util.List;

public class CSVLineSeparator {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public static List<String> parseLine(String csvLine) {
        return parseLine(csvLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String csvLine, char separators) {
        return parseLine(csvLine, separators, DEFAULT_QUOTE);
    }

    /**
     * Reads in a Comma Separated Value (CSV) line and splits it into a list item that has
     * each separated value as a different list item.
     * If there are "," or '"' in the CSV line surround the text with double quotes ("text").
     * @param csvLine a CSV line of input to be separated.
     * @param separators the separator used to delineate between values.
     * @param customQuote the quote identifier used in text
     * @return a list of separated values or null
     */
    public static List<String> parseLine(String csvLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //Check to see if csvLine is empty or null
        if (csvLine == null || csvLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        StringBuffer currentValue = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = csvLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {
                    if (ch == '\"') {
                        if(!doubleQuotesInColumn) {
                            currentValue.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        currentValue.append(ch);
                    }
                }
            } else {
                if (ch == customQuote) {
                    inQuotes = true;

                    if (chars[0] != '"' && customQuote == '\"') {
                        currentValue.append('"');
                    }

                    if (startCollectChar) {
                        currentValue.append('"');
                    }
                } else if (ch == separators) {
                    result.add(currentValue.toString());

                    currentValue = new StringBuffer();
                    startCollectChar = false;
                } else if (ch == '\r') {
                    continue;
                } else if (ch == '\n') {
                    break;
                } else {
                    currentValue.append(ch);
                }
            }
        }
        result.add(currentValue.toString());

        return result;
    }
}
