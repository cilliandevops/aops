package website.cillian.aops.serviceImpl;

import website.cillian.aops.entity.User;
import website.cillian.aops.mapper.UserMapper;
import website.cillian.aops.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cillian
 * @since 2023-10-30 04:44:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
