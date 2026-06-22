package com.avarszegi.NotesApp.security.jwt.impl;

import com.avarszegi.NotesApp.security.jwt.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Override
    public String generateToken(String name, Date expiresIn) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));                // Zasifruj tajny kluc pomocou HMAC-SHA
        String jws = Jwts.builder().subject(name).expiration(expiresIn).signWith(key).compact(); // Vytvor JWS pomocou tajneho kluce uz zasifrovaneho
                                                                                                 // a nastav expiraciu na jednu hodinu od generovania tokenu
        return jws;
    };

}
