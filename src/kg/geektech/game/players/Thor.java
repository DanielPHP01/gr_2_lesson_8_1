package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.FROZEN, name);
    }
    private static int thorHit() {
       boolean check = RPG_Game.random.nextBoolean();
        if (check) {
             return 1;


         } else return 0;
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 && (thorHit() == 1)){
            boss.setDamage(0);
            System.out.println(" Boss frozen ");
        } else boss.setDamage(50);


    }
}
