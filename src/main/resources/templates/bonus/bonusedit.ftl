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
        <h1 style="font-size: 24px; margin: 0;" class="">奖金标准管理</h1>
    </div>
    <div class="col-md-10 text-right">
        <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> >
        <a disabled="disabled">奖金标准管理</a>
    </div>
</div>
<div class="row" style="padding-top: 15px;">
    <div class="col-md-12">
        <!--id="container"-->
        <div class="bgc-w box">
            <form action="bonusedit" method="post" onsubmit="return check();">
                <!--盒子头-->
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
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>标准内容</span></label>
                                <input class="form-control text" name="bonusContent" value="${(bonus.bonusContent)!''}" />
                            </div>
                        </div>

                        <div class="hidden">
                            <div class="col-md-6 form-group">
                                <label class="control-label"><span>id</span></label>
                                <input name="bonusId" class="form-control" value="${(bonus.bonusId)!''}"/>
                            </div>
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
</body>
<#include "/common/modalTip.ftl"/>
<#if isread??>
<script type="text/javascript">
    $('.form-control').attr("readOnly", "true");
</script>
</#if>
</html>