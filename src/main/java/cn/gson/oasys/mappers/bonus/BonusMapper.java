package cn.gson.oasys.mappers.bonus;

import cn.gson.oasys.model.entity.bonus.Bonus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  15:22
 */
@Mapper
public interface BonusMapper {
    List<Bonus> findAll();

    int add(Bonus bonus);

    int update(Bonus bonus);

    int remove(Integer id);

    Bonus findOne(Integer id);
}
