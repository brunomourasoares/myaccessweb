package com.myaccessweb.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myaccessweb.dtos.UserRecordDTO;
import com.myaccessweb.dtos.UserUpdateRecordDTO;
import com.myaccessweb.models.User;
import com.myaccessweb.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> findAllUser(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUserPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneUser(@PathVariable UUID id) {
        Optional<User> userOptional = userService.findOneUser(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        if (userService.existsByEmail(userRecordDTO.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail already registered!");
        }
        var user = new User();
        BeanUtils.copyProperties(userRecordDTO, user);
        user.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        user.setUpdateDate(null);
        user.setLoginDate(null);
        user.setBlocked(false);
        userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
        Optional<User> userOptional = userService.findOneUser(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        userService.deleteUser(userOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable UUID id, @RequestBody @Valid UserUpdateRecordDTO userUpdateRecordDTO) {
        Optional<User> userOptional = userService.findOneUser(id);
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
