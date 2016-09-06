package hello.classsystem.util;

import java.util.Random;

/**
 * Created by tiansai on 16/5/17.
 */
public class FakeNameDB {
    public static String NAME = "赵 钱 孙 李 周 吴 郑 王\n" +
            "冯 陈 楮 卫 蒋 沈 韩 杨\n" +
            "朱 秦 尤 许 何 吕 施 张\n" +
            "孔 曹 严 华 金 魏 陶 姜\n" +
            "戚 谢 邹 喻 柏 水 窦 章\n" +
            "云 苏 潘 葛 奚 范 彭 郎\n" +
            "鲁 韦 昌 马 苗 凤 花 方\n" +
            "俞 任 袁 柳 酆 鲍 史 唐\n" +
            "费 廉 岑 薛 雷 贺 倪 汤\n" +
            "滕 殷 罗 毕 郝 邬 安 常\n" +
            "乐 于 时 傅 皮 卞 齐 康\n" +
            "伍 余 元 卜 顾 孟 平 黄\n" +
            "和 穆 萧 尹 姚 邵 湛 汪\n" +
            "祁 毛 禹 狄 米 贝 明 臧\n" +
            "计 伏 成 戴 谈 宋 茅 庞\n" +
            "熊 纪 舒 屈 项 祝 董 梁\n" +
            "杜 阮 蓝 闽 席 季 麻 强\n" +
            "贾 路 娄 危 江 童 颜 郭\n" +
            "梅 盛 林 刁 锺 徐 丘 骆\n" +
            "高 夏 蔡 田 樊 胡 凌 霍\n" +
            "虞 万 支 柯 昝 管 卢 莫\n" +
            "经 房 裘 缪 干 解 应 宗\n" +
            "丁 宣 贲 邓 郁 单 杭 洪\n" +
            "包 诸 左 石 崔 吉 钮 龚\n" +
            "程 嵇 邢 滑 裴 陆 荣 翁\n" +
            "荀 羊 於 惠 甄 麹 家 封\n" +
            "芮 羿 储 靳 汲 邴 糜 松\n" +
            "井 段 富 巫 乌 焦 巴 弓\n" +
            "牧 隗 山 谷 车 侯 宓 蓬\n" +
            "全 郗 班 仰 秋 仲 伊 宫\n" +
            "宁 仇 栾 暴 甘 斜 厉 戎\n" +
            "祖 武 符 刘 景 詹 束 龙\n" +
            "叶 幸 司 韶 郜 黎 蓟 薄\n" +
            "印 宿 白 怀 蒲 邰 从 鄂\n" +
            "索 咸 籍 赖 卓 蔺 屠 蒙\n" +
            "池 乔 阴 郁 胥 能 苍 双\n" +
            "闻 莘 党 翟 谭 贡 劳 逄\n" +
            "姬 申 扶 堵 冉 宰 郦 雍\n" +
            "郤 璩 桑 桂 濮 牛 寿 通\n" +
            "边 扈 燕 冀 郏 浦 尚 农\n" +
            "温 别 庄 晏 柴 瞿 阎 充\n" +
            "慕 连 茹 习 宦 艾 鱼 容\n" +
            "向 古 易 慎 戈 廖 庾 终\n" +
            "暨 居 衡 步 都 耿 满 弘\n" +
            "匡 国 文 寇 广 禄 阙 东\n" +
            "欧 殳 沃 利 蔚 越 夔 隆\n" +
            "师 巩 厍 聂 晁 勾 敖 融\n" +
            "冷 訾 辛 阚 那 简 饶 空\n" +
            "曾 毋 沙 乜 养 鞠 须 丰\n" +
            "巢 关 蒯 相 查 后 荆 红\n" +
            "游 竺 权 逑 盖 益 桓 公\n" +
            "万俟 司马 上官 欧阳\n" +
            "夏侯 诸葛 闻人 东方\n" +
            "赫连 皇甫 尉迟 公羊\n" +
            "澹台 公冶 宗政 濮阳\n" +
            "淳于 单于 太叔 申屠\n" +
            "公孙 仲孙 轩辕 令狐\n" +
            "锺离 宇文 长孙 慕容\n" +
            "鲜于 闾丘 司徒 司空\n" +
            "丌官 司寇 仉 督 子车\n" +
            "颛孙 端木 巫马 公西\n" +
            "漆雕 乐正 壤驷 公良\n" +
            "拓拔 夹谷 宰父 谷梁\n" +
            "晋 楚 阎 法 汝 鄢 涂 钦\n" +
            "段干 百里 东郭 南门\n" +
            "呼延 归 海 羊舌 微生\n" +
            "岳 帅 缑 亢 况 后 有 琴\n" +
            "梁丘 左丘 东门 西门\n" +
            "商 牟 佘 佴 伯 赏 南宫\n" +
            "墨 哈 谯 笪 年 爱 阳 佟";

    private String[] names;
    public FakeNameDB() {
        NAME = NAME.replace("\n", " ");
        names = NAME.split(" ");
    }

    public String radomName() {
        if(names == null) return "";
        Random random = new Random();
        int i = random.nextInt(names.length);
        StringBuilder sb = new StringBuilder();
        sb.append(names[i]);
        sb.append(names[random.nextInt(names.length)]);
        int j = random.nextInt(3);
        if(j == 2) {
            sb.append(names[random.nextInt(names.length)]);
        }
        return sb.toString();
    }
}
