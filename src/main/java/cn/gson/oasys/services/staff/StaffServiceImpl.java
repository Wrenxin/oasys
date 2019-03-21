package cn.gson.oasys.services.staff;


import cn.gson.oasys.mappers.staff.StaffMapper;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<User> findAll() {
        return staffMapper.findAll();
    }

    @Override
    public int add(User user) {
        return staffMapper.add(user);
    }

    @Override
    public int update(User user) {
        return staffMapper.update(user);
    }

    @Override
    public int remove(Long id) {
        return staffMapper.remove(id);
    }

    @Override
    public User findOne(Long id) {
        return staffMapper.findOne(id);
    }

    @Override
    public int updatePassword(User user) {
        return staffMapper.updatePassword(user);
    }

    @Override
    public List<Role> findRole() {
        return staffMapper.findRole();
    }

    @Override
    public List<User> findByRealName(String name) {
        return staffMapper.findByName(name);
    }
}
