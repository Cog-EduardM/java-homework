package com.example.homework.week5;

import com.example.homework.Runnable;
import com.example.utils.HomeworkUtils;

public class Week5Homework extends HomeworkUtils implements Runnable {
    public void runHomework() {
        this.printHomeworkHeading(5);

        runScriptedScenario();
        runRandomScenario();
    }

    /**
     * <p>Method implements homework requirements:
     * </p>
     *
     *
     * <p><strong>1.</strong> Create two objects: human and alien</p>
     * <p><strong>2.</strong> Alien bites human 1 time.
     * Print human health and alien energy before and after this operation</p>
     * <p><strong>3.</strong> Human shoots an alien 2 times.
     * Print alien health and human ammo before and after this operation</p>
     */
    private void runScriptedScenario() {
        this.printExerciseHeading("Quick Test");


        Human h1 = new Human();
        Alien a1 = new Alien();

        this.printExerciseHeading("2. Alien bites Human once");

        System.out.println("Before - h1 health: " + h1.getHealth() + ", a1 energy: " + a1.getEnergy());
        a1.biteHuman(h1);
        System.out.println("After - h1 health: " + h1.getHealth() + ", a1 energy: " + a1.getEnergy());

        /*
            3
         */
        this.printExerciseHeading("3. Human shoots Alien twice");

        System.out.println("Before - a1 health: " + a1.getHealth() + ", h1 ammo: " + h1.getAmmo());
        h1.shootAlien(a1);
        System.out.println("After 1 shot - a1 health: " + a1.getHealth() + ", h1 ammo: " + h1.getAmmo());
        h1.shootAlien(a1);
        System.out.println("After 2 shots - a1 health: " + a1.getHealth() + ", h1 ammo: " + h1.getAmmo());
    }

    /**
     * <p>Method creates one Human and one Alien,
     * then runs the game until one of the Characters is dead.</p>
     *
     * <p>Each turn, it'll randomly decide which character attacks.</p>
     */
    private void runRandomScenario() {
        this.printExerciseHeading("Random scenario");

        Human h2 = new Human();
        Alien a2 = new Alien();

        int turnNo = 0;


        while (!h2.isDead() && !a2.isDead()) {
            System.out.println("");
            System.out.println("Turn " + ++turnNo);

            boolean humanTurn = this.generateRandomNumberInRange(0,1) == 1;

            if (humanTurn) {
                System.out.println("Human h2 (" + h2.getInfo() + ") shoots Alien a2 (" + a2.getInfo() + ")...");
                h2.shootAlien(a2);
                System.out.println("Human h2 new attributes: "+ h2.getInfo());
                System.out.println("Alien a2 new attributes: " + a2.getInfo());
            } else {
                System.out.println("Alien a2 (" + a2.getInfo() + ") bites Human h2 (" + h2.getInfo() + ")...");
                a2.biteHuman(h2);
                System.out.println("Alien a2 new attributes: " + a2.getInfo());
                System.out.println("Human h2 new attributes: "+ h2.getInfo());
            }
        }

        if(h2.isDead()) {
            System.out.println("Turn " + turnNo + ": Human h2 died. Game Over.");
        }
        if(a2.isDead()) {
            System.out.println("Turn " + turnNo + ": Alien a2 died. Game Over.");
        }
    }

}
