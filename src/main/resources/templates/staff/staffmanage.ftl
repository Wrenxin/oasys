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
<div class="thistable">
    <div class="row" style="padding-top: 10px;">
        <div class="col-md-2">
            <h1 style="font-size: 24px; margin: 0;" class="">员工管理</h1>
        </div>
        <div class="col-md-10 text-right">
            <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
                disabled="disabled">员工管理</a>
        </div>
    </div>
    <div class="row" style="padding-top: 15px;">
        <div class="col-md-12 ">
            <div class="bgc-w box box-primary">
                <!--盒子头-->
                <div class="box-header">
                    <h3 class="box-title">
                        <a href="staffview" class="label label-success" style="padding: 5px;">
                            <span class="glyphicon glyphicon-plus"></span> 新增
                        </a>
                    </h3>
                    <div class="box-tools">
                        <div class="input-group" style="width: 150px;">
                            <input type="text" class="form-control input-sm cha"
                                   placeholder="查找姓名"/>
                            <div class="input-group-btn chazhao">
                                <a class="btn btn-sm btn-default"><span
                                        class="glyphicon glyphicon-search"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--盒子身体-->
                <div class="box-body no-padding">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <tr>
                                <th scope="col">部门</th>
                                <th scope="col">用户名</th>
                                <th scope="col">真实姓名</th>
                                <th scope="col">电话</th>
                                <th scope="col">工资</th>
                                <th scope="col">操作</th>
                            </tr>
                        <#list staffList as staff>
                            <tr>
                                <td><span>${(staff.departmentName)!''}</span></td>
                                <td><span>${(staff.username)!''}</span></td>
                                <td><span>${(staff.realName)!''}</span></td>
                                <td><span>${(staff.tel)!''}</span></td>
                                <td><span>${(staff.salary)!''}</span></td>
                                <td><a href="getstaff?id=${staff.id}" class="label xiugai"><span
                                        class="glyphicon glyphicon-edit"></span> 修改</a> <a
                                        onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"
                                        href="removestaff?id=${staff.id}" class="label shanchu"><span
                                        class="glyphicon glyphicon-remove"></span> 删除</a></td>
                            </tr>

                        </#list>

                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    $(function () {

        /*查找*/
        $(".chazhao").click(function () {
            var con = $(".cha").val();
            $(".thistable").load("staffchaxun", {title: con});
        });
    })
</script>
