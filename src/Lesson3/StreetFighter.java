package Lesson3;

import java.util.ArrayList;
import java.util.Random;

public class StreetFighter {
    private static final ArrayList<StreetFighter> fighters = new ArrayList<StreetFighter>();

    private String name;
    private Integer health ;
    private Integer code;
    private Integer attack;

    public StreetFighter(String name, Integer health, Integer code, Integer attack) {
        this.name = name;
        this.health = health;
        this.code = code;
        this.attack = attack;
    }

    public void getFighterInfo(String name) {
        for (StreetFighter fighter : fighters) {
            if (fighter.name.equals(name)) {
                System.out.println(fighter.name);
                System.out.println(fighter.health);
                System.out.println(fighter.code);
                System.out.println(fighter.attack);
            }
        }
    }

    public void getFighters(){
        for (StreetFighter fighter : fighters) {
            System.out.println(fighter.name);
            System.out.println(fighter.health);
            System.out.println(fighter.code);
            System.out.println(fighter.attack);
        }
    }

    public void fight(StreetFighter fighter) {
        boolean action = new Random().nextBoolean();
        StreetFighter attacker;
        StreetFighter defender;

        if (action) {
            attacker = fighter;
            defender = this;
        }else {
            attacker = this;
            defender = fighter;
        }

        System.out.println("Бой начинается!" + this.name + " VS " + fighter.name);
        System.out.println(attacker.name + " атакует первым!\n");

        while (this.health > 0 &&  fighter.health > 0) {
            defender.health -= attacker.attack;
            System.out.println(attacker.name + " ударил " + defender.name +
                    " на " + attacker.attack + " урона. " +
                    defender.name + " осталось " + Math.max(defender.health, 0) + " HP.");


            StreetFighter temp = attacker;
            attacker = defender;
            defender = temp;

            if (this.health <= 0) {
                System.out.println(fighter.name + " победил!");
            } else {
                System.out.println(this.name + " победил!");
            }
        }
    }
}
