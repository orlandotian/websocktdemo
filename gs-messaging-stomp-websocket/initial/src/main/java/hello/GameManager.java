package hello;

import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * Created by tiansai on 16/6/28.
 */
public class GameManager {

    public static String checkSpeak(int id, String name, String content) {
        if("进入房间".equals(content)) {
            boolean result = RoomManager.getInstance().addUser(id, name);
            if(result) {
                return null;
            } else {
                return "名字重复,请重新连接";
            }
        } else if("退出房间".equals(content)) {
            RoomManager.getInstance().getRoom(id).deleteUser(name);
            return null;
        } else if(!StringUtils.isEmpty(content) && content.startsWith("$") || RoomManager.getInstance().isUserRoot(id, name)) {
            if(content.contains("踢出")) {
                content = content.replace("$踢出", "");
                boolean result = RoomManager.getInstance().getRoom(id).deleteUser(content);
                if(result) {
                    return "房主已将" + content + "踢出游戏";
                } else {
                    return "踢人失败";
                }
            } else if(content.contains("洗牌")) {
                content = content.replace("$洗牌", "");
                if(content.length()==0) {
                    RoomManager.getInstance().getRoom(id).fresh();
                    return "房主命令游戏洗牌";
                }
            }
        }
        return null;
    }

    public static String getCard(int id, String username) {
        if(RoomManager.getInstance().getRoom(id).getCardNum() == 0) {
            return "没有牌了, 请房主洗牌";
        }
        String result = RoomManager.getInstance().getRoom(id).getCard(username);
        if(result == null) {
            return "现在需要" + RoomManager.getInstance().getRoom(id).getIndexUser() + "抓牌";
        } else {
            return username + "抓到" + result;
        }
    }

    public static RoomStatus getStatus(int id) {
        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setCount(RoomManager.getInstance().getUserCount(id));
        roomStatus.setUser(RoomManager.getInstance().getRoom(id).getUserList());
        roomStatus.setCardNum(RoomManager.getInstance().getRoom(id).getCardNum());
        return roomStatus;
    }
}
