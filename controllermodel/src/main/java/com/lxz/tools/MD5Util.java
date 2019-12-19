package com.lxz.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;

public class MD5Util {

    public static String  getMd5Salt(String pwd,String salt)throws  Exception{


        pwd=pwd+salt;

        //得到摘要器
        //得到一个摘要器
        MessageDigest md= MessageDigest.getInstance("MD5");

        //使用指定字节更新数组
        md.update(pwd.getBytes());

        //获得密文---字节数组
        byte b[]=md.digest();

        //转换为字符串
        pwd=new String(new Hex().encode(b));   //加盐后普通加密后的密文32

        System.out.println("pwd:::"+pwd);

        //将盐--16 参入密文====48
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = pwd.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = pwd.charAt(i / 3 * 2 + 1);
        }


        return new String(cs);  //48位密文

    }

    //比对
    public static boolean bd(String pwd,String md5str) throws Exception{


        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String salt=new String(cs2);
        pwd=pwd+salt;

        //得到一个摘要器
        MessageDigest md= MessageDigest.getInstance("MD5");

        //使用指定字节更新数组
        md.update(pwd.getBytes());

        //获得密文---字节数组
        byte b[]=md.digest();

        //转换为字符串
        String md5_32=new String(new Hex().encode(b));

        boolean bool=md5_32.equals(new String(cs1));
        return  bool;
    }
}
