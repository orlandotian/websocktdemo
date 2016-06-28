package hello;

import java.util.List;

/**
 * Created by tiansai on 16/6/28.
 */
public class RoomStatus {
    int count;
    List<String> user;
    List<String> card;
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

    public List<String> getCard() {
        return card;
    }

    public void setCard(List<String> card) {
        this.card = card;
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
