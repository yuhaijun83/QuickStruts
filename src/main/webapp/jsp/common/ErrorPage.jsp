<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./html_Head.jsp" %>

<html lang="zh-CN">
    <head>
        <%@ include file="./head_Top.jsp" %>
        <title>【XXXXX】错误信息页面</title>
        <%@ include file="./head_Middle.jsp" %>
        <%@ include file="./head_Bottom.jsp" %>
    </head>
    
    <body>
        <s:form id="ErrorPageFormID" method="post" action="/ErrorPageAction.action" theme="simple">
            <s:hidden id="scrActionID" name="scrActionID" value="ErrorPageAction" />
            
            <div class="container" role="main">
                <br/>
                <br/>

                <s:if test="messageType != ''"> 
                    <div id="messageID" >
                        <div class="alert alert-<s:property value="messageType"/> alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <ul>
                                <s:iterator value="lstMessage" status="status">
                                    <li><s:property value="message" /></li>
                                </s:iterator>
                            </ul>
                        </div>
                    </div>
                </s:if>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h1 class="panel-title">错误信息页面</h1>
                    </div>
    
                    <div class="text-center spacer30">
                        <a href="<%=path%>/XXXX/XXXXXXAction.action" class="btn btn-default btn-lg" id="submitID">再登录</a>&nbsp;&nbsp;
                        <button type="button" id="returnID" name="btnReturn" class="btn btn-primary btn-lg" onClick="javascript:history.back()">返&nbsp;&nbsp;回</button>
                    </div>
                    <div class="text-center spacer30"></div>
                </div>
                
            </div>
        </s:form>
    </body>

    <%@ include file="./html_Bottom.jsp" %>
    <script type="text/javascript">
    <!--
    //-->
    </script>
</html>