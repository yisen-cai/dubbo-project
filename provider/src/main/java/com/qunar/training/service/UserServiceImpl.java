package com.qunar.training.service;


import com.qunar.training.entity.User;
import com.qunar.training.exceptions.InternalServerErrorException;
import com.qunar.training.exceptions.NotFoundException;
import com.qunar.training.mapper.UserMapper;
import com.qunar.training.utils.OkResult;
import com.qunar.training.utils.PageResult;
import com.qunar.training.vo.UpdateUserVO;
import com.qunar.training.vo.UserVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author YISHEN CAI
 */
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User addUser(UserVO userVO) {
        User user = userVO.getEntity();
        userMapper.insertUser(user);
        logger.info("user " + user.getId() + " created!");
        URI uri = null;
        try {
            uri = new URI("/api/users/" + user.getId());
        } catch (URISyntaxException e) {
            logger.error("URI syntax error");
            throw new InternalServerErrorException(e.getMessage());
        }
        return user;
    }

    @Override
    public PageResult<User> getUsers(String query, Boolean active, Boolean deleted, Integer size, Long offset) {
        long total = userMapper.countAllByQuery(query, active, deleted);
        List<User> users = userMapper.findAllByQuery(query, active, deleted, size, offset);
        return new PageResult<>(total, false, users);
    }

    @Override
    public User getUserById(Long id) {
        User user = userMapper.findTopById(id);
        if (user != null) {
            return user;
        }
        throw new NotFoundException("请求的用户未找到");
    }

    @Override
    public OkResult deleteById(Long id) {
        int res = userMapper.deleteById(id);
        if (res > 0) {
            return new OkResult("删除成功");
        }
        logger.error("啥都没干");
        throw new UnknownError();
    }

    @Override
    public OkResult updateUserById(Long id, UpdateUserVO userVO) {
        User entity = userMapper.findOneById(id);
        entity = userVO.updateAndGetEntity(entity);
        int res = userMapper.updateUserById(entity);
        if (res > 0) {
            return new OkResult("修改用户信息成功");
        }
        logger.error("啥都没干");
        throw new UnknownError();
    }
}
