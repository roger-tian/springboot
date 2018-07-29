package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.IgrsUserMapper;
import com.demo.springboot.model.IgrsUser;
import com.demo.springboot.service.IgrsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IgrsUserServiceImpl implements IgrsUserService {
    @Autowired
    private IgrsUserMapper igrsUserMapper;
    @Resource(name="igrsRedisTemplate")
    private RedisTemplate<Object, Object> igrsRedisTemplate;

    @Override
    public IgrsUser getUserById(Long id) {
        return igrsUserMapper.getUserById(id);
    }

    @Override
    public IgrsUser getUserByName(String userName) {
        IgrsUser igrsUser = null;
        String key = "user";

        boolean hasKey = igrsRedisTemplate.hasKey(key);
        if (hasKey) {
            igrsUser = (IgrsUser) igrsRedisTemplate.boundValueOps(key).get();
            logger.debug("get from redis: {}-{}-{}", igrsUser.getUser(), igrsUser.getPassword(), igrsUser.getRole());
            return igrsUser;
        } else {
            igrsUser = igrsUserMapper.getUserByName(userName);
            if (igrsUser != null) {
                igrsRedisTemplate.boundValueOps(key).set(igrsUser);
                logger.debug("insert igrsUser into redis");
                return igrsUser;
            } else {
                return null;
            }
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(IgrsUserServiceImpl.class);
}
