package website.cillian.aops.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import website.cillian.aops.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cillian
 * @since 2023-10-30 04:44:39
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
