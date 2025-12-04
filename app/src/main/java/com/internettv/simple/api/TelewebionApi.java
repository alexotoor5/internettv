package com.internettv.simple.api;

public class TelewebionApi {

    public static String auto(String code) {
        return "https://ott-cdn.telewebion.com/live/" + code + "/index.m3u8";
    }

    public static String sd(String code) {
        return "https://ott-cdn.telewebion.com/live/" + code + "/360.m3u8";
    }

    public static String hd(String code) {
        return "https://ott-cdn.telewebion.com/live/" + code + "/720.m3u8";
    }
}
