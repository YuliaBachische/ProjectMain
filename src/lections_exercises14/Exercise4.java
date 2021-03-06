package lections_exercises14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise4 {
    public static void main(String[] args) {
        String str = "+375293651474 +37529365147 +37529365 +3752793651474 +375293651474 +3752936514748 +9803288909";
        Pattern p = Pattern.compile("^\\+375(\\d{2})\\d{7}$");
        Matcher m;
        String [] array = str.split(" ");
        for(int i = 0; i < array.length; i++){
            m = p.matcher(array[i]);
            if(m.find()){
                array[i] = array[i].replaceAll(m.group(1), "\\(" + m.group(1) + "\\)");
                System.out.println(array[i]);
            }
        }
    }
}
