package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Deku extends Hero {
    private int var;

    public Deku(int health, int damage, String name) {
        super(health, damage, SuperAbility.DEKU_SKILL, name);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        int randomNumber = RPG_Game.random.nextInt(2) + 1;
        int summa = this.getDamage() + boss.getDamage() / 8;
        boss.setHealth(boss.getHealth() - this.getDamage() * randomNumber * summa);
        System.out.println(" Способность Deku активирован " + this.getDamage() * randomNumber * summa);

        return randomNumber;
    }
}
