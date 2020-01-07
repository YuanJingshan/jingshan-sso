package com.up.jingshan.client.auth.common.encrypt;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Arrays;
import java.util.UUID;

public class SM3Util {
    private static final String ENCODING = "utf-8";
    static{
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String encrypt(String paramStr){
        String resultHexString = "";
        try{
            byte[] srcData = new byte[0];
            srcData = paramStr.getBytes(ENCODING);
            byte[] resultHash = hash(srcData);
            resultHexString = ByteUtils.toHexString(resultHash);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return resultHexString;
    }

    public static byte[] hash(byte[] srcData){
        SM3Digest sm3Digest = new SM3Digest();
        sm3Digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[sm3Digest.getDigestSize()];
        sm3Digest.doFinal(hash, 0);
        return hash;
    }

    public static byte[] hmac(byte[] key, byte[] srcData){
        KeyParameter keyParameter = new KeyParameter(key);
        SM3Digest sm3Digest = new SM3Digest();
        HMac  hMac = new HMac(sm3Digest);
        hMac.init(keyParameter);
        hMac.update(srcData, 0, srcData.length);
        byte[] result = new byte[hMac.getMacSize()];
        hMac.doFinal(result, 0);
        return result;
    }

    public static boolean verify(String srcStr, String sm3HexString){
        boolean flag = false;
        try{
            byte[] srcData = srcStr.getBytes(ENCODING);
            byte[] sm3Hash = ByteUtils.fromHexString(sm3HexString);
            byte[] newHash = hash(srcData);
            if(Arrays.equals(newHash, sm3Hash)){
                flag = true;
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        String pwd= "123456";
        String encrypt = pwd+uuid;
        String enpwd = SM3Util.encrypt(encrypt);
        System.out.println(enpwd);

        boolean verify = SM3Util.verify(encrypt, enpwd);
        System.out.println(verify);

    }
}
