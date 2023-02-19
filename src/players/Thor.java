package players;


import general.RPG_Game;

public class Thor extends Hero implements HavingSuperAbility{

    public Thor(int health, int damage,  String name) {
        super(health, damage, SuperAbility.TO_SHOCK, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int coef= RPG_Game.random.nextInt(10)+1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0 && heroes[i].getName()==this.getName()){
                if (heroes[i].getDamage()> boss.getHealth() && heroes[i].getName()==this.getName()){
                    if (coef>5){
                        boss.setDamage(0);
                        System.out.println(" тор оглушил польностю босса ");
                    }else{
                        System.out.println("Тор сегодня милосердный на: "+coef+"%");
                    }

                }
            }

        }

    }
}
