package com.zzq.service.impl;

import com.zzq.entity.Blog;
import com.zzq.mapper.BlogMapper;
import com.zzq.service.IBlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
