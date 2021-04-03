/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

// @lc code=start
import java.util.UUID;

public class Codec {
    HashMap<String, String> map = new HashMap();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String uniqueId = getUniqueId();
        //save the uniqueId
        map.put(uniqueId, longUrl);
        return "http://tinyurl.com/" + uniqueId;
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.indexOf(".com/");
		
		//last 6 character as unique id
        String uniqueId = shortUrl.substring(index + 5);
        return map.get(uniqueId);
    }
    
    private String getUniqueId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(6);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

