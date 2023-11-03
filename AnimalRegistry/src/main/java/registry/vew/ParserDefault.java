package registry.vew;

import registry.presenter.Parser;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ParserDefault implements Parser {
    /**
     * Checks data
     *
     * @param line String
     * @return boolean
     */
    @Override
    public boolean isValidData(String line) {
        if (!line.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) return false;
        return true;
    }

    /**
     * Gets Date from String
     *
     * @param line String date
     * @return Date
     */
    @Override
    public Date getDate(String line) {
        String[] array = line.split("-");
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.getTime();
    }
}
