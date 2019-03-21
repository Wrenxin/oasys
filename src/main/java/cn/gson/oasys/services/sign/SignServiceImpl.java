package cn.gson.oasys.services.sign;


import cn.gson.oasys.mappers.sign.SignMapper;
import cn.gson.oasys.model.entity.sign.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/5  14:22
 */
@Service
public class SignServiceImpl implements ISignService {

    @Autowired
    private SignMapper signMapper;
    @Override
    public List<Sign> findByName(String name) {
        return signMapper.find(name);
    }
    @Override
    public List<Sign> findAll() {
        return signMapper.findAll();
    }

    @Override
    public int add(Sign sign){
        return signMapper.add(sign);
    }
    @Override
    public Sign find(String time){
        return signMapper.findCheck(time);
    }

}
