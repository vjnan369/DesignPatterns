package com.DesignPatterns.structural.Adapter;
//https://medium.com/@pramodayajayalath/adapter-design-pattern-3307ada690db
//Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
//The adapter pattern converts the interface of a class into another interface clients expect.
// Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.
public class Medium {
}

interface CommonPlayer {
    public void shoot();
    public void drive();
    public void loot();
}

interface CommonBot {
    public void smashWithHands();
    public void walk();
    public void findGun();

}

class Player implements CommonPlayer{

    @Override
    public void shoot() {
        System.out.println("use the gun to shoot!");
    }

    @Override
    public void drive() {
        System.out.println("drive forward!");
    }

    @Override
    public void loot() {
        System.out.println("loot as you can!");
    }
}

class Bot implements CommonBot{

    @Override
    public void smashWithHands() {
        System.out.println("smash with hands!");
    }

    @Override
    public void walk() {
        System.out.println("walk straight!");
    }

    @Override
    public void findGun() {
        System.out.println("get the first gun!");
    }
}

class PlayerBotAdaptor implements CommonPlayer {
    Bot bot;
    public PlayerBotAdaptor(Bot bot){
        this.bot = bot;
    }
    @Override
    public void shoot() {
        bot.smashWithHands();
    }

    @Override
    public void drive() {
        bot.walk();
    }

    @Override
    public void loot() {
        bot.findGun();
    }
}

class AdapterTest {
    public static void main(String[] args) {
        CommonPlayer player = new Player();
        Bot bot = new Bot();
        CommonPlayer playerbotAdaptor = new PlayerBotAdaptor(bot);
        System.out.println("-----------player info------");
        player.shoot();
        player.drive();
        player.loot();
        System.out.println("----------bot info---------");
        bot.smashWithHands();
        bot.walk();
        bot.findGun();
        System.out.println("------playerbot info-------");
        playerbotAdaptor.shoot();
        playerbotAdaptor.drive();
        playerbotAdaptor.loot();
    }
}