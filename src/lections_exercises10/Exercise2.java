/*
�������. ������� ������ ������ �������� � ������� ListIterator,
��������� ���������� ��������. ����� ����� ������� ������ �
�������������� ���������
 */
package lections_exercises10;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;

public class Exercise2 {
    private static Logger LOGGER = Logger.getLogger(Exercise2.class);
    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        Integer [] nums = new Integer[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Random();
        }
        ArrayList<Integer> listOfMarks = new ArrayList<>(Arrays.asList(nums));
        int max = 0;
        ListIterator<Integer> numListIter = listOfMarks.listIterator();
        while (numListIter.hasNext()) {
            int number = numListIter.next();
            if (number>max) {
                max=number;
            }
        }
        LOGGER.info("All marks: " + listOfMarks);
        LOGGER.info("The highest mark: " + max);
    }


    public static int Random() {
        Random random = new Random();
        return random.nextInt(10);
    }
}