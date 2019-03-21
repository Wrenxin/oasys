<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
<#include "/common/commoncss.ftl">
    <link rel="stylesheet" type="text/css"
          href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/common/box.css"/>
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
</head>

<body style="background-color: #ecf0f5;">
<div class="row" style="padding-top: 10px;">
    <div class="col-md-2">
        <h1 style="font-size: 24px; margin: 0;" class="">个人信息</h1>
    </div>
    <div class="col-md-10 text-right">
        <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> >
        <a disabled="disabled">个人信息</a>
    </div>
</div>
<div class="row" style="padding-top: 15px;">
    <div class="col-md-12">
        <!--id="container"-->
        <div class="bgc-w box">
            <form action="personalupdatet" method="post" onsubmit="return check();">

                <!--盒子身体-->
                <div class="box-body no-padding">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label1">用户名</span></label> <input
                                    name="userName" type="text" value="${user.userName}" readonly="readonly"
                                    id="ctl00_cphMain_txtName" class="form-control" style="background-color:#fff;"
                                    onfocus="this.blur()"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label2">电话</span></label> <input
                                    name="userTel" type="text" value="${(user.userTel)!''}"
                                    id="ctl00_cphMain_txtPhone1" class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label3">真实姓名</span></label> <input
                                    name="realName" type="text" value="${user.realName}"
                                    id="ctl00_cphMain_txtFullName" class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label5">Email</span></label> <input
                                    name="eamil" type="text"
                                    value="${(user.eamil)!''}" id="ctl00_cphMain_txtEmail1"
                                    class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label10">地址</span></label> <input
                                    name="address" type="text" value="${(user.address)!''}"
                                    id="ctl00_cphMain_txtAddress1" class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label6">学历</span></label> <input
                                    name="userEdu" type="text" value="${user.userEdu}"
                                    id="ctl00_cphMain_txtEducation" class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label7">毕业院校</span></label> <input
                                    name="school" type="text" value="${user.school}"
                                    id="ctl00_cphMain_txtSchool" class="form-control"/>
                            </div>

                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="icard">身份证号</span></label> <input
                                    name="idCard" type="text"
                                    value="${user.idCard}" id="ic"
                                    class="form-control"/>
                            </div>
                            <div class="hidden">
                                <div class="col-md-6 form-group">
                                    <label class="control-label"><span>id</span></label>
                                    <input name="userId" class="form-control" value="${(user.userId)!''}"/>
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="ctl00_cphMain_Label16">性别</span></label> <select
                                    name="sex" id="ctl00_cphMain_ddlSex"
                                    class="form-control select2">
                                <option value="${user.sex}">${user.sex}</option>
                            <#if user.sex=="男">
                                <option value="女">女</option>
                            </#if>
                            <#if user.sex=="女">
                                <option value="男">男</option>
                            </#if>
                            </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span id="icard">密码</span></label> <input
                                    name="password" type="text"
                                    value="${user.password}" id="pw"
                                    class="form-control"/>
                            </div>
                        </div>
                    </div>

                </div>
                <!--盒子尾-->
                <div class="box-footer" style="position: relative; overflow: hidden;">
                    <input type="submit" name="ctl00$cphMain$btnSave" value="保存"
                           id="ctl00_cphMain_btnSave" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<#include "/common/modalTip.ftl"/>
<#if isread??>
<script type="text/javascript">
    $('.form-control').attr("readOnly", "true");
</script>
</#if>
</html>