package cn.gson.oasys.mappers.workreport;


import cn.gson.oasys.model.entity.workreport.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3  13:30
 */
@Mapper
public interface ReportMapper {
    List<Report> findAll(String user);

    int add(Report report);

    int update(Report report);

    int remove(Integer id);

    Report findOne(Integer id);
}
