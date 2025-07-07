package com.iamdvh.repository.custom;

import com.iamdvh.repository.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> findByRole(String roleCode);
}
