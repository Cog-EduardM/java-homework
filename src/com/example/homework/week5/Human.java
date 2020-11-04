package com.example.homework.week5;

public class Human implements Character {

    private int health;
    private int ammo;
    private boolean isDead;

    public Human() {
        this.health = 100;
        this.ammo = 200;
        this.isDead = false;
    }

    @Override
    public String getInfo() {
        return "health: " + this.getHealth() +
                ", ammo: " + this.getAmmo() +
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

    public int getAmmo() {
        return this.ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo < 0 ? 0 : ammo;
    }

    public void shootAlien(Alien a) {
        if (!this.isDead()) {
            if (this.ammo >= 15) {
                a.setHealth(a.getHealth() - 25);
            }

            this.setAmmo(this.ammo - 15);
        }
    }
}
