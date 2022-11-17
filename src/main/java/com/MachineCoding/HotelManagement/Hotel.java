package com.MachineCoding.HotelManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    Integer id;
    String name;
    Location location;
    List<Room> roomList;
}

class Location{
    int pin;
    String street;
    String area;
    String city;
    String country;
}

class Room{
    Integer roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs;
}

enum RoomStyle{
    DELUXE,
    STANDARD,
    FAMILY_SUITE;
}

enum RoomStatus{
    AVAILABLE, RESERVED, NOT_AVAILABLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

class RoomKey{
    Integer keyId;
    String barCode;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room){};
}

class HouseKeepingLog{
    String description;
    Date startDate;
    int duration;
    HouseKeeper houseKeeper;
    public void assignRoom(Room room){};
}

abstract class Person{
    String name;
    Account accountDetails;
    String phone;
}

class Account{
    String username;
    String password;
    AccountStatus accountStatus;
}

enum AccountStatus{
    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person{
    public List<Room> getRoomServiced(Date date){
        //
        return new ArrayList<>();
    }
}

class Guest extends Person{
    Search search;
    Booking booking;
    public List<RoomBooking> getAllRoomBookings(){return new ArrayList<>();}
}

class Receptionist extends Person{
    Search search;
    Booking booking;
    public void checkInGuest(Guest guest, RoomBooking roomBooking){};
    public void checkOutGuest(Guest guest, RoomBooking roomBooking){};
}

class Admin extends Person{
    public void addRoom(Room roomDetails){};
    public void deleteRoom(String roomId){};
    public void editRoom(Room roomDetails){};
}

class Search{
    public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration){return new ArrayList<>();}
}

class Booking{
    public RoomBooking createBooking(Guest guestInfo){return new RoomBooking();}
    public RoomBooking cancelBooking(int bookingId){return new RoomBooking();}
}

class RoomBooking{
    String bookingId;
    String startDate;
    String durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guests;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharge;
}

class BookingStatus{

}

interface BaseRoomCharge{
    Double getCost();
    void setCost(Double cost);
}
class RoomCharge implements BaseRoomCharge{
    double cost;
    @Override
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost){
        this.cost = cost;
    }
}

class RoomServiceCharge implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    @Override
    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }
}

class InRoomPurchaseCharge implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    @Override
    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + this.cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }
}
