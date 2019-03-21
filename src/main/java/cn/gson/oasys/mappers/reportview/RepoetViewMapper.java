package cn.gson.oasys.mappers.reportview;

import cn.gson.oasys.model.entity.workreport.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3  16:16
 */
@Mapper
public interface RepoetViewMapper {
    List<Report> findAll();
}
