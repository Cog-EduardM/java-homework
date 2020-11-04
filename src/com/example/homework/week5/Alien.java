package com.example.homework.week5;

public class Alien implements Character {

    private int health;
    private int energy;
    private boolean isDead;

    public Alien() {
        this.health = 200;
        this.energy = 100;
        this.isDead = false;
    }

    @Override
    public String getInfo() {
        return "health: " + this.getHealth() +
                ", energy: " + this.getEnergy() +
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
        this.energy = energy < 0 ? 0 : energy;
    }

    public void biteHuman(Human h) {
        if (!this.isDead()) {
            if (this.energy >= 80) {
                h.setHealth(h.getHealth() - 25);
            } else if (this.energy >= 50) {
                h.setHealth(h.getHealth() - 15);
            } else if (this.energy >= 10) {
                h.setHealth(h.getHealth() - 10);
            }

            this.setEnergy(this.energy - 10);
        }
    }
}
