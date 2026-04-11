package de.samuel.gamevault.controller;

import de.samuel.gamevault.config.TokenService;
import de.samuel.gamevault.documention.AuthControllerDoc;
import de.samuel.gamevault.exception.UsernameOrPasswordInvalidException;
import de.samuel.gamevault.model.UserModel;
import de.samuel.gamevault.records.request.LoginRequest;
import de.samuel.gamevault.records.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerDoc {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        try {

            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            UserModel userModel = (UserModel) authentication.getPrincipal();

            String token = tokenService.generateToken(userModel);

            return ResponseEntity.ok(new LoginResponse(token));

        }catch (BadCredentialsException exception) {
            throw new UsernameOrPasswordInvalidException("User or password are invalid");
        }

    }

}
