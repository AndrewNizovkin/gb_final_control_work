package registry.presenter;

import java.util.Date;

public interface Parser {

    /**
     * Checks data
     * @param line String
     * @return boolean
     */
    boolean isValidData(String line);

    /**
     * Gets Date from String
     * @param line String date
     * @return Date
     */
    Date getDate(String line);
}
