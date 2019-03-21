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
        <h1 style="font-size: 24px; margin: 0;" class="">考勤查看</h1>
    </div>
    <div class="col-md-10 text-right">
        <a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
            disabled="disabled">考勤查看</a>
    </div>
</div>
<div class="row" style="padding-top: 15px;">
	<div class="col-md-12">
		<!--id="container"-->
		<div class="bgc-w box box-primary">
			<!--盒子身体-->
			<div class="box-body no-padding">
				<div class="table-responsive">
					<table class="table table-hover table-striped">
						<tr>
							<th scope="col">姓名</th>
							<th scope="col">时间</th>
							<th scope="col">ip</th>
                            <th scope="col">状态</th>
						</tr>
						<#list signs as sign>
							<tr>
								<td><span>${sign.signName}</span></td>
								<td><span>${sign.signTime}</span></td>
								<td><span>${sign.signIp}</span></td>
                                <td><span>${sign.signType}</span></td>

							</tr>
						</#list>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
