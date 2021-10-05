package com.zzq.service.impl;

import com.zzq.entity.User;
import com.zzq.mapper.UserMapper;
import com.zzq.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzq
 * @since 2021-09-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
