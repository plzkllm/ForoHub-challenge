package alura.api.forohub.controller;

import alura.api.forohub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity autenticarse(){
            var JWTtoken = tokenService.generarToken();
            return ResponseEntity.ok(JWTtoken);
        }
}
