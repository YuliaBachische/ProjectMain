package lections_exercises14;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Exercise3 {
    private static Logger LOGGER = Logger.getLogger(Exercise3.class);
    public static void main(String[] args) {
        String str = "sfs <p id = p1> fef <p id = p1> seller ";
        str = str.replace("<p id = p1>", "<p>");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(str);
    }
}