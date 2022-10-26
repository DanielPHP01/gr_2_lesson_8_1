package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class TrickyBastard extends Hero {
    private boolean abilityUsedCheck;

    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, SuperAbility.PLAY_DEAD, name);
    }

    private static int bastardHit() {
        boolean check = RPG_Game.random.nextBoolean();
        if (check) {
            return 1;
        } else return 0;
    }


    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {

        if (bastardHit() == 1 && this.getHealth() > 0 && boss.getDefence() != SuperAbility.PLAY_DEAD && !abilityUsedCheck) {
            this.setHealth(this.getHealth() + boss.getDamage());
            boss.setHealth(boss.getHealth() + this.getDamage());
            abilityUsedCheck = true;
            System.out.println(" Ghost Притворился мертвым ");
        } else {

        }
        return 0;

    }
}

