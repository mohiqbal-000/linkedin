package com.linkedin.linkedin.features.authentication.controller;


import com.linkedin.linkedin.features.authentication.dto.AuthenticationRequestBody;
import com.linkedin.linkedin.features.authentication.dto.AuthenticationResponseBody;
import com.linkedin.linkedin.features.authentication.model.AuthenticationUser;
import com.linkedin.linkedin.features.authentication.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/user")
    public AuthenticationUser getUser(@RequestAttribute("authenticatedUser")AuthenticationUser authenticatedUser){

        return authenticationService.getUser(authenticatedUser.getEmail());
    }
    public AuthenticationController(AuthenticationService authenticationService){


        this.authenticationService   = authenticationService ;
    }

    @PostMapping("/register")
    public AuthenticationResponseBody RegisterUser(@Valid @RequestBody AuthenticationRequestBody registerRequestBody){

        return authenticationService.register(registerRequestBody);

    }
    @PostMapping ("/login")
    public AuthenticationResponseBody LoginUser(@Valid  @RequestBody AuthenticationRequestBody loginRequestBody){

        return authenticationService.login(loginRequestBody);

    }





}
