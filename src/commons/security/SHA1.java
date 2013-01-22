package commons.security;

import commons.security.digests.Digest;
import commons.security.digests.SHA1Digest;

public class SHA1 {
	
	private static final Digest digest = new SHA1Digest();

	
    /**
     * SHA1算法
     * @param String input
     * @return 40位十六进制数字字符串
     */
    public static String digest(String input){
    	  	
    	return new String(Hex.encode(digest.digest(input.getBytes())));
    	
    }
    
    /**
     * SHA1算法
     * @param byte[] input
     * @return 40位十六进制数字数组
     */
    public static byte[] digest( byte[]  input)
    {  
        
        return Hex.encode(digest.digest(input));
    }

}
