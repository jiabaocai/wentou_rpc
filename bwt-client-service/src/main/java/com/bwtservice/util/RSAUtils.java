package com.bwtservice.util;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtils {
    /** *//**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /** *//**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /** *//**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /** *//**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /** *//**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** *//**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /** *//**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /** *//**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     *
     * @param data 已加密数据
     * @param privateKey 私钥(BASE64编码)
     *
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64Utils.encode(signature.sign());
    }

    /** *//**
     * <p>
     * 校验数字签名
     * </p>
     *
     * @param data 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign 数字签名
     *
     * @return
     * @throws Exception
     *
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64Utils.decode(sign));
    }

    /** *//**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
            throws Exception {
        try {
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return decryptedData;
        } catch (NoSuchAlgorithmException e) {
            return "无此解密算法".getBytes();
//            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            return "解密私钥非法,请检查".getBytes();
//            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            return "密文长度非法".getBytes();
//            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            return "密文数据已损坏".getBytes();
//            throw new Exception("密文数据已损坏");
        }

    }

    /** *//**
     * <p>
     * 公钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
            throws Exception {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** *//**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)
            throws Exception {
        try {
            byte[] keyBytes = Base64Utils.decode(publicKey);
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicK = keyFactory.generatePublic(x509KeySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicK);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return encryptedData;
        } catch (NoSuchAlgorithmException e) {
            return "无此加密算法".getBytes();
//            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
//            throw new Exception("加密公钥非法,请检查");
            return "加密公钥非法".getBytes();
        } catch (IllegalBlockSizeException e) {
//            throw new Exception("明文长度非法");
            return "明文长度非法".getBytes();
        } catch (BadPaddingException e) {
            return "明文数据已损坏".getBytes();
//            throw new Exception("明文数据已损坏");
        }
    }

    /** *//**
     * <p>
     * 私钥加密
     * </p>
     *
     * @param data 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
            throws Exception {
        try {
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateK);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return encryptedData;
        } catch (NoSuchAlgorithmException e) {
            return "无此加密算法".getBytes();
//            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            return "加密私钥非法,请检查".getBytes();
//            throw new Exception("加密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            return "明文长度非法".getBytes();
//            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            return "明文数据已损坏".getBytes();
//            throw new Exception("明文数据已损坏");
        }

    }

    /** *//**
     * <p>
     * 获取私钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64Utils.encode(key.getEncoded());
    }

    /** *//**
     * <p>
     * 获取公钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return Base64Utils.encode(key.getEncoded());
    }

    public static void main(String[] args) throws Exception {
//         String publicKey;
//         String privateKey;
//        System.out.println("aaaa:"+Base64Utils.decode("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAILuIw+TGA317LGo biG2WnisQHya98CK3cVyZPUZ7cGKb6KXMzfmdtJ6lVFapMmhrj1VlRAZIuwP7O7A 6hhHxGslu7GYsgsGAtRP6hVAl8tNDRLCW9RagPAC2+NV/FSpjv1XYCYI3ZZnK4XY qqxZan9+rrSneyRAGX9JoHwu3oZzAgMBAAECgYAiLrXsnQSMsIXpJAYMuyUHmEEF xxejpx2bLPB6pRhTjSb0FfGDSKIA9YwCP14CXjm1PaC7ITTi2I2ND8SOLj5zMDHB oQ6TAD9PGz5wrCBuHDFTyxV+j4IqJN5dHNwAlXZCY6u/dfCXyCIb9v/HXmgriLYr PDAdKYzWfFffNt840QJBAOuYeVaGJp3Xb22vQi1kfIVCzgcOU6jYlRikuUhjq06f R5D2PXdfVncusNDSciIvbX/xEsFSg6njMeid3jMIJTUCQQCORREEE3ktRj7fNtiK 6PFofZLMGcygSnVxKkwWneBsZj3H4L/vqcsaa+idQlUdWnYjOPrjRAwjg2p6M24I yboHAkEAjyhces4TgxAYvo6jaM/JtnQsmy8CePP6TToy+CDQRHsW0qg+G15MPSma +ZkXD1zAbeEAI4bPSJksh4v+LAZEDQJAX0PIPR59Cd/7waQMJBgPbpSHc7vi1YKG WZylDo/w8yUTQYAxhd4AblTLkmIUdG9apANHnF64ch9RcTp299N8iQJAHmzlwcz+ hQAI3xu8A2OPKOuiF0axK8/TRhiGOGRwlsxAtK0kI2jMvm+3W6rDQ2I3626i5yK8 eh+Cy6sA4WzUUw=="));
//
//                Map<String, Object> keyMap = RSAUtils.genKeyPair();
//                publicKey = RSAUtils.getPublicKey(keyMap);
//                privateKey = RSAUtils.getPrivateKey(keyMap);
//                System.err.println("公钥: \n\r" + publicKey);
//                System.err.println("私钥： \n\r" + privateKey);
//            System.err.println("公钥加密——私钥解密");
//            String source = "*******************************JFASDKFJ";
//            System.out.println("\r加密前文字：\r\n" + source);
//            byte[] data = source.getBytes();
//            byte[] encodedData = RSAUtils.encryptByPublicKey("1".getBytes(), "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAILuIw+TGA317LGo biG2WnisQHya98CK3cVyZPUZ7cGKb6KXMzfmdtJ6lVFapMmhrj1VlRAZIuwP7O7A 6hhHxGslu7GYsgsGAtRP6hVAl8tNDRLCW9RagPAC2+NV/FSpjv1XYCYI3ZZnK4XY qqxZan9+rrSneyRAGX9JoHwu3oZzAgMBAAECgYAiLrXsnQSMsIXpJAYMuyUHmEEF xxejpx2bLPB6pRhTjSb0FfGDSKIA9YwCP14CXjm1PaC7ITTi2I2ND8SOLj5zMDHB oQ6TAD9PGz5wrCBuHDFTyxV+j4IqJN5dHNwAlXZCY6u/dfCXyCIb9v/HXmgriLYr PDAdKYzWfFffNt840QJBAOuYeVaGJp3Xb22vQi1kfIVCzgcOU6jYlRikuUhjq06f R5D2PXdfVncusNDSciIvbX/xEsFSg6njMeid3jMIJTUCQQCORREEE3ktRj7fNtiK 6PFofZLMGcygSnVxKkwWneBsZj3H4L/vqcsaa+idQlUdWnYjOPrjRAwjg2p6M24I yboHAkEAjyhces4TgxAYvo6jaM/JtnQsmy8CePP6TToy+CDQRHsW0qg+G15MPSma +ZkXD1zAbeEAI4bPSJksh4v+LAZEDQJAX0PIPR59Cd/7waQMJBgPbpSHc7vi1YKG WZylDo/w8yUTQYAxhd4AblTLkmIUdG9apANHnF64ch9RcTp299N8iQJAHmzlwcz+ hQAI3xu8A2OPKOuiF0axK8/TRhiGOGRwlsxAtK0kI2jMvm+3W6rDQ2I3626i5yK8 eh+Cy6sA4WzUUw==");
//            System.out.println("加密后文字：\r\n" + Base64.encodeBase64String(encodedData));
//        System.out.println("aaa:"+encodedData);
//            byte[] decodedData = RSAUtils.decryptByPrivateKey(Base64.decodeBase64(Base64.encodeBase64String(encodedData)), privateKey);
//            String target = new String(decodedData);
//            System.out.println("解密后文字: \r\n" + target);



        System.out.println("================================= ========================");
//        KeyPair keyPair = SecureUtil.generateKeyPair("RSA");
//        PrivateKey privateKey = keyPair.getPrivate();
//        PublicKey publicKey = keyPair.getPublic();
//        System.out.println("=====================privateKey== ============================");
//        System.out.println(Base64.encodeBase64String(privateKey.getEncoded()));
//        System.out.println("===================privateKey =============================");
//        System.out.println("===================publicKey===== ========================");
//        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
//        System.out.println("======================publicKey ===================================");
        RSA rsa = SecureUtil.rsa(null, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQt4qXr4ydETzoH6WSffRmNR1bWc/lVVqXzPcheIYT6nQAaDKXkE3DMNV81MtP24MTHKd+skR4oNj5yi6LDoRRkATauMSkmuyWRuEVu6XHyY90MmsQahac1791FV7fVBtW6DE1vM2VrEZCGP4Xx7L5yytINbRe+EvAShBw9pBBGQIDAQAB");
        String encrypt = rsa.encryptStr("{“productNo”:”1”,”amount”:”1”,”dataSource”:{},”sn”:”1”,”phone”:”1”,”bankCardNum”:”1”,”name”:”1”,”idCardNum”:”1”}", KeyType.PublicKey, CharsetUtil.CHARSET_UTF_8);
        System.out.println("加密后的内容:"+encrypt);

//        RSA rsa1 = new RSA("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJC3ipevjJ0RPOgfpZJ99GY1HVtZz+VVWpfM9yF4hhPqdABoMpeQTcMw1XzUy0/bgxMcp36yRHig2PnKLosOhFGQBNq4xKSa7JZG4RW7pcfJj3QyaxBqFpzXv3UVXt9UG1boMTW8zZWsRkIY/hfHsvnLK0g1tF74S8BKEHD2kEEZAgMBAAECgYAn6+n4pD3XCm1R34EOY16rX1Wk4KbALgaav7kg652ZGuE7R4NFWlKJWQxbrlwTwIttF0eBZO4MlNqmNccXJz8Kz96lIJ+aA83zLOc1/gDtcNG7X3k7ueGSEjx6XbzT2M4yfaMVxdDLqcp1CSn1qSnYrAzbEix99wtzwgSoRs36AQJBAPNTM8GX8RnAGZlOfw+A94mUcMd1dqeamW/WiDXh5yIkutuzVvk/8CEoPPuTEOW14ErJgqZ8HwDRrbKAK9MzhNkCQQCYQWCD7fooWR6vfi905G97ykzK22MzBkXgQ0IOlPLKjTnhHHir0B8V0EFbdBPhRgMdqiDDmqHRwz2TS6Vri/ZBAkEAxYNOSeFaVnq2zNkJDr6zMLyL53yT+mzmDABqxMJA6lhCTcB/4wdhlqihB91TJAPEszBrm1S5neKWSoT8Dg6N0QJAU5pCdu7rl9Any1FMmbD9jkmtFQ6WT+Q35kbINN2Q26vkhjluAVnMV9v8p0z7xYz+FQHf78gu5tGANCsrb/xwgQJADCoZBZI9Wp5ljBWCafEyVmJXsLxoHrw4Vk/Kj/py+pE+4AExyDGgewbCXPen4c9WQCtFUPos5y1z/pVuJ6tvDQ==", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQt4qXr4ydETzoH6WSffRmNR1bWc/lVVqXzPcheIYT6nQAaDKXkE3DMNV81MtP24MTHKd+skR4oNj5yi6LDoRRkATauMSkmuyWRuEVu6XHyY90MmsQahac1791FV7fVBtW6DE1vM2VrEZCGP4Xx7L5yytINbRe+EvAShBw9pBBGQIDAQAB");
//        String decrypt = rsa1.decryptStr(encrypt, KeyType.PrivateKey, CharsetUtil.CHARSET_UTF_8);
//        System.out.println("asdasda:"+decrypt); System.out.println("================================ =========================");

    }

//     @Test
//    public void base64(){
//         System.out.println("================================= ========================");
//        KeyPair keyPair = SecureUtil.generateKeyPair("RSA");
//        PrivateKey privateKey = keyPair.getPrivate();
//        PublicKey publicKey = keyPair.getPublic();
//         System.out.println("=====================privateKey== ============================");
//         System.out.println(Base64.encode(privateKey.getEncoded()));
//         System.out.println("===================privateKey =============================");
//         System.out.println("===================publicKey===== ========================");
//         System.out.println(Base64.encode(publicKey.getEncoded()));
//         System.out.println("======================publicKey ===================================");
//         RSA rsa =
//        SecureUtil.rsa(privateKey.getEncoded(), publicKey.getEncoded());
//         String encrypt = rsa.encryptStr("我是一段测试aaaa", KeyType.PublicKey, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(encrypt);
//
//        RSA rsa1 = new RSA(null, publicKey.getEncoded());
//        String decrypt = rsa1.decryptStr(encrypt, KeyType.PrivateKey, CharsetUtil.CHARSET_UTF_8);
//         System.out.println(decrypt); System.out.println("================================ =========================");
//}

}

