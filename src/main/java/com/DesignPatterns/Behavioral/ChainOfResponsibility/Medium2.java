package com.DesignPatterns.Behavioral.ChainOfResponsibility;


public class Medium2 {
}

abstract class LeaveHandler2{
    public LeaveHandler2 superviser;

    public void setSupervisor(LeaveHandler2 superviser) {
        this.superviser = superviser;
    }

    abstract void applyleave(String days);
}

class TeamLead2 extends LeaveHandler2 {

    @Override
    void applyleave(String days) {
        if(days == "15"){
            System.out.println("approved leave by team lead!");
        } else{
            superviser.applyleave(days);
        }
    }
}

class Manager2 extends LeaveHandler2 {

    @Override
    void applyleave(String days) {
        if(days == "25"){
            System.out.println("approved leave by Manager!");
        } else{
            superviser.applyleave(days);
        }
    }
}

class HR extends LeaveHandler2 {

    @Override
    void applyleave(String days) {
        if(days == "30"){
            System.out.println("approved leave by HR!");
        } else{
            System.out.println("rejected leave by HR!");
        }
    }
}


class Main{
    public static void main(String[] args) {
        TeamLead2 teamLead = new TeamLead2();
        HR hr = new HR();
        Manager2 manager = new Manager2();
        teamLead.setSupervisor(manager);
        manager.setSupervisor(hr);

        teamLead.applyleave("15");
        teamLead.applyleave("25");
        teamLead.applyleave("30");
        teamLead.applyleave("12");
    }
}
