package com.isi.secureappspring.controller;

import com.isi.secureappspring.dto.request.AccountUserDtoRequest;
import com.isi.secureappspring.dto.response.AccountUserDtoResponse;
import com.isi.secureappspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<AccountUserDtoResponse> saveUser(@RequestBody AccountUserDtoRequest accountUserDtoRequest) {
        return new ResponseEntity<>(userService.saveUser(accountUserDtoRequest), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<AccountUserDtoResponse>> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(userService.getUsers(page, size), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AccountUserDtoResponse> getUserByEmail(@PathVariable long id) {
        AccountUserDtoResponse accountUserDtoResponse = userService.getUserById(id);
        if (accountUserDtoResponse != null){
            return new ResponseEntity<>(accountUserDtoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<AccountUserDtoResponse> getUserByEmail(@PathVariable String email) {
        AccountUserDtoResponse accountUserDtoResponse = userService.getUserByEmail(email);
        if (accountUserDtoResponse != null){
            return new ResponseEntity<>(accountUserDtoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users")
    public ResponseEntity<AccountUserDtoResponse> editUser(@RequestBody AccountUserDtoResponse accountUserDtoResponse) {
        AccountUserDtoResponse accountUserDtoResponse1 = userService.editUser(accountUserDtoResponse);
        if(accountUserDtoResponse1 != null){
            return new ResponseEntity<>(accountUserDtoResponse1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<AccountUserDtoResponse> deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{id}/status")
    public ResponseEntity<AccountUserDtoResponse> changeSatus(@PathVariable long id) {
        userService.changeSatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
