package cn.gson.oasys.services.department;


import cn.gson.oasys.model.entity.department.Department;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:21
 */

public interface IDepService {

    List<Department> findAll();

    int add(Department department);

    int update(Department department);

    int remove(Integer id);

    Department findOne(Integer id);


}
