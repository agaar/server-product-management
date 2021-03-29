package com.raga.serverproductmanagement.controller;

import com.raga.serverproductmanagement.model.Product;
import com.raga.serverproductmanagement.model.StringResponse;
import com.raga.serverproductmanagement.service.ProductService;
import com.raga.serverproductmanagement.model.User;
import com.raga.serverproductmanagement.service.TransactionService;
import com.raga.serverproductmanagement.service.UserService;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
       User existUser = userService.findByUsername(user.getUsername());
       if(existUser != null && !existUser.getId().equals(user.getId())){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
       return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfUsers(){
        Long number = userService.numberOfUsers();
        //Long is not suitable response type for rest api, we will use String Response
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/admin/product-create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/product-update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("/api/admin/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-number")
    public ResponseEntity<?> numberOfProducts(){
        Long number = productService.numberOfProducts();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-all")
    public ResponseEntity<?> findAllTransactions(){
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-number")
    public ResponseEntity<?> numberOfTransactions(){
        Long number = transactionService.numberOfTransations();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return ResponseEntity<>(response, HttpStatus.OK);
    }
}
