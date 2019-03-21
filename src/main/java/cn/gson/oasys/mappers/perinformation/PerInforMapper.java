package cn.gson.oasys.mappers.perinformation;

import cn.gson.oasys.model.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 万先生
 * 2019/2/25  20:06
 */
@Mapper
public interface PerInforMapper
{
    User find(Long id);

    int update(User user);
}
