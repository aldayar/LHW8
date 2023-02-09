package players;

import general.RPG_Game;

public class Antman extends Hero{
    public Antman(int health, int damage,  String name) {
        super(health, damage,SuperAbility.BIGGER_OR_SMALLER, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int biggerOrSmaller= RPG_Game.random.nextInt(10);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getName() == this.getName()){
                if (biggerOrSmaller<=5){
                    System.out.println("Человек муровей вырос на: "+biggerOrSmaller+"%");
                    heroes[i].setDamage(40);
                    heroes[i].setHealth(300);
                }else {
                    System.out.println("Человек муроыей уменшился на: "+biggerOrSmaller+"%");
                    heroes[i].setDamage(3);
                    heroes[i].setHealth(100);
                }

            }


        }

    }
}
