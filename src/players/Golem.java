package players;

import general.RPG_Game;

public class Golem extends Hero implements HavingSuperAbility{
    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.GOLEM_POWER, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {

        int saveDamage= RPG_Game.random.nextInt(50)+1;
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth()>0){
                if (boss.getDamage()<saveDamage){
                    System.out.println("у босса не достаточно урона для накопления");
                    break;
                }
                if (heroes[i].getHealth()> boss.getDamage()){
                    boss.setDamage(boss.getDamage()-saveDamage);
                    System.out.println("голем принял удар на: "+saveDamage+"%");
                }
            }
        }

    }
}
