package cn.gson.oasys.services.bonus;

import cn.gson.oasys.mappers.bonus.BonusMapper;
import cn.gson.oasys.model.entity.bonus.Bonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/4  13:22
 */
@Service
public class BonusServiceImpl implements IBonusService {

    @Autowired
    private BonusMapper bonusMapper;

    @Override
    public List<Bonus> findAll() {
        return bonusMapper.findAll();
    }

    @Override
    public int add(Bonus bonus) {
        return bonusMapper.add(bonus);
    }

    @Override
    public int update(Bonus bonus) {
        return bonusMapper.update(bonus);
    }

    @Override
    public int remove(Integer id) {
        return bonusMapper.remove(id);
    }

    @Override
    public Bonus findOne(Integer id) {
        return bonusMapper.findOne(id);
    }
}
