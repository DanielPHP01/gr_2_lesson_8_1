package kg.geektech.game.players;

public class Golem extends Hero {
    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK, name);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && boss.getDamage() != 0 && this.getHealth() > 0) {
            this.setHealth((this.getHealth() - ((boss.getDamage() / 5))));
            boss.setDamage((boss.getDamage() / 5) * 4);
            System.out.println(" Golem сработал ");
        } else boss.setDamage(50);

    }
}

