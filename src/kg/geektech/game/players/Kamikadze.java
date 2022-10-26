package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Kamikadze extends Hero {
    int coeff = RPG_Game.random.nextInt(2) + 1;


    public Kamikadze(int health, int damage, String name) {
        super(health, damage, SuperAbility.KAMIKADZE_OFFERING, name);
    }

    private int offering() {
        boolean check = RPG_Game.random.nextBoolean();
        if (check) {
            return 1;
        } else return 0;
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0 && offering() == 1 && boss.getDefence() != SuperAbility.KAMIKADZE_OFFERING) {
            boss.setHealth(boss.getHealth() - (this.getHealth() / coeff));
            this.setHealth(0);
            if (coeff == 1) {
                System.out.println(" Kamikadze попал в точно цель и пал ");
            } else {
                System.out.println(" Kamikadze не много промахнулся и погиб ");
            }

        }
        return 0;
    }


}

