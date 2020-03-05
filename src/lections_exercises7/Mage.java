/*
Создать классы Warrior, Mage и Archer, представляющие собой
наследников класса Hero
Переопределить в них метод attackEnemy() для вывода
специализированного для этого класса сообщения об атаке.
Переопределить метод в подклассах Warrior,Mage и
Archer так, чтобы каждый герой наносил врагу разное количество урона.
 */
package lections_exercises7;

public class Mage extends Hero {
    static String name;
    static int health = 100;
    int damage = 20;

    @Override
    public void attackEnemy(String enemyName) {
        if(enemyName.equals("Zombie")){
            System.out.println(name + " зачаровывает врага, " + " наносит ему " + damage + " баллов урона");
            if (Zombie.health>=0) {
                System.out.println("У зомби осталось " + Zombie.takeDamage(damage)+ " баллов здоровья");
            } else {
                System.out.println("Зомби мертв");
            }

        } else {
            System.out.println(name + " зачаровывает врага, " + " наносит ему " + damage + " баллов урона");
            if (Dragon.health>=0) {
                System.out.println("У дракона осталось " + Dragon.takeDamage(damage) + " баллов здоровья");
            } else {
                System.out.println("Дракон мертв");
            }
        }
    }

    @Override
    public void attackEnemy(String enemyName, String enemyName2) {
        System.out.println(" Маг " + name + " зачаровывает зомби и атакует дракона волшебными стрелами");
        if (Zombie.health>=0) {
            System.out.println("У зомби остается " + Zombie.takeDamage(damage) + " баллов здоровья");
        } else {
            System.out.println("Зомби мертв");
        }
        if (Dragon.health>=0) {
            System.out.println("У дракона остается " + Dragon.takeDamage(damage) + " баллов здоровья");
        } else{
            System.out.println(" Дракон мертв");
        }
    }

    public Mage(String name) {
        this.name = name;
    }

    @Override
    public String getName(String name) {
        this.name = name;
        return name;
    }
    public static int takeDamage(int damage) {
        return health -=damage;
    }
    public static boolean isMageAlive(){
        if(Mage.health>0){
            return true;
        }
        return false;
    }
}
