package com.DesignPatterns.Behavioral.ChainOfResponsibility;

//Chain of Responsibility is a behavioral design pattern that lets you
// pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process
// the request or to pass it to the next handler in the chain.
//Chain of responsibility pattern is a behavioral design pattern that we use to achieve
// loose coupling in our software design, where a request from the client is passed to a chain of objects to process them
//https://medium.com/geekculture/understanding-the-chain-of-responsibility-pattern-d729ef84621c
public class Medium {
}

class Leave{
    private int noOfDays;
    private int empTier;
    private ReasonType reasonType;

    public Leave(int noOfDays, int empTier, ReasonType reasonType) {
        this.noOfDays = noOfDays;
        this.empTier = empTier;
        this.reasonType = reasonType;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public int getEmpTier() {
        return empTier;
    }

    public ReasonType getReasonType() {
        return reasonType;
    }
}

abstract class LeaveHandler{
    protected LeaveHandler superVisor;

    public void setSuperVisor(LeaveHandler superVisor) {
        this.superVisor = superVisor;
    }

    abstract String applyLeave(Leave leave);
}

class TeamLeader extends LeaveHandler{

    @Override
    String applyLeave(Leave leave) {
        if(leave.getNoOfDays() <= 7){
            return "your leave days has been approved TeamLeader!";
        } else {
            return superVisor.applyLeave(leave);
        }
    }
}

class ProjectLeader extends LeaveHandler{

    @Override
    String applyLeave(Leave leave) {
        if(leave.getNoOfDays()<=14){
            return "your leave days has been approved by ProjectLeader!";
        } else {
            return superVisor.applyLeave(leave);
        }
    }
}

class Hr extends LeaveHandler{

    @Override
    String applyLeave(Leave leave) {
        if(leave.getNoOfDays() <= 21)
            return "your leave days has been approved by Hr!";
        else
            return superVisor.applyLeave(leave);
    }
}

class Manager extends LeaveHandler{

    @Override
    String applyLeave(Leave leave) {
        if(leave.getNoOfDays() > 21 && leave.getReasonType().equals(ReasonType.CRITICAL)){
            return "your leave days has been approved by manager!";
        } else {
            return "your leave days has been REJECTED by manager!";
        }
    }
}

class LeaveRequestTester{
    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        ProjectLeader projectLeader = new ProjectLeader();
        Hr hr = new Hr();
        Manager manager = new Manager();

        teamLeader.setSuperVisor(projectLeader);
        projectLeader.setSuperVisor(hr);
        hr.setSuperVisor(manager);

        Leave leave1 = new Leave(5, 4, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave1));

        Leave leave2 = new Leave(10, 4, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave2));

        Leave leave3 = new Leave(20, 4, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave3));

        Leave leave4 = new Leave(25, 4, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave4));

        Leave leave5 = new Leave(25, 4, ReasonType.CRITICAL);
        System.out.println(teamLeader.applyLeave(leave5));
    }
}

enum ReasonType{
    CRITICAL, REGULAR, SPECIAL
}
