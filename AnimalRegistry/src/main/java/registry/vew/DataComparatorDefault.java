package registry.vew;

import registry.model.Animal;
import registry.presenter.Parser;

import java.util.Comparator;
import java.util.Date;

public class DataComparatorDefault implements Comparator<Animal> {
    private final Parser parser;

    /**
     * Constructor
     */
    public DataComparatorDefault() {
        parser = new ParserDefault();
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     */
    @Override
    public int compare(Animal o1, Animal o2) {
        Date date1 = parser.getDate(o1.getBirthDate());
        Date date2 = parser.getDate(o2.getBirthDate());
        if (date1.after(date2)) return -1;
        if (date2.after(date1)) return 1;
        return 0;

    }
}
