package com.myaccessweb.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccessweb.dtos.UserRecordDTO;
import com.myaccessweb.dtos.UserUpdateRecordDTO;
import com.myaccessweb.models.User;
import com.myaccessweb.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "UserController.java")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find all users ordered by email (max 20 per page)", description = "* Method: getAllUsersPageable")
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsersPageable(@PageableDefault(page = 0, size = 20, sort = "email", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserListPageable(pageable));
    }

    @Operation(summary = "Find one user by email", description = "* Method: getUserByEmail")
    @GetMapping("/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @Operation(summary = "Create one user", description = "* Method: createUser")
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        if (userService.existByEmail(userRecordDTO.email())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail already registered!");
        }
        var user = new User();
        BeanUtils.copyProperties(userRecordDTO, user);
        user.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        user.setUpdateDate(null);
        user.setLoginDate(null);
        user.setBlocked(false);
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Operation(summary = "Delete one user by email", description = "* Method: deleteUser")
    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        userService.deleteUser(userOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
    }

    @Operation(summary = "Update one user by email", description = "* Method: updateUser")
    @PutMapping("/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable String email, @RequestBody @Valid UserUpdateRecordDTO userUpdateRecordDTO) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        var user = new User();
        BeanUtils.copyProperties(userUpdateRecordDTO, user);
        user.setId(userOptional.get().getId());
        user.setEmail(userOptional.get().getEmail());
        user.setCreateDate(userOptional.get().getCreateDate());
        user.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        user.setLoginDate(userOptional.get().getLoginDate());
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
    }
}