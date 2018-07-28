import java.util.HashMap;

public class TinyURL {
    HashMap<String, String> map = new HashMap<>();
    final int len = 6;
    String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; //total 62;
    int id = 0;
    public String encode(String longUrl) {
        StringBuilder shortUrl = new StringBuilder();
        int i = id++;
        for(int j = 0; j<len; ++j){
            shortUrl.append(strs.charAt(i%62));
            i = i/62;
        }
        map.put(shortUrl.toString(), longUrl);
        return shortUrl.toString();
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
