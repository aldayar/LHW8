package players;

import general.RPG_Game;

import java.util.Random;

public class Magic extends Hero{

    public Magic(int health, int damage,  String name) {
        super(health, damage,SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int number= RPG_Game.random.nextInt(5)+1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && heroes[i].getName()!=this.getName()){
                heroes[i].setDamage(heroes[i].getDamage()+number);
                System.out.println(this.getName()+"  увеличил урон на: "+number +" ["+heroes[i].getName()+"]");
                System.out.println();
            }

        }


    }
}
