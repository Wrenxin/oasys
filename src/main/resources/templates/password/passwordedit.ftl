<#include "/common/commoncss.ftl">
<#include "/common/modalTip.ftl"/>
<style type="text/css">
    a {
        color: black;
    }

    a:hover {
        text-decoration: none;
    }

    .bgc-w {
        background-color: #fff;
    }
</style>
<div class="row" style="padding-top: 10px;">
    <div class="col-md-2">
        <h1 style="font-size: 24px; margin: 0;" class="">工作汇报管理</h1>
    </div>
    <div class="col-md-10 text-right">
        <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
            disabled="disabled">工作汇报管理</a>
    </div>
</div>
<div class="row" style="padding-top: 15px;">
    <div class="col-md-12">
        <!--id="container"-->
        <div class="bgc-w box box-primary">
            <!--盒子头-->
            <div class="box-header">
                <h3 class="box-title">
                    <a href="reportview" class="label label-success" style="padding: 5px;">
                        <span class="glyphicon glyphicon-plus"></span> 新增
                    </a>
                </h3>
                <!-- <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                        <input type="text" class="form-control input-sm"
                            placeholder="查找..." />
                        <div class="input-group-btn">
                            <a class="btn btn-sm btn-default"><span
                                class="glyphicon glyphicon-search"></span></a>
                        </div>
                    </div>
                </div> -->
            </div>
            <!--盒子身体-->
            <div class="box-body no-padding">
                <div class="table-responsive">
                    <table class="table table-hover table-striped">
                        <tr>
                            <th scope="col">姓名</th>
                            <th scope="col">汇报内容</th>
                            <th scope="col">汇报时间</th>
                            <th scope="col">操作</th>
                        </tr>
                    <#list reports as report>
                        <tr>
                            <td><span>${report.reportName}</span></td>
                            <td><span>${report.reportContent}</span></td>
                            <td><span>${report.reportTime}</span></td>
                            <td>
                                <a href="getreport?id=${report.reportId}" class="label xiugai">
                                    <span class="glyphicon glyphicon-edit"></span> 修改</a>
                                <a href="reportremove?id=${report.reportId}" class="label shanchu"><span
                                        class="glyphicon glyphicon-remove"></span> 删除</a></td>
                        </tr>
                    </#list>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
