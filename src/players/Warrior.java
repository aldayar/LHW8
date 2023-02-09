package players;

import general.RPG_Game;

public class Warrior extends Hero{
    public Warrior(int health, int damage,  String name) {
        super(health, damage,SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int criticalDamage= RPG_Game.random.nextInt(4)+2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0 && heroes[i].getName()==this.getName()){
                heroes[i].setDamage(boss.getHealth()-heroes[i].getDamage()*criticalDamage);
                System.out.println("Воин наконец решил зделать крит удар на: "+criticalDamage);
            }

        }

    }
}
