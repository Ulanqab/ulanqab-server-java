package com.ulanqab.daily.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ulanqab.daily.api.user.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Jwt {

    private static final byte[] SECRET = "3d990d2276917dfac04467df1fdajkdfaff26d".getBytes();

    public static String createToken(User user) {
        String token = "";
        try {
            Map header = new HashMap();
            header.put("alg", "HS256");
            header.put("typ", "JWT");
            Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
            token = JWT.create()
                    .withHeader(header)
//                    .withClaim("nickName", user.getNickName())
//                    .withClaim("avatar", user.getAvatar())
                    .withClaim("thirdId", user.getThirdId())
//                    .withClaim("loginAt", user.getLoginAt())
                    .withClaim("exp", user.getExpiresAt())
                    .withClaim("role", user.getRole())
                    .withIssuer("auth0")
                    .sign(algorithmHS);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return token;
    }

    public static HashMap validToken(String token) {
        HashMap resultMap = new HashMap();

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        System.out.println("JWT" + jwt.getPayload());
        System.out.println("JWT" + jwt.getToken());
        System.out.println("JWT" + jwt.getHeader());
        try {
            resultMap = new ObjectMapper().readValue(jwt.getPayload(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
