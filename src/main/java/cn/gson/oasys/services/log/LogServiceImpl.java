package cn.gson.oasys.services.log;

import cn.gson.oasys.mappers.log.LogMapper;
import cn.gson.oasys.model.entity.log.Loges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class LogServiceImpl implements IlogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public List<Loges> findAll(String name) {
        return logMapper.findAll(name);
    }

    @Override
    public int remove(Integer id) {
        return logMapper.remove(id);
    }

    @Override
    public int update(Loges loges) {
        return logMapper.update(loges);
    }

    @Override
    public int add(Loges loges) {
        return logMapper.add(loges);
    }

    @Override
    public Loges findOne(Integer id) {
        return logMapper.findOne(id);
    }
}
