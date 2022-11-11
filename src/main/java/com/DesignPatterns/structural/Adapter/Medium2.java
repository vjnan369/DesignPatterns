package com.DesignPatterns.structural.Adapter;

//Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
//The adapter pattern converts the interface of a class into another interface clients expect.
// Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.
//https://ssaurel.medium.com/implement-the-adapter-design-pattern-in-java-f9adb6a8828f
public class Medium2 {

}

interface MediaPlayer{
    public void play();
}

class Mp3 implements  MediaPlayer{

    @Override
    public void play() {
        System.out.println("play the mp3 with media player");
    }
}

interface MediaPackage{
    public void playFile();
}

class Mp4 implements MediaPackage{

    @Override
    public void playFile() {
        System.out.println("play mp4 with media package!");
    }
}

class VLC implements MediaPackage{

    @Override
    public void playFile() {
        System.out.println("play mp4 with media package!");
    }
}

class PackageAdapter implements MediaPlayer{
    MediaPackage mediaPackage;

    public PackageAdapter(MediaPackage mediaPackage) {
        this.mediaPackage = mediaPackage;
    }

    @Override
    public void play() {
        mediaPackage.playFile();
    }
}

class Tester{
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new Mp3();
        mediaPlayer.play();

        MediaPlayer mediaPlayer2 = new PackageAdapter(new Mp4());
        mediaPlayer.play();

    }
}