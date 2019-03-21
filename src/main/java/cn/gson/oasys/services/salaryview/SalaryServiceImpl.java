package cn.gson.oasys.services.salaryview;


import cn.gson.oasys.mappers.salaryview.SalaryViewMapper;
import cn.gson.oasys.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    private SalaryViewMapper salaryViewMapper;
    @Override
    public List<User> findAll() {
        return salaryViewMapper.findAll();
    }

}
