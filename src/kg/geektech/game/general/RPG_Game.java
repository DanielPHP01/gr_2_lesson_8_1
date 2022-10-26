package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Tanos");
        Warrior warrior = new Warrior(290, 10, "Zeus");
        Medic doc = new Medic(250, 5, 15, "Gipokrat");
        Magic magic = new Magic(280, 20, "Strange");
        Berserk berserk = new Berserk(270, 15, "Ragnar");
        Medic assistant = new Medic(265, 5, 5, "Vasya");
        Avrora avrora = new Avrora(250, 10, "Avrora");
        Thor thor = new Thor(250, 10, "Thor");
        Golem golem = new Golem(300, 10, "Golem");
        Kamikadze kamikadze = new Kamikadze(300, 0, "Kamikadze");
        TrickyBastard trickyBastard = new TrickyBastard(200, 20, "Ghost");
        Samurai samurai = new Samurai(200, 12, "Samurai");
        //Hacker hacker = new Hacker(200,5,"Hacker");
        // Deku deku = new Deku(200,10,"Deku");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, avrora, thor, golem, kamikadze, trickyBastard, samurai};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    public static int getRoundNumber() {
        return roundNumber;
    }
}
