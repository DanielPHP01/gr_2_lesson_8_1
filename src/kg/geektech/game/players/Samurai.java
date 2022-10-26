package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Samurai extends Hero {
    private boolean abilityCheckUsed;
    private int virus = RPG_Game.random.nextInt(20) + 10; // 1
    private int vaccine = RPG_Game.random.nextInt(100) + 50; // 0
    private boolean check = RPG_Game.random.nextBoolean();
    private boolean checkWhichShuriken = RPG_Game.random.nextBoolean();

    public Samurai(int health, int damage, String name) {
        super(health, damage, SuperAbility.SHOT_SHURIKEN, name);
    }

    private int checking() {
        if (check) {
            return 1;
        } else return 0;
    }

    private int checkingWhichShuriken() {
        if (checkWhichShuriken) {
            return 1;
        } else return 0;
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        if (checking() == 1 && this.getHealth() > 0 && boss.getDefence() != SuperAbility.SHOT_SHURIKEN && checkingWhichShuriken() == 1 && !abilityCheckUsed) {
            boss.setHealth(boss.getHealth() - virus);
            abilityCheckUsed = true;
            System.out.println(" Вирус для босса " + virus);
        } else if (checking() == 1 && this.getHealth() > 0 && boss.getDefence() != SuperAbility.SHOT_SHURIKEN && checkingWhichShuriken() == 0 && !abilityCheckUsed) {
            boss.setHealth(boss.getHealth() + vaccine);
            abilityCheckUsed = true;
            System.out.println(" Вакцина для босса " + vaccine);
        }
        return 0;
    }
}
