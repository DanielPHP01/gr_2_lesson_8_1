package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(5) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i] && boss.getDefence() != SuperAbility.BOOST)
                heroes[i].setDamage(heroes[i].getDamage() + coefficient);


        }
        System.out.println(" Strange бустанул " + coefficient);

        return coefficient;
    }
}
