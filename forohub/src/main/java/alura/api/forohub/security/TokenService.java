package alura.api.forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String generarToken(){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("20200138");
            return JWT.create().withIssuer("auth0").sign(algorithm);

        } catch (JWTVerificationException exception){
            throw new RuntimeException();
        }

    }
}
