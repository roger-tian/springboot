package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.IgrsUserMapper;
import com.demo.springboot.model.IgrsUser;
import com.demo.springboot.service.IgrsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "igrsUserService")
public class IgrsUserServiceImpl implements IgrsUserService {
    @Autowired
    private IgrsUserMapper igrsUserMapper;

    @Override
    public IgrsUser getUserById(Long id) {
        return igrsUserMapper.getUserById(id);
    }

    @Override
    public IgrsUser getUserByName(String userName) {
        return igrsUserMapper.getUserByName(userName);
    }

    private static final Logger logger = LoggerFactory.getLogger(IgrsUserServiceImpl.class);
}
