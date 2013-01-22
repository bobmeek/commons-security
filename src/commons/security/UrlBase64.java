package commons.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import commons.security.encoders.Encoder;
import commons.security.encoders.UrlBase64Encoder;

/**
 * 
 * Base64算法最初用于电子邮件系统，后经演变成为显式传递Url参数的一种编码算法，
 * 通常称为“Url Base64”。
 * <p>
 * UrlBase64是Base64算法的变体，将字符映射表中用做补位的“=”换成“.”，
 * 并用“-”和“_”分别替代“+”和“/”，使得Base64编码符合Url参数规则，
 * 可以将二进制的数据以Get方式进行传输
 * </p>
 * 
 */
public class UrlBase64
{
    private static final Encoder encoder = new UrlBase64Encoder();
    
    /**
     * 返回Url Base64编码
     * Encode the input data producing a URL safe base 64 encoded byte array.
     *
     * @return a byte array containing the URL safe base 64 encoded data.
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
            throw new RuntimeException("exception encoding URL safe base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }

    /**
     * 向输出流中写入Url Base64编码
     * Encode the byte data writing it to the given output stream.
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
     * 返回Url Base64解码，空格忽略
     * Decode the URL safe base 64 encoded input data - white space will be ignored.
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
            throw new RuntimeException("exception decoding URL safe base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }
    
    /**
     * 向输出流中写入Url Base64解码，空格忽略
     * decode the URL safe base 64 encoded byte data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    public static int decode(
        byte[]                data,
        OutputStream    out)
        throws IOException
    {
        return encoder.decode(data, 0, data.length, out);
    }
    
    /**
     * 返回Url Base64解码，空格忽略
     * decode the URL safe base 64 encoded String data - whitespace will be ignored.
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
            throw new RuntimeException("exception decoding URL safe base64 string: " + e);
        }
        
        return bOut.toByteArray();
    }
    
    /**
     * 向输出流中写入Url Base64解码，空格忽略
     * Decode the URL safe base 64 encoded String data writing it to the given output stream,
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
