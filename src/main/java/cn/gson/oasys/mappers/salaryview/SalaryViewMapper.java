package cn.gson.oasys.mappers.salaryview;


import cn.gson.oasys.model.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3  16:18
 */
@Mapper
public interface SalaryViewMapper {
    List<User> findAll();
}
