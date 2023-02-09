package players;

public class Medic extends Hero{
    private int healpoints;

    public Medic(int health, int damage, String name, int healpoints) {
        super(health, damage,SuperAbility.HEAL, name);
        this.healpoints = healpoints;
    }

    public int getHealpoints() {
        return healpoints;
    }

    public void setHealpoints(int healpoints) {
        this.healpoints = healpoints;
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i <heroes.length; i++) {
            if (heroes[i].getHealth()>0 && heroes[i].getHealth()<100 && heroes[i].getName()!=this.getName()){
                heroes[i].setHealth(heroes[i].getHealth()+this.getHealpoints());
                System.out.println(this.getName()+" Медик вылечил: "+this.getHealpoints()+heroes[i].getName());
                System.out.println();
            }
            
        }

    }
}
