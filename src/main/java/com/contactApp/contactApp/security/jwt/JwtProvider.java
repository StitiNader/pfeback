package com.contactApp.contactApp.security.jwt;

import com.contactApp.contactApp.security.jwt.service.UserPrinciple;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String jwtSercret;
    @Value("${jwt.jwtExpiration}")
    private int jwtExpiration;

    public String generateToken(UserPrinciple userPrinciple) {
        return Jwts.builder().claim("id", userPrinciple.getId()).setSubject(userPrinciple.getUsername()).setIssuedAt(new Date()).setExpiration(new Date((new Date().getTime() + jwtExpiration * 1000L))).signWith(SignatureAlgorithm.HS256, jwtSercret).compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSercret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSercret).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            return false;
        }catch (MalformedJwtException e){
            return false;
        }catch (UnsupportedJwtException e){
            return false;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}

