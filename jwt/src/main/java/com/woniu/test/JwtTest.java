package com.woniu.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Date;

public class JwtTest {

    private final static Long EXPIRE_TIME=300*1000L;


    public static void main(String[] args) {
        //加密
        /*
        withClaim(key,value):向jwt中保存希望令牌传递的数据
        withExpiresAt()：设置令牌有效期
        sign(Algorithm.签名算法("随机签名"));设置签名
         */
        System.out.println("EXPIRE_TIME==="+EXPIRE_TIME);

        JWTCreator.Builder builder = JWT.create();
        String token = JWT.create().withClaim("name", "zyy")
                .withClaim("age", 25)
//                .withExpiresAt(new Date(System.currentTimeMillis()+600L))
                .withExpiresAt(new Date(System.currentTimeMillis()+60000L))//设置过期时间
                .sign(Algorithm.HMAC256("ddddferrgkbtodddtrop34mv"));
        System.out.println(token);

        //解密
        JWTVerifier verification = JWT.require(Algorithm.HMAC256("ddddferrgkbtodddtrop34mv")).build();
        DecodedJWT verify = verification.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoienl5IiwiZXhwIjoxNjE0NjU5MjM4LCJhZ2UiOjI1fQ.RLTLmCd8isd56ISEJ833FFQyp1tuhMFCy5TWphvlJkI");
        System.out.println("姓名："+verify.getClaim("name").asString());
        System.out.println("年龄："+verify.getClaim("age").asInt());
        System.out.println("算法："+verify.getAlgorithm());
        System.out.println("Header:"+verify.getHeader());
        System.out.println("Token:"+verify.getToken());
        System.out.println("Signature:"+verify.getSignature());
        System.out.println("PayLoad:"+verify.getPayload());
    }
}
