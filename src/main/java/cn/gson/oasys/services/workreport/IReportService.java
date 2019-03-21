package cn.gson.oasys.services.workreport;



import cn.gson.oasys.model.entity.workreport.Report;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3 13:23
 */
public interface IReportService {

    List<Report> findAll(String name);

    int add(Report report);

    int update(Report report);

    int remove(Integer id);

    Report findOne(Integer id);
}
