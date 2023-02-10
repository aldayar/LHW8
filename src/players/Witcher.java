package players;

public class Witcher extends Hero implements HavingSuperAbility {
    public Witcher(int health, int damage,  String name) {
        super(health, damage, SuperAbility.SAVE_LIFE_HERO, name);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int giveHP=220;
        for (Hero hero:heroes) {
            if (hero.getHealth()==0 && hero.getName() !=this.getName() && hero.getName()== hero.getName()){
                hero.setHealth(hero.getHealth()+giveHP);
                System.out.println("Колдун оживил"+hero.getName());
            }else {
                System.out.println("Колдун не успел оживить");
            }


        }



    }
}
