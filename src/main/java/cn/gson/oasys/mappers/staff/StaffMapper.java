package cn.gson.oasys.mappers.staff;



import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  15:22
 */
@Mapper
public interface StaffMapper {
    List<User> findAll();

    int add(User user);

    int update(User user);

    int remove(Long id);

    User findOne(Long id);

    List<User> findByName(String name);

    int updatePassword(User user);
    List<Role> findRole();
}
