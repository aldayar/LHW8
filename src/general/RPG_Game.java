package general;

import players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_Number;
    public static Random random = new Random();


    public static void start() {
        Boss boss = new Boss(1000,50);
        Warrior warrior = new Warrior(270,15,"Воин1");
        Medic doc = new Medic(220,5,"Doc",15);
        Magic magic = new Magic(240,20,"magic");
        Bersek bersek =new Bersek(300,20,"bersek");
        Medic assistant = new Medic(250,10,"assistant",5);
        Antman antman=new Antman(210,15,"antman");
        Hacker hacker=new Hacker(100,5,"hacker");
        Golem golem= new Golem(500,20,"golem");
        Witcher witcher= new Witcher(400,0,"WITCHER");
        Druid druid = new Druid(300,35,"Driada","Abigeil","Crown");
        Thor thor = new Thor(250,25,"thor");

        Hero[] heros ={warrior,doc,magic,bersek,assistant,antman,hacker,golem,witcher,druid,thor};

        printStatistic(boss,heros);

        while (!isGameFinished(boss,heros)){
            round(boss,heros);
        }







    }
    private static void round(Boss boss,Hero[] heroes){
        round_Number++;
        bossHit(boss,heroes);
        heroesHit(boss,heroes);
        applySuperPower(boss,heroes);
        printStatistic(boss,heroes);

    }
    private static void printStatistic(Boss boss,Hero[] heroes){
        System.out.println("--------------["+round_Number+" Round] --------------");
        System.out.println();
        System.out.println("Boss health: "+boss.getHealth()+" ["+ boss.getDamage()+"]");
        System.out.println();
        for (Hero hero:heroes){
            System.out.println(hero.getName()+" health "+hero.getHealth()+" ["+hero.getDamage()+"]");


        }

    }
    private static void  bossHit(Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0){
                heroes[i].setHealth( heroes[i].getHealth()- boss.getDamage());

            }

        }

    }
    private static void heroesHit(Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0){
               boss.setHealth( boss.getHealth()-heroes[i].getDamage());

            }

        }

    }
    private static boolean isGameFinished(Boss boss,Hero[] heroes){
        if  (boss.getHealth()<=0){
            System.out.println("Heroes won!");
            return true;

        }
        boolean allHeroesDead=true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0){
                allHeroesDead=false;
                break;
            }

        }
        if (allHeroesDead){
            System.out.println("boss won");
        }
        return allHeroesDead;

    }
    private static void applySuperPower(Boss boss,Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0){
                heroes[i].applySuperAbility(heroes,boss);
            }
            
        }
    }



}
