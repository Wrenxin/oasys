package cn.gson.oasys.services.bonus;


import cn.gson.oasys.model.entity.bonus.Bonus;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:21
 */

public interface IBonusService {

    List<Bonus> findAll();

    int add(Bonus loges);

    int update(Bonus bonus);

    int remove(Integer id);

    Bonus findOne(Integer id);
}
