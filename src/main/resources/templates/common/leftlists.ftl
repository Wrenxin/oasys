<#if user.role.roleId==3>
<div class="panel-group" id="accordion"
     style="margin-top: 10px; margin-left: -12px;">

    <div class="panel panel-default">
        <#list oneMenuAll as one>
            <#if one.menuId==2>
                <div class="panel-heading">
                    <a class="open-menu green-left" href="#collapse${one.menuId}" data-toggle="collapse"
                       data-parent="#accordion"> <span
                            class="glyphicon ${one.menuIcon}"></span> <span>${one.menuName}</span> <span
                            class="glyphicon glyphicon-menu-left pull-right"></span>
                    </a>
                </div>
                <div id="collapse${one.menuId}" class="panel-collapse collapse ">
                    <ul>
                        <#list twoMenuAll as two>
                            <#if two.sortId==1||two.sortId==2>
                                <#if one.menuId==two.parentId>

                                    <#if two.menuUrl??>
                                        <li>
                                            <a href="javascript:changepath('${two.menuUrl}');"> <span
                                                    class="glyphicon ${two.menuIcon}"></span>
                                                <span>${two.menuName}</span>
                                            </a>
                                        </li>

                                    <#else>
                                        <li>
                                            <a href="#"> <span
                                                    class="glyphicon ${two.menuIcon}"></span>
                                                <span>${two.menuName}</span>
                                            </a>
                                        </li>
                                    </#if>
                                </#if>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        </#list>
    </div>
</div>
<script>
    $(function () {
        $(".chazhao").click(function () {
            var $val = $(".cha").val();
            $(".thistable").load("menucha", {val: $val});
        });
    })
</script>
</#if>
<#if user.role.roleId==1>
<div class="panel-group" id="accordion"
     style="margin-top: 10px; margin-left: -12px;">

    <div class="panel panel-default">
        <#list oneMenuAll as one>
            <#if one.menuId==6>
                <div class="panel-heading">
                    <a class="open-menu green-left" href="#collapse${one.menuId}" data-toggle="collapse"
                       data-parent="#accordion"> <span
                            class="glyphicon ${one.menuIcon}"></span> <span>${one.menuName}</span> <span
                            class="glyphicon glyphicon-menu-left pull-right"></span>
                    </a>
                </div>
                <div id="collapse${one.menuId}" class="panel-collapse collapse ">
                    <ul>
                        <#list twoMenuAll as two>
                            <#if one.menuId==two.parentId>
                                <#if two.menuUrl??>
                                    <li>
                                        <a href="javascript:changepath('${two.menuUrl}');"> <span
                                                class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
                                        </a>
                                    </li>

                                <#else>
                                    <li>
                                        <a href="#"> <span
                                                class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
                                        </a>
                                    </li>
                                </#if>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        </#list>
    </div>
</div>
<script>
    $(function () {
        $(".chazhao").click(function () {
            var $val = $(".cha").val();
            $(".thistable").load("menucha", {val: $val});
        });
    })
</script>
</#if>
<#if user.role.roleId==2>

<div class="panel-group" id="accordion"
     style="margin-top: 10px; margin-left: -12px;">

    <div class="panel panel-default">
        <#list oneMenuAll as one>
            <#if one.menuId==2||one.menuId==8>
                <div class="panel-heading">
                    <a class="open-menu green-left" href="#collapse${one.menuId}" data-toggle="collapse"
                       data-parent="#accordion"> <span
                            class="glyphicon ${one.menuIcon}"></span> <span>${one.menuName}</span> <span
                            class="glyphicon glyphicon-menu-left pull-right"></span>
                    </a>
                </div>
                <div id="collapse${one.menuId}" class="panel-collapse collapse ">
                    <ul>
                        <#list twoMenuAll as two>
                            <#if one.menuId==two.parentId>
                                <#if two.menuUrl??>
                                    <li>
                                        <a href="javascript:changepath('${two.menuUrl}');"> <span
                                                class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
                                        </a>
                                    </li>

                                <#else>
                                    <li>
                                        <a href="#"> <span
                                                class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
                                        </a>
                                    </li>
                                </#if>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        </#list>
    </div>
</div>
<script>
    $(function () {
        $(".chazhao").click(function () {
            var $val = $(".cha").val();
            $(".thistable").load("menucha", {val: $val});
        });
    })
</script>
</#if>
