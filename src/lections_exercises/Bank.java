package lections_exercises;
import java.util.Scanner;

class Bank {
    static int money20 = 100;
    static int money50 = 100;
    static int money100 = 100;
    public static void main(String[]args){
        int numOperation =3;
        do {
            System.out.println("Выберите действие " + "\n" + "1. Снять деньги " + "\n" + "2. Положить деньги" +
                    "\n" + "3. Выход из банка");
            Scanner scanner = new Scanner(System.in);
            numOperation = scanner.nextInt();
            switch (numOperation) {
                case 1:
                    System.out.println("Сколько вы хотите снять(до 8000)?");
                    int numGetMoney = scanner.nextInt();
                    Bank.fromBank(numGetMoney);
                    break;
                case 2:
                    System.out.println("Сколько вы хотите положить купюр по 20 рублей?");
                    int numToBank20 = scanner.nextInt();
                    System.out.println("Сколько вы хотите положить купюр по 50 рублей?");
                    int numToBank50 = scanner.nextInt();
                    System.out.println("Сколько вы хотите положить купюр по 100 рублей?");
                    int numToBank100 = scanner.nextInt();
                    Bank.toBank(numToBank20, numToBank50, numToBank100);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Ошибка. Выберите один из существующих вариантов.");
            }
        }while(numOperation!=3);
    }
    static void fromBank(int money) {
        int sumBank = Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100;
        boolean check = ((((money % 10 == 0) && (money > 10) && (money != 30)) || ((money % 20 == 0) || (money % 50 == 0) || (money % 100 == 0))));
        if ((money > sumBank) || (!check)) {
            System.out.println("Ошибка. Выберите другую сумму");
        } else {
            int money100 = money / 100;
            if (money100 > Bank.money100) {
                int money50 = (money % 100) / 50;
                money50 += (money100 - Bank.money100) * 2;
                int money20 = (((money % 100) % 50) / 20);
                if (((money50 > Bank.money50) || (money50 < Bank.money50)) && (money20 % 20 == 0)) {
                    money20 += (((money50 - Bank.money50) * 50) / 20);
                    money50 = Bank.money50;
                    money100 = Bank.money100;
                    Bank.money20 -= money20;
                    Bank.money50 -= money50;
                    Bank.money100 -= money100;
                    System.out.println("Операция выполнена успешно");
                    System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                            "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                    System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                } else {
                    money100 = money / 100;
                    money50 = (money % 100) / 50;
                    money20 = (((money % 100) % 50) / 20);
                    if (money != money20 * 20 + money50 * 50 + money100 * 100) {
                        System.out.println("Ошибка выполнения");
                    }
                    Bank.money20 -= money20;
                    Bank.money50 -= money50;
                    Bank.money100 -= money100;
                    System.out.println("Операция выполнена успешно");
                    System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                            "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                    System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                }
            } else {
                int money50 = (money % 100) / 50;
                int money20 = (((money % 100) % 50) / 20);
                if ((money20 * 20 + money50 * 50 + money100 * 100 != money) && (money100 == 0)) {
                    money50 = 0;
                    money20 = money / 20;
                    Bank.money20 -= money20;
                    Bank.money50 -= money50;
                    Bank.money100 -= money100;
                    System.out.println("Операция выполнена успешно");
                    System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                            "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                    System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                } else if(money != money20 * 20 + money50 * 50 + money100 * 100) {
                    money100 = money / 100;
                    money50 = 0;
                    money20 = (money % 100) / 20;
                    Bank.money20 -= money20;
                    Bank.money50 -= money50;
                    Bank.money100 -= money100;
                    if(money == money20 * 20 + money50 * 50 + money100 * 100) {
                        System.out.println("Операция выполнена успешно");
                        System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                                "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                        System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                    }
                } else {
                    Bank.money20 -= money20;
                    Bank.money50 -= money50;
                    Bank.money100 -= money100;
                    System.out.println("Операция выполнена успешно");
                    System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                            "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                    System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                }
                if ((money != money20 * 20 + money50 * 50 + money100 * 100) & (money50 == 0)) {
                    money50 = 1;
                    money20 = 4;
                    money100 = (money - money50 * 50 - money20 * 20) / 100;
                    if (money20 * 20 + money50 * 50 + money100 * 100 != money) {
                        money50 = 1;
                        money20 = 3;
                        money100 = (money - money50 * 50 - money20 * 20) / 100;
                        Bank.money20 -= money20;
                        Bank.money50 -= money50;
                        Bank.money100 -= money100;
                        System.out.println("Операция выполнена успешно");
                        System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                                "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                        System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));
                    } else {
                        Bank.money20 -= money20;
                        Bank.money50 -= money50;
                        Bank.money100 -= money100;
                        System.out.println("Операция выполнена успешно");
                        System.out.println(" Купюр 20 рублей - " + " " + money20 + "; " + "Купюр 50 рублей - " + money50 +
                                "; " + " " + "Купюр 100 рублей - " + " " + money100 + ".");
                        System.out.println("В банке осталось - " + (Bank.money20 * 20 + Bank.money50 * 50 + Bank.money100 * 100));

                    }
                }
            }
        }
    }
    static  void toBank(int money20, int money50, int money100){
        Bank.money20 +=money20;
        Bank.money50 += money50;
        Bank.money100 += money100;
        System.out.println("В банкoмате на данный момент хранится: купюр 20 рублей - " + Bank.money20 + "; " +
                "Купюр 50 рублей - " + Bank.money50 + "; " + "Купюр 100 рублей - " + Bank.money100 + ".");
        System.out.println("В банке осталось - " + (Bank.money20*20 + Bank.money50*50 + Bank.money100*100));
    }
    Bank() {
    }
}