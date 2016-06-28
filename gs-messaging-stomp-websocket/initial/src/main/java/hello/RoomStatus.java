package hello;

import java.util.List;

/**
 * Created by tiansai on 16/6/28.
 */
public class RoomStatus {
    int count;
    List<String> user;
    int cardNum;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getUser() {
        return user;
    }

    public void setUser(List<String> user) {
        this.user = user;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
}
