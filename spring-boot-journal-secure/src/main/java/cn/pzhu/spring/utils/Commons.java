package cn.pzhu.spring.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 主题公共函数
 * <p>
 * Created by 13 on 2018/2/21.
 */
@Component
public final class Commons {

    private static String THEME = "themes/default";

    /**
     * 截取字符串
     */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

    /**
     * 显示文章图标
     */
    public static String show_icon(int cid) {
        return ICONS[cid % ICONS.length];
    }

    /**
     * 返回github头像地址
     *
     * @param email
     * @return
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (org.apache.commons.lang3.StringUtils.isBlank(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    private static String MD5encode(String source) {
        if (org.apache.commons.lang3.StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        assert messageDigest != null;
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
