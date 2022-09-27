package com.DesignPatterns.structural.Decorator;
//Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects
// inside special wrapper objects that contain the behaviors.
// Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.
//https://medium.com/geekculture/the-decorator-design-pattern-723359027a09
public class Medium {
}

interface Developer{
    public String makeJob();
}

class JavaDeveloper implements Developer{

    @Override
    public String makeJob() {
        return "Write Java Code!";
    }
}

class DeveloperDecorator implements Developer{
    Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}

class SeniorDeveloper extends DeveloperDecorator{

    public SeniorDeveloper(Developer developer) {
        super(developer);
    }

    public String makeCodeReview(){
        return "Make code review!";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}

class TeamLead extends DeveloperDecorator{

    public TeamLead(Developer developer) {
        super(developer);
    }

    String sendWeeklyReport(){
        return "Sending weekly report!";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeeklyReport();
    }
}

class DecoratorTester{
    public static void main(String[] args) {
        Developer developer = new JavaDeveloper();
        System.out.println(developer.makeJob());

        Developer developer1 = new SeniorDeveloper(new JavaDeveloper());
        System.out.println(developer1.makeJob());

        Developer developer2 = new TeamLead(new SeniorDeveloper(new JavaDeveloper()));
        System.out.println(developer2.makeJob());
    }
}
