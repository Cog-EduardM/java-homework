package com.example.homework.week5;

public class Alien implements Character {

    private int health;
    private int energy;
    private int potions;
    private boolean isDead;

    public Alien() {
        this.health = 200;
        this.energy = 100;
        this.potions = 3;
        this.isDead = false;
    }

    @Override
    public String getInfo() {
        return "health: " + this.getHealth() +
                ", energy: " + this.getEnergy() +
                ", potions: " + this.getPotions() +
                ", isDead: " + this.isDead();
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int health) {
        if (health <=0) {
            this.health = 0;
            this.setEnergy(0);
            this.dies();
        } else {
            this.health = health;
        }
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    private void dies() {
        this.isDead = true;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, energy);
    }

    private int getPotions() {
        return this.potions;
    }

    private void drinkPotion() {
        System.out.println("    ...Alien energy refilled.");
        this.potions--;
        this.energy = 100;
    }

    /**
     * @return <strong>true</strong> - 20% of the time
     */
    private boolean isCriticalHit() {
        return Math.random() < 0.2;
    }

    public void biteHuman(Human h) {
        int damage = 60;

        if (!this.isDead()) {
            if (this.energy >= 80) {
                damage = isCriticalHit() ? damage : 25;
                h.setHealth(h.getHealth() - damage);
            } else if (this.energy >= 50) {

                //refill energy for maximum damage, if any potion left
                if (this.potions > 0) {
                    this.drinkPotion();
                    damage = isCriticalHit() ? damage : 25;
                } else {
                    damage = isCriticalHit() ? damage : 15;
                }

                h.setHealth(h.getHealth() - damage);
            } else if (this.energy >= 10) {
                damage = isCriticalHit() ? damage : 10;
                h.setHealth(h.getHealth() - damage);
            }

            this.setEnergy(this.energy - 10);
        }
    }
}