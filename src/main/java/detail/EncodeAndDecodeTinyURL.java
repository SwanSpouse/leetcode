package detail;

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {

    public HashMap<String, String> shortUrl2LongUrl = new HashMap<>();
    public int count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] fields = longUrl.split("//");
        String body = fields[1];

        String shortUrl = count + "";
        shortUrl2LongUrl.put(shortUrl, body);
        count++;
        return fields[0] + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] fields = shortUrl.split("//");
        String body = fields[1];
        return fields[0] + shortUrl2LongUrl.get(body);
    }
}
