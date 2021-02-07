package com.mushroom.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    public static final long EXCEED_TIME=30*60;
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2021BQWE";
    /****/
    public static String CreateToken(String username ,String password){
        Date exceedDate = new Date(System.currentTimeMillis() + EXCEED_TIME);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        HashMap<String, Object> headerMsg = new HashMap<>();
        headerMsg.put("typ","JWT");
        headerMsg.put("alg","HS256");
        String token = JWT.create()
                .withHeader(headerMsg)
                .withClaim("username", username)
                .withClaim("password", password).sign(algorithm);
        return token;
    }

    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier build = JWT.require(algorithm).build();
            DecodedJWT verify = build.verify(token);
            return  true ;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
//    public  static String createJWT(String id ,String subject,long exceedTime){
// private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
//        return "token";
//    }
//    public CheckR
}
