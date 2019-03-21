package cn.gson.oasys.services.perInformation;

import cn.gson.oasys.model.entity.user.User;

/**
 * Created by 万先生
 * 2019/2/25  20:03
 */
public interface IPerInforService {
    User find(Long id);
    int update(User user);
}
