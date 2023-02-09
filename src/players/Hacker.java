package players;


import general.RPG_Game;

public class Hacker extends Hero{


    public Hacker(int health, int damage,String name) {
        super(health, damage, SuperAbility.HACK_AND_GIVE, name);

    }



    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int stollingHealth= RPG_Game.random.nextInt(20)+1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && heroes[i].getName()!=this.getName()) {
                int giveHealth = boss.getHealth() - stollingHealth;
                heroes[i].setHealth(heroes[i].getHealth() + giveHealth);
                System.out.println("хакер украл ХР у босса и дал к: " + heroes[i].getName());


            }
        }


    }
}
