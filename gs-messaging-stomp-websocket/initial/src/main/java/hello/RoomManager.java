package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tiansai on 16/6/27.
 */
public class RoomManager {

    private static RoomManager roomManager;

    public static RoomManager getInstance() {
        if (roomManager == null) {
            roomManager = new RoomManager();
        }
        return roomManager;
    }

    private RoomManager() {

    }

    private Map<Integer, Room> rooms = new HashMap<>();

    public int getUserCount(int id) {
        return getRoom(id).size();
    }

    public boolean isUserRoot(int id, String name) {
        return getRoom(id).isRoot(name);
    }

    public boolean addUser(int id, String name) {
        return getRoom(id).addUser(name);
    }

    public Room getRoom(int id) {
        if (rooms.get(id) == null) {
            Room room = new Room();
            rooms.put(id, room);
        }
        return rooms.get(id);
    }

    public class Room {
        private List<User> users = new ArrayList<>();
        private CardManager cardManager = new CardManager();
        private int index = 0;

        public Room() {
            cardManager.fresh();
        }

        public int size() {
            return users.size();
        }

        public boolean isRoot(String name) {
            return name.equals(users.get(0).name);
        }

        public boolean addUser(String name) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).name.equals(name)) {
                    return false;
                }
            }
            users.add(new User(name));
            return true;
        }

        public boolean deleteUser(String name) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).name.equals(name)) {
                    users.remove(i);
                    return true;
                }
            }
            return false;
        }

        public User getUser(String name) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).name.equals(name)) {
                    return users.get(i);
                }
            }

            return null;
        }

        public List<String> getUserList() {
            List<String> usernames = new ArrayList<>();
            for(int i = 0; i < users.size(); i++) {
                usernames.add(users.get(i).name);
            }
            return usernames;
        }

        public void fresh() {
            cardManager.fresh();
        }

        public String getCard(String name) {
            if (users.get(index).name.equals(name)) {
                index++;
                if (index >= users.size()) {
                    index = 0;
                }
                return cardManager.getNext();
            }
            return null;
        }

        public int getCardNum() {
            return cardManager.getCount();
        }

        public String getIndexUser() {
            return users.get(index).name;
        }
    }

    public class User {
        String name;
        List<String> card;

        User(String name) {
            this.name = name;
        }
    }
}
