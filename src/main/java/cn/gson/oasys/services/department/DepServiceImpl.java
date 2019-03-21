package cn.gson.oasys.services.department;

import cn.gson.oasys.mappers.department.DepMapper;
import cn.gson.oasys.model.entity.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class DepServiceImpl implements IDepService {

    @Autowired
    private DepMapper depMapper;
    @Override
    public List<Department> findAll() {
        return depMapper.findAll();
    }

    @Override
    public int remove(Integer id) {
        return depMapper.remove(id);
    }

    @Override
    public int update(Department department) {
        return depMapper.update(department);
    }

    @Override
    public int add(Department department) {
        return depMapper.add(department);
    }

    @Override
    public Department findOne(Integer id) {
        return depMapper.findOne(id);
    }
}
