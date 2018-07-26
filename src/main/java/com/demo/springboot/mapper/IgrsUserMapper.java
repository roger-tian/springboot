package com.demo.springboot.mapper;

import com.demo.springboot.model.IgrsUser;

public interface IgrsUserMapper {
    IgrsUser getUserById(Long id);

    IgrsUser getUserByName(String user);
}