package com.qunar.training.controller;


import com.qunar.training.entity.User;
import com.qunar.training.service.UserService;
import com.qunar.training.utils.OkResult;
import com.qunar.training.utils.PageResult;
import com.qunar.training.vo.UpdateUserVO;
import com.qunar.training.vo.UserVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author YISHEN CAI
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:20880")
    private UserService userService;


    @GetMapping
    public ResponseEntity<PageResult<User>> getUsers(@RequestParam(required = false, defaultValue = "") String query,
                                                     @RequestParam(required = false, defaultValue = "true") Boolean active,
                                                     @RequestParam(required = false, defaultValue = "false") Boolean delete,
                                                     @RequestParam(required = false, defaultValue = "5") Integer size,
                                                     @RequestParam(required = false, defaultValue = "0") Long offset) {
        return ResponseEntity.ok(userService.getUsers(query, active, delete, size, offset));
    }


    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserVO userVO) {
        return ResponseEntity.ok(userService.addUser(userVO));
    }


    @PutMapping("/{userId}")
    public ResponseEntity<OkResult> updateUserById(@PathVariable Long userId, @Valid @RequestBody UpdateUserVO userVO) {
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(userService.updateUserById(userId, userVO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<OkResult> deleteUserById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.deleteById(userId));
    }
}
