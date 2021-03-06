/*
Создать собственный класс-исключение-наследник класса Exception.
Создать метод, выбрасывающий это исключение.
Вызвать этот метод и отловить исключение. Вывести stacktrace в
консоль.
 */
package lections_exercises12;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MyException extends Exception {
    private static Logger LOGGER = Logger.getLogger(MyException.class);

    public static int getPositiveResult(int num) throws MyException{
        if(num<0) {
            throw new MyException();
        }
        else return num*num;
    }
    public static void main(String[] args) {
        try {
            LOGGER.setLevel(Level.INFO);
            LOGGER.info(MyException.getPositiveResult(-8));
        } catch (MyException ex){
            LOGGER.error("The result is negative");
        }
    }
}
