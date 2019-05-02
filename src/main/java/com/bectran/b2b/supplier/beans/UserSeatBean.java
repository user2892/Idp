/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LOUIS IFEGUNI May 30, 2011 11:21:24 PM
 */
public class UserSeatBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String seatId;
    private Date lastUpdate;
    //
    private SeatBean mySeat;

    //
    public UserSeatBean() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public SeatBean getMySeat() {
        return mySeat;
    }

    public void setMySeat(SeatBean mySeat) {
        this.mySeat = mySeat;
    }
}
