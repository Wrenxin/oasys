package cn.gson.oasys.mappers.sign;


import cn.gson.oasys.model.entity.sign.Sign;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/5  16:16
 */
@Mapper
public interface SignMapper {
    List<Sign> find(String name);
    List<Sign> findAll();
    int add(Sign sign);
    Sign findCheck(String time);
}
