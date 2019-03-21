<#include "/common/commoncss.ftl">
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
        <h1 style="font-size: 24px; margin: 0;" class="">员工管理</h1>
    </div>
    <div class="col-md-10 text-right">
        <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
            disabled="disabled">员工管理</a>
    </div>
</div>
<div class="row" style="padding-top: 15px;">
    <div class="col-md-12">
        <!--id="container"-->
        <div class="bgc-w box">
            <!--盒子头-->
            <form action="staffedit" method="post" onsubmit="return check();">
                <div class="box-header">
                    <h3 class="box-title">
                        <a href="javascript:history.back();" class="label label-default" style="padding: 5px;">
                            <i class="glyphicon glyphicon-chevron-left"></i> <span>返回</span>
                        </a>
                    </h3>
                </div>
                <!--盒子身体-->
                <div class="box-body no-padding">
                    <div class="box-body">
                        <div class="alert alert-danger alert-dismissable" role="alert"
                             style="display: none;">
                            错误信息:
                            <button class="close thisclose" type="button">&times;</button>
                            <span class="error-mess"></span>
                        </div>
                        <div class="row">

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>用户名</span></label> <input
                                    name="userName" class="form-control usernameonliy" value="${(user.userName)!''}"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>电话</span></label> <input
                                    name="userTel" class="form-control" value="${(user.userTel)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>真实姓名</span></label> <input
                                    name="realName" class="form-control" value="${(user.realName)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>Email</span></label> <input
                                    name="eamil" class="form-control" value="${(user.eamil)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>地址</span></label> <input
                                    name="address" class="form-control" value="${(user.address)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>学历</span></label> <input
                                    name="userEdu" class="form-control" value="${(user.userEdu)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>毕业院校</span></label> <input
                                    name="school" class="form-control" value="${(user.school)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>身份证号</span></label> <input
                                    name="idCard" class="form-control" value="${(user.idCard)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>银行账号</span></label> <input
                                    name="bank" class="form-control" value="${(user.bank)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"> <span>部门</span></label>
                                <select class="deptselect form-control" name="departmentId">
                                <#if user??>
                                    <option value="${(user.departmentId)!''}">${departmentName}</option>
                                </#if>
                                <#list departments as department>
                                    <option value="${department.departmentId}">${department.departmentName}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"> <span>性别</span>
                                </label> <select class="form-control" name="sex" >
                                <#if user.sex??>
                                <option value="${user.sex}">${user.sex}</option>
                                </#if>
                                <option value="男">男</option>
                                <option value="女">女</option>

                            </select>
                            </div>


                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>工资</span></label> <input
                                    name="salary" class="form-control" value="${(user.salary)!''}"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"> <span>角色</span>
                                </label> <select class="form-control" name="role">
                            <#if idCheck != 0>
                                <option value="${(user.role.roleId)!''}">${user.role.roleName}</option>
                            </#if>
                            <#list roles as role>
                                <option value="${role.roleId}">${role.roleName}</option>
                            </#list>
                               <#-- <option value="1">领导</option>
                                <option value="2">管理员</option>
                                <option value="3">员工</option>-->
                            </select>
                            </div>


                        <#if where??>
                        <#else>
                            <div class="col-md-6 form-group">
									<span> <label class="control-label">入职时间</label>
									</span> <input name="hireTime" class="form-control" id="start"
                                                   onclick="WdatePicker()"
                                                   value="${(user.hireTime?string("yyyy-MM-dd HH:mm:ss"))!''}"/>
                            </div>
                        </#if>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>密码</span></label> <input
                                    name="password" class="form-control" value="${(user.password)!''}"/>
                            </div>
                            <input type="hidden" name="userId" value="${(user.userId)!''}"/>
                        </div>

                    </div>
                </div>
                <!--盒子尾-->
                <div class="box-footer">
                    <input class="btn btn-primary" id="save" type="submit" value="保存"/>
                    <input class="btn btn-default" id="cancel" type="button" value="取消"
                           onclick="window.history.back();"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="plugins/My97DatePicker/WdatePicker.js"></script>
<#include "/common/modalTip.ftl"/>
