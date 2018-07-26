package com.demo.springboot.service;

import com.demo.springboot.model.IgrsUser;

public interface IgrsUserService {
    IgrsUser getUserById(Long id);

    IgrsUser getUserByName(String userName);
}
