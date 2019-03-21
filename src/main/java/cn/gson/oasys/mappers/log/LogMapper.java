package cn.gson.oasys.mappers.log;

import cn.gson.oasys.model.entity.log.Loges;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  15:22
 */
@Mapper
public interface LogMapper {
    List<Loges> findAll(String name);

    int add(Loges loges);

    int update(Loges loges);

    int remove(Integer id);

    Loges findOne(Integer id);
}
