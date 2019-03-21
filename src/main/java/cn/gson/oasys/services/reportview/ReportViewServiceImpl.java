package cn.gson.oasys.services.reportview;

import cn.gson.oasys.mappers.reportview.RepoetViewMapper;
import cn.gson.oasys.model.entity.workreport.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class ReportViewServiceImpl implements IReportViewService {

    @Autowired
    private RepoetViewMapper repoetViewMapper;
    @Override
    public List<Report> findAll() {
        return repoetViewMapper.findAll();
    }

}
