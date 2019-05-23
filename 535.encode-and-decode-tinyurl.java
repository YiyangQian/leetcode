/*
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (76.67%)
 * Total Accepted:    73.6K
 * Total Submissions: 96.1K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need
 * to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 */
public class Codec {

    // imagine 1000 billion urls to be stored, we set max length to 7, which offers 62 ^ 7 around 3500 billion urls
    // basically, we are mapping 10-based id into 62-based tinyUrl
    private int id = 0;
    final char[] l = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    // currently using a map functioning as database
    private Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //increment id for the new input url
        id++;
        StringBuilder sb = new StringBuilder();
        while (id != 0) {
            sb.insert(0, l[id % 62]);
            id = id / 62;
        }
        String encoded = sb.toString();
        map.put(encoded, longUrl);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
