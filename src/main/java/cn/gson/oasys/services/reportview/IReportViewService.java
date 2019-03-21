package cn.gson.oasys.services.reportview;



import cn.gson.oasys.model.entity.workreport.Report;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3 13:23
 */
public interface IReportViewService {

    List<Report> findAll();

}
