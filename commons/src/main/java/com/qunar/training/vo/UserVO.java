package com.qunar.training.vo;



import com.qunar.training.entity.GenderEnum;
import com.qunar.training.entity.User;
import com.qunar.training.utils.GenderEnumTypeHandler;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author YISHEN CAI
 */
public class UserVO implements Serializable {
    @NotBlank(message = "username不可为空")
    private String username;

    private String avatar;

    @NotBlank(message = "nickname不可为空")
    private String nickname;

    private Integer gender = GenderEnum.UNKNOWN.getValue();

    @NotNull(message = "birthday不可为空")
    private Long birthday;

    @NotBlank(message = "备注不可为空")
    private String userComment;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public User getEntity() {
        User user = new User();
        user.setActive(true);
        user.setAvatar(this.avatar);
        user.setDeleted(false);
        user.setUsername(this.username);
        user.setNickname(this.nickname);
        user.setUserComment(this.userComment);
        user.setGender(GenderEnumTypeHandler.genderEnumMap.get(gender));
        user.setBirthday(new Date(this.birthday));
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return user;
    }
}
