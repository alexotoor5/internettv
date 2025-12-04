package com.internettv.simple.api;

import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SepehrApi {

    private static String get(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestProperty("User-Agent", "Mozilla/5.0");
            Scanner s = new Scanner(c.getInputStream()).useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String getAuto(String code) {
        return extract(code, "auto");
    }

    public static String getSD(String code) {
        return extract(code, "sd");
    }

    public static String getHD(String code) {
        return extract(code, "hd");
    }

    private static String extract(String code, String q) {
        try {
            String json = get("https://live.irib.ir/api/stream/" + code);
            JSONObject o = new JSONObject(json)
                    .getJSONObject("data")
                    .getJSONObject("urls");
            return o.getString(q);
        } catch (Exception ex) {
            return "";
        }
    }
}
