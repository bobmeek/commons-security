package commons.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import commons.security.encoders.Base64Encoder;
import commons.security.encoders.Encoder;
/**
 * Base64编码/解码转换
 * @author yuanyan.cao@gmail.com
 *
 */
public class Base64
{
    private static final Encoder encoder = new Base64Encoder();
    
    /**
     * 返回Base64编码结果
     * encode the input data producing a base 64 encoded byte array.
     * 
     * @return a byte array containing the base 64 encoded data.
     */
    public static byte[] encode(
        byte[]    data)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        
        try
        {
            encoder.encode(data, 0, data.length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception encoding base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }

    /**
     * 向输出流中写入Base64编码结果
     * Encode the byte data to base 64 writing it to the given output stream.
     *
     * @return the number of bytes produced.
     */
    public static int encode(
        byte[]                data,
        OutputStream    out)
        throws IOException
    {
        return encoder.encode(data, 0, data.length, out);
    }
    
    /**
     * 向输出流中写入Base64编码结果
     * Encode the byte data to base 64 writing it to the given output stream.
     *
     * @return the number of bytes produced.
     */
    public static int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out)
        throws IOException
    {
        return encoder.encode(data, off, length, out);
    }
    
    /**
     * 返回Base64解码结果
     * decode the base 64 encoded input data. It is assumed the input data is valid.
     *
     * @return a byte array representing the decoded data.
     */
    public static byte[] decode(
        byte[]    data)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        
        try
        {
            encoder.decode(data, 0, data.length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }
    
    /**
     * 返回Base64解码结果，空格将被忽略
     * decode the base 64 encoded String data - whitespace will be ignored.
     *
     * @return a byte array representing the decoded data.
     */
    public static byte[] decode(
        String    data)
    {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        
        try
        {
            encoder.decode(data, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }
    
    /**
     * 向输出流中写入Base64解码结果，空格将被忽略
     * decode the base 64 encoded String data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    public static int decode(
        String                data,
        OutputStream    out)
        throws IOException
    {
        return encoder.decode(data, out);
    }
}
