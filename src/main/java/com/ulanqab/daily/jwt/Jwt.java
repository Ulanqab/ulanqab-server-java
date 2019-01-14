package com.ulanqab.daily.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public class Jwt {

    private static final byte[] SECRET = "3d990d2276917dfac04467df1fdajkdfaff26d".getBytes();

    public static String createToken(Long expireTime, Integer role) {
        String token = "";
        try {
            Map header = new HashMap();
            header.put("alg", "HS256");
            header.put("typ", "JWT");
            Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("exp", expireTime)
                    .withClaim("role", role)
                    .withIssuer("auth0")
                    .sign(algorithmHS);
        } catch (JWTCreationException exception) {
            //
        }
        return token;
    }

    public static Map<String, Object> validToken(String token) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return resultMap;
    }
}
