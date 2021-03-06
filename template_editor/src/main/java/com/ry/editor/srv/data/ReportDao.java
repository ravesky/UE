package com.ry.editor.srv.data;

import com.ry.editor.srv.dao.EditorDao;
import com.ry.editor.srv.entity.TpTemplateReport;
import com.ry.editor.srv.utils.KingUtil;
import com.tt.pwp.framework.data.dao.DaoFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by KING on 2018/3/13.
 */
@Component("tpReportDao")
public class ReportDao extends EditorDao<TpTemplateReport, Integer> {
    public static Logger log = Logger.getLogger(ReportDao.class);

    private DaoFactory daoFactory = null;


    /**
     * 批量插入报告数据,返回实体list
     *
     * @return List
     */
    public List<TpTemplateReport> batchInsertReport(List<TpTemplateReport> list, String aloDataSource) throws Exception {
        List<TpTemplateReport> resInsert = null;
        long startTime = KingUtil.logStart("batchUpdateReport", aloDataSource);
        if (aloDataSource != null && !aloDataSource.isEmpty()) {
            resInsert = super.getDao(aloDataSource).batchInsert(list);
        } else {
            resInsert = super.getDefaultDao().batchInsert(list);
        }
        KingUtil.logEnd("batchUpdateReport", startTime, resInsert);
        return resInsert;
    }

    /**
     * 批量修改报告数据
     *
     * @return Dao
     */
    public int batchUpdateReport(List<TpTemplateReport> list, String aloDataSource) throws Exception {
        int resUpdate = 0;
        long startTime = KingUtil.logStart("batchUpdateReport", aloDataSource);
        if (aloDataSource != null && !aloDataSource.isEmpty()) {
            resUpdate = super.getDao(aloDataSource).batchUpdate(list);
        } else {
            resUpdate = super.getDefaultDao().batchUpdate(list);
        }
        KingUtil.logEnd("batchUpdateReport", startTime, resUpdate);
        return resUpdate;
    }

    /**
     * 批量删除报告数据
     *
     * @return int
     */
    public int batchRemoveReport(List<TpTemplateReport> list, String aloDataSource) throws Exception {
        int resRemove = 0;
        long startTime = KingUtil.logStart("batchRemoveReport", aloDataSource);
        if (aloDataSource != null && !aloDataSource.isEmpty()) {
            resRemove = super.getDao(aloDataSource).batchRemove(list);
        } else {
            resRemove = super.getDefaultDao().batchRemove(list);
        }
        KingUtil.logEnd("batchRemoveReport", startTime, resRemove);
        return resRemove;
    }

    public List<TpTemplateReport> findById(String id) throws Exception {
        String sql = "select * from TP_TEMPLATE_REPORT t where t.id=? ";
        Object[] params = {id};
        List<TpTemplateReport> reportList = super.findBySQL(sql, params);
        return reportList;
    }

    public void updateReport(TpTemplateReport report) {
        super.update(report);
    }

    public void removeReport(TpTemplateReport report) {
        super.remove(report);
    }
}
