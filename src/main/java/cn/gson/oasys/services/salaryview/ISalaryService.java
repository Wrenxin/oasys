package cn.gson.oasys.services.salaryview;




import cn.gson.oasys.model.entity.user.User;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3 13:23
 */
public interface ISalaryService {

    List<User> findAll();

}
