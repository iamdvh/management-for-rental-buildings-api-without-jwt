package com.iamdvh.repository.custom;

import com.iamdvh.repository.entity.RoleEntity;

public interface RoleRepositoryCustom {
    RoleEntity findByCode(String code);
}
