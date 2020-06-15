package com.example.coachnote;

public class ClubMember {

    private int clubMemberID;
    private String clubMemberName;
    private String clubMemberPassStartDate;
    private String clubMemberPassEndDate;
    private String clubMemberConnection; // The member who bring him/her to the club

    public ClubMember()
    {

    }

    public ClubMember(int clubMemberID, String clubMemberName, String clubMemberPassStartDate, String clubMemberPassEndDate, String clubMemberConnection)
    {
        this.clubMemberID = clubMemberID;
        this.clubMemberName = clubMemberName;
        this.clubMemberPassStartDate = clubMemberPassStartDate;
        this.clubMemberPassEndDate = clubMemberPassEndDate;
        this.clubMemberConnection = clubMemberConnection;
    }

    public int getClubMemberID() {
        return clubMemberID;
    }

    public String getClubMemberName() {
        return clubMemberName;
    }

    public String getClubMemberPassStartDate() {
        return clubMemberPassStartDate;
    }

    public String getClubMemberPassEndDate() {
        return clubMemberPassEndDate;
    }

    public String getClubMemberConnection() {
        return clubMemberConnection;
    }

    public void setClubMemberID(int clubMemberID) {
        this.clubMemberID = clubMemberID;
    }

    public void setClubMemberName(String clubMemberName) {
        this.clubMemberName = clubMemberName;
    }

    public void setClubMemberPassStartDate(String clubMemberPassStartDate) {
        this.clubMemberPassStartDate = clubMemberPassStartDate;
    }

    public void setClubMemberPassEndDate(String clubMemberPassEndDate) {
        this.clubMemberPassEndDate = clubMemberPassEndDate;
    }

    public void setClubMemberConnection(String clubMemberConnection) {
        this.clubMemberConnection = clubMemberConnection;
    }
}
