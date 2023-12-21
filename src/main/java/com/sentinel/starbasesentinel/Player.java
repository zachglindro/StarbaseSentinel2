/********************
 *
 * This class represents the user.
 * It keeps track of their coins, enemies allowed within the base,
 * and whether they won or lost.
 *
 * @author: Zach Dwayne Glindro, Kervin Ralph Samson
 * @date: 2023-12-21 11:59
 *
 *
 */

package com.sentinel.starbasesentinel;

public class Player {
    private int enemiesInfiltrated;
    private final static  int maxEnemiesInfiltrated = 3;
    private int coins;
    private String gameOver;

    public Player() {
        enemiesInfiltrated = 0;
        coins = 200;
        gameOver = "";
    }

    public void setGameOver(String condition) {
        gameOver = condition;
    }

    public boolean won() {
        return gameOver.equals("won");
    }

    public boolean lost() {
        return gameOver.equals("lost");
    }

    public void removeCoins(int cost) {
        coins -= cost;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public int getEnemiesInfiltrated() {
        return enemiesInfiltrated;
    }

    public static int getMaxEnemiesInfiltrated() {
        return maxEnemiesInfiltrated;
    }

    public void incrementEnemiesInfiltrated(){
        this.enemiesInfiltrated += 1;
        System.out.println("Enemies infiltrated: "+enemiesInfiltrated);
    }
}
