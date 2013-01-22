package commons.security;

import commons.security.digests.Digest;
import commons.security.digests.MD4Digest;

public class MD4 {
	
	private static final Digest digest = new MD4Digest();

	
    /**
     * MD4算法
     * @param String input
     * @return 32位十六进制数字字符串
     */
    public static String digest(String input){
    	  	
    	return new String(Hex.encode(digest.digest(input.getBytes())));
    	
    }
    
    /**
     * MD4算法
     * @param byte[] input
     * @return 32位十六进制数字数组
     */
    public static byte[] digest( byte[]  input)
    {  
        
        return Hex.encode(digest.digest(input));
    }


}
