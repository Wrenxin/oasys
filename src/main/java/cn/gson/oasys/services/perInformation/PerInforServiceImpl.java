package cn.gson.oasys.services.perInformation;

import cn.gson.oasys.mappers.perinformation.PerInforMapper;
import cn.gson.oasys.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 万先生
 * 2019/2/25  20:04
 */
@Service
public class PerInforServiceImpl implements IPerInforService {
    @Autowired
    private PerInforMapper perInforMapper;
    @Override
    public User find(Long id) {
        return perInforMapper.find(id);
    }

    @Override
    public int update(User user) {
        return perInforMapper.update(user);
    }
}
