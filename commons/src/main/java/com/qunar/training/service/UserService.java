package com.qunar.training.service;


import com.qunar.training.entity.User;
import com.qunar.training.utils.OkResult;
import com.qunar.training.utils.PageResult;
import com.qunar.training.vo.UpdateUserVO;
import com.qunar.training.vo.UserVO;


/**
 * @author YISHEN CAI
 */
public interface UserService {

    User addUser(UserVO userVO);

    PageResult<User> getUsers(String query, Boolean active, Boolean deleted, Integer size, Long offset);

    User getUserById(Long id);

    OkResult deleteById(Long id);

    OkResult updateUserById(Long id, UpdateUserVO userVO);
}
