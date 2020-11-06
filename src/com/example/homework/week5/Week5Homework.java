package com.example.homework.week5;

import com.example.homework.Runnable;
import com.example.utils.HomeworkUtils;

public class Week5Homework extends HomeworkUtils implements Runnable {
    public void runHomework() {
        this.printHomeworkHeading(5);

        runScriptedScenario();
        runRandomizedScenario();
        runGames(10000);
    }

    /**
     * runs {@link #runRandomizedScenario()} the specified number of times and prints the final score.
     *
     *  @param iterations The number of games to be run.
     */
    private void runGames(int iterations) {
        int alienScore = 0, humanScore = 0;

        for (int i = 0; i < iterations; i++) {
            int[] result = runRandomizedScenario();
            alienScore += result[0];
            humanScore += result[1];
        }

        System.out.println("\nScore after " + iterations + " games: Aliens " + alienScore + "-" + humanScore + " Humans.");
    }

    /**
     * Method implements homework requirements:
     * <hr></hr>
     *
     * <p><strong>1.</strong> Create two objects: {@link Human} and {@link Alien}</p>
     * <p></p>
     * <p><strong>2.</strong> Alien bites human 1 time.
     * Print human health and alien energy before and after this operation</p>
     * <p></p>
     * <p><strong>3.</strong> Human shoots an alien 2 times.
     * Print alien health and human ammo before and after this operation</p>
     */
    private void runScriptedScenario() {
        this.printExerciseHeading("Quick Test");

        //1
        Human h1 = new Human();
        Alien a1 = new Alien();

        //2
        this.printExerciseHeading("2. Alien bites Human once");
        System.out.println("Before - Human h1 health: " + h1.getHealth() + ", Alien a1 energy: " + a1.getEnergy());
        a1.biteHuman(h1);
        System.out.println("After  - Human h1 health: " + h1.getHealth() + ", Alien a1 energy: " + a1.getEnergy());

        //3
        this.printExerciseHeading("3. Human shoots Alien twice");
        System.out.println("Before        - Alien a1 health: " + a1.getHealth() + ", Human h1 ammo: " + h1.getAmmo());
        h1.shootAlien(a1);
        System.out.println("After 1 shot  - Alien a1 health: " + a1.getHealth() + ", Human h1 ammo: " + h1.getAmmo());
        h1.shootAlien(a1);
        System.out.println("After 2 shots - Alien a1 health: " + a1.getHealth() + ", Human h1 ammo: " + h1.getAmmo());
    }

    /**
     * Method creates one {@link Human} and one {@link Alien},
     * then runs the game until one of the Characters is dead.
     * <p></p>
     * Each turn, it'll randomly decide which character attacks.
     *
     * @return a string of two integers: first is Aliens's score, the second is Human's score
     */
    private int[] runRandomizedScenario() {
        this.printExerciseHeading("Random scenario");

        Human h2 = new Human();
        Alien a2 = new Alien();
        int turnNo = 0;

        while (opponentsAreAlive(a2, h2) && opponentsCanAttack(a2, h2)) {
            System.out.println("\nTurn " + ++turnNo);
            System.out.println("Before attack - Human h2 (" + h2.getInfo() + ")    Alien a2 (" + a2.getInfo() + ")");

            boolean humanTurn = this.generateRandomNumberInRange(0,1) == 1;

            if (humanTurn) {
                System.out.println("    ...Human h2 shoots Alien a2.");
                h2.shootAlien(a2);
            } else {
                System.out.println("    ...Alien a2 bites Human h2.");
                a2.biteHuman(h2);
            }

            System.out.println("After attack  - Human h2 (" + h2.getInfo() + ")    Alien a2 (" + a2.getInfo() + ")");
        }

        if(h2.isDead()) {
            System.out.println("\nTurn " + turnNo + ": Human h2 died; Alien a2 wins. Game Over.");
            return new int[] {1, 0};
        }
        if(a2.isDead()) {
            System.out.println("\nTurn " + turnNo + ": Alien a2 died. Human h2 wins. Game Over.");
            return new int[] {0, 1};
        }

        return new int[] {0,0};
    }

    /**
     *
     * @param a {@link Alien} player to be checked
     * @param h {@link Human} player to be checked
     * @return <strong>true</strong> - if both players are alive
     */
    private static boolean opponentsAreAlive(Alien a, Human h) {
        return !a.isDead() && !h.isDead();
    }

    /**
     *
     * @param a {@link Alien} player to be checked
     * @param h {@link Human} player to be checked
     * @return <strong>true</strong> - if at least one player can attack
     */
    private static boolean opponentsCanAttack(Alien a, Human h) {
        return a.getEnergy() > 0 || h.getAmmo() > 0;
    }
}
