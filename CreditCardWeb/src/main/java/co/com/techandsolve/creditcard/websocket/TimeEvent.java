package co.com.techandsolve.creditcard.websocket;


import java.util.Date;


public class TimeEvent {
    
    private Date timestamp;

    public TimeEvent() {
        timestamp = new Date();
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }
    
    
    
}
