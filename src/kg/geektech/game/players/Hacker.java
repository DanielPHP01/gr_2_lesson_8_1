package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero {
    private int fullBossHealth;


    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.HACKER_SKILL, name);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        int stolenHealth = RPG_Game.random.nextInt(boss.getHealth() + 1);
        int whoAddStolensBossHealts = RPG_Game.random.nextInt(heroes.length) - 1;

        for (int i = 0; i < whoAddStolensBossHealts; i++) {
            if (this.getHealth() > 0 && boss.getHealth() > 0 && boss.getDefence() != SuperAbility.HACKER_SKILL) {
                fullBossHealth = boss.getHealth();
                boss.setHealth(fullBossHealth - stolenHealth);
                whoAddStolensBossHealts = getHealth();
                whoAddStolensBossHealts += stolenHealth;
                heroes[i].setHealth(whoAddStolensBossHealts);
                System.out.println(" Hacker взломал босса на " + stolenHealth + " Передал к " + heroes[i].getName());
            }
            break;
        }


        return 0;
    }
}

