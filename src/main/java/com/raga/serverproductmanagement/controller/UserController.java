package com.raga.serverproductmanagement.controller;

import com.raga.serverproductmanagement.jwt.JwtTokenProvider;
import com.raga.serverproductmanagement.model.Product;
import com.raga.serverproductmanagement.model.Role;
import com.raga.serverproductmanagement.model.Transaction;
import com.raga.serverproductmanagement.model.User;
import com.raga.serverproductmanagement.service.ProductService;
import com.raga.serverproductmanagement.service.TransactionService;
import com.raga.serverproductmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal){
        //principal = httpServletRequest.getUserPrincipal.
        log.info(String.valueOf("user:" + principal));
        if(principal == null){
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        // Authentication authentication = authenticationToken;
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct (@RequestBody Transaction transaction){
        transaction.setPurchaseDate(LocalDateTime.now());
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}