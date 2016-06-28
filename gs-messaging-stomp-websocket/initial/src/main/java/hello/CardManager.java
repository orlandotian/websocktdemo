package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by tiansai on 16/6/27.
 */
public class CardManager {

    private List<String> mCards = new ArrayList<>();

    public void fresh() {
        mCards.clear();
        init();
    }

    private void init() {
        final Integer[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        List<Integer> allCards = new ArrayList<>();
        Collections.addAll(allCards, number);
        Collections.addAll(allCards, number);
        Collections.addAll(allCards, number);
        Collections.addAll(allCards, number);

        while (allCards.size() > 0) {
            int index = new Random().nextInt(allCards.size());
            int cardNum = allCards.remove(index);
            String card = "";
            if(cardNum == 1) {
                card = "A";
            } else if (cardNum == 11) {
                card = "J";
            } else if (cardNum == 12) {
                card = "Q";
            } else if (cardNum == 13) {
                card = "K";
            } else {
                card = "" + cardNum;
            }
            mCards.add(card);
        }

    }

    public String getNext() {
        return mCards.remove(mCards.size() - 1);
    }

    public int getCount() {
        return mCards.size();
    }
}
