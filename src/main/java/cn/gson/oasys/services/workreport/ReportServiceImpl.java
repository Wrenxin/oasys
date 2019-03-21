package cn.gson.oasys.services.workreport;

import cn.gson.oasys.mappers.workreport.ReportMapper;
import cn.gson.oasys.model.entity.workreport.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:22
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;
    @Override
    public List<Report> findAll(String name) {
        return reportMapper.findAll(name);
    }

    @Override
    public int add(Report report) {
        return reportMapper.add(report);
    }

    @Override
    public int update(Report report) {
        return reportMapper.update(report);
    }

    @Override
    public int remove(Integer id) {
        return reportMapper.remove(id);
    }

    @Override
    public Report findOne(Integer id) {
        return reportMapper.findOne(id);
    }
}
