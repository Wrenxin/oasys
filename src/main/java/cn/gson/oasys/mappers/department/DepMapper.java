package cn.gson.oasys.mappers.department;


import cn.gson.oasys.model.entity.department.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  15:22
 */
@Mapper
public interface DepMapper {
    List<Department> findAll();

    int add(Department department);

    int update(Department department);

    int remove(Integer id);

    Department findOne(Integer id);
}
