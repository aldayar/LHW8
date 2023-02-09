package players;

import general.RPG_Game;

public class Bersek extends Hero{
    public Bersek(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int revertCoef= RPG_Game.random.nextInt(25)+1;// берсерк радномно отдает часть  сохраненного урона от босса
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>heroes[i].getDamage() && heroes[i].getName()==this.getName()){
                heroes[i].setDamage(boss.getHealth()-heroes[i].getDamage()*revertCoef);
                System.out.println(" Берсерк бустанул на: "+revertCoef);

            }

        }

    }
}
