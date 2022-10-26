package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    private int savedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getDamage() != 0) {
            setSavedDamage(RPG_Game.random.nextInt(boss.getDamage()) + 1);
            if (boss.getHealth() > 0 && this.getHealth() > 0)
                this.setHealth(this.getHealth() - savedDamage);
            boss.setHealth(boss.getHealth() - (savedDamage + this.getDamage()));
            System.out.println(" Ragnar Работает ");
        }

        return 0;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }
}
