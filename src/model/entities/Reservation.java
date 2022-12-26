package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomnumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomnumber, Date checkin, Date checkout) {
        this.roomnumber = roomnumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout){

        Date now  = new Date();
        if (checkin.before(now) || checkout.before(now)){
            return "Reservation dates for updates must be future date";
        }
        if (!checkout.after(checkin)){
            return "Check-out date must be after check-in date";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    public Integer getRoomnumber() {
        return roomnumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomnumber = roomnumber;
    }

    @Override
    public String toString() {
        return "Room "
                + roomnumber
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }
}
