package com.DesignPatterns.Builder;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;

//a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
//https://medium.com/@sahoosunilkumar/understanding-builder-design-pattern-6c3627cee281
public class Medium {
}

final class Party {
    private final String place;
    private final String name;
    private final String starter;
    private final String maincourse;
    private final String desert;
    private final String danceType;


    private Party(PartyBuilder builder){
        this.place = builder.place;
        this.name = builder.name;
        this.maincourse = builder.maincourse;
        this.starter = builder.starter;
        this.desert = builder.desert;
        this.danceType = builder.danceType;
    }


//    public Party(String place, String name, String starter, String maincourse, String desert, String danceType) {
//        this.place = place;
//        this.name = name;
//        this.starter = starter;
//        this.maincourse = maincourse;
//        this.desert = desert;
//        this.danceType = danceType;
//    }


    @Override
    public String toString() {
        return "Party{" +
                "place='" + place + '\'' +
                ", name='" + name + '\'' +
                ", starter='" + starter + '\'' +
                ", maincourse='" + maincourse + '\'' +
                ", desert='" + desert + '\'' +
                ", danceType='" + danceType + '\'' +
                '}';
    }

    public static class PartyBuilder {
        private final String place;
        private final String name;
        private String starter;
        private String maincourse;
        private String desert;
        private String danceType;

        //Compulsory fields
        public PartyBuilder(String place, String name) {
            if(place == null || name == null){
                throw new IllegalArgumentException("place and name cant be null");
            }
            this.place = place;
            this.name = name;
        }

        public PartyBuilder withStarter(String starter) {
            this.starter = starter;
            return this;
        }

        public PartyBuilder withMainCourse(String mainCourse){
            this.maincourse = mainCourse;
            return this;
        }

        public PartyBuilder withDesert(String desert){
            this.desert = desert;
            return this;
        }

        public PartyBuilder withDanceType(String danceType){
            this.danceType = danceType;
            return this;
        }

        public Party build(){
            return new Party(this);
        }
    }
}

//We need Restriction on item updation after Object Creation
class BuilderTester {
    public static void main(String[] args) {
//        Party party1 = new Party("hyderabad", "CCD", null, null, null, null);
//        System.out.println("party details: " + party1);
        Party party2 = new Party.PartyBuilder("Bangalore", "Pizzahut").build();
        System.out.println("party details: " + party2);
        party2 = new Party.PartyBuilder("Bangalore", "ShahGouse")
                .withStarter("potato chips")
                .withMainCourse("Biryani").withDesert("icecream").build();
        System.out.println("party2 details: " +party2);
    }
}



