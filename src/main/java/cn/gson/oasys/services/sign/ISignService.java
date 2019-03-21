package cn.gson.oasys.services.sign;




import cn.gson.oasys.model.entity.sign.Sign;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/5 14:23
 */
public interface ISignService {

    List<Sign> findByName(String name);
    List<Sign> findAll();
    int add(Sign sign);

    Sign find(String time);

}
