package com.DesignPatterns;

import com.SolidPrinciples.Test;

interface Prototype{
    public Prototype clone();
}

abstract class LeaveHandler{
    public LeaveHandler superviser;

    public void setSupervisor(LeaveHandler superviser) {
        this.superviser = superviser;
    }

    abstract void applyleave(String days);
}

class TeamLead extends LeaveHandler{

    @Override
    void applyleave(String days) {
        if(days == "15"){
            System.out.println("approved leave by team lead!");
        } else{
            superviser.applyleave(days);
        }
    }
}

class Manager extends LeaveHandler{

    @Override
    void applyleave(String days) {
        if(days == "25"){
            System.out.println("approved leave by Manager!");
        } else{
            superviser.applyleave(days);
        }
    }
}

class HR extends LeaveHandler{

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
        TeamLead teamLead = new TeamLead();
        HR hr = new HR();
        Manager manager = new Manager();
        teamLead.setSupervisor(manager);
        manager.setSupervisor(hr);

        teamLead.applyleave("15");
        teamLead.applyleave("25");
        teamLead.applyleave("30");
        teamLead.applyleave("12");
    }
}