package year2016.day4;

public class Room {
    private String roomID;
    private String encryptedName;
    private String checkSum;


    public Room (String roomID, String encryptedName, String checkSum) {
        this.roomID = roomID;
        this.encryptedName = encryptedName;
        this.checkSum = checkSum;

    }
    public String getRoomID () {
        return roomID ;
    }

    public String getEncryptedName () {
        return encryptedName ;
    }

    public String getCheckSum() {
        return checkSum ;
    }


}
