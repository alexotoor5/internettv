package com.internettv.simple.api;

public class LenzApi {

    public static String auto(String code) {
        return "https://lenz.ir/live/" + code + "/index.m3u8";
    }

    public static String hd(String code) {
        return "https://lenz.ir/live/" + code + "/720.m3u8";
    }
}
