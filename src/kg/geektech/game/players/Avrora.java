package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Avrora extends Hero {
    private static int avrorasAbilityWasUsed;
    private static int avrorasSuperDamage;

    public Avrora(int health, int damage, String name) {
        super(health, damage, SuperAbility.INVISIBLE, name);
    }

    private static void avrorasAbility() {
        if (avrorasHit() == 1) {
            avrorasAbilityWasUsed++;
        }
    }

    private static int avrorasHit() {
        boolean check = RPG_Game.random.nextBoolean();
        if (check) {
            return 1;
        } else return 0;
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        avrorasAbility();

        if (this.getHealth() > 0 && avrorasAbilityWasUsed <= 2 && avrorasAbilityWasUsed != 0) {
            this.setHealth(boss.getDamage() + this.getHealth());
            avrorasSuperDamage = avrorasSuperDamage + boss.getDamage();
            avrorasAbilityWasUsed++;
            System.out.println(" Avrora Исчезла!!!");

        }
        else if (avrorasAbilityWasUsed > 1 && avrorasAbilityWasUsed <= 3) {
            boss.setHealth(boss.getHealth() - (this.getDamage() + avrorasSuperDamage));
            avrorasAbilityWasUsed++;
            System.out.println(" Avrora Вернулась!!!");
        }


    }
}

