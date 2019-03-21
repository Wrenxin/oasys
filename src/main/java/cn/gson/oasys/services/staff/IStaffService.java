package cn.gson.oasys.services.staff;




import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.User;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:21
 */

public interface IStaffService {

    List<User> findAll();

    int add(User user);

    int update(User user);

    int remove(Long id);

    User findOne(Long id);

    List<User> findByRealName(String name);

    int updatePassword(User user);

    List<Role> findRole();

}
