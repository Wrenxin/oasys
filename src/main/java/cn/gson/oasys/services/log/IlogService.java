package cn.gson.oasys.services.log;

import cn.gson.oasys.model.entity.log.Loges;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:21
 */

public interface IlogService {

    List<Loges> findAll(String name);

    int add(Loges loges);

    int update(Loges loges);

    int remove(Integer id);

    Loges findOne(Integer id);
}
