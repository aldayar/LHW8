package players;

import general.RPG_Game;

public class Druid extends Hero implements HavingSuperAbility {
    private String angel;
    private String crown;

    public Druid(int health, int damage, String name, String angel, String crown) {
        super(health, damage, SuperAbility.SPAWN_CROW_OR_ANGEL, name);
        this.angel = angel;
        this.crown = crown;
    }

    public String getAngel() {
        return angel;
    }

    public void setAngel(String angel) {
        this.angel = angel;
    }

    public String getCrown() {
        return crown;
    }

    public void setCrown(String crown) {
        this.crown = crown;
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int randomNumber = RPG_Game.random.nextInt(50) + 1;
        for (int i = 0; i < heroes.length; i++) {

            if (boss.getHealth() > 150 && heroes[i].getDamage() < boss.getHealth() && heroes[i].getHealth() > 300) {
                heroes[i].setHealth(heroes[i].getHealth() + randomNumber);
                System.out.println("Друид вызвал: " + this.angel + "Помощь по всем игрокам на: " + randomNumber);

            }
            if (boss.getHealth() < 150 && heroes[i].getDamage() < boss.getHealth() && heroes[i].getHealth() < 200) {
                heroes[i].setDamage(heroes[i].getDamage() + randomNumber);
                System.out.println("Друид вызвал: " + this.crown + " урон игроков увеличивается! на :[" + randomNumber + "]");
            }else{
                System.out.println("Босс слишком слаб, а друида слишком добра");
            }


        }
    }
}
