<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./common/html_Head.jsp" %>

<html lang="zh-CN">
	<head>
        <%@ include file="./common/head_Top.jsp" %>
		<title>【XXXXX】XXXXX</title>
        <%@ include file="./common/head_Middle.jsp" %>
        <link rel="stylesheet" href="../assets/css/sample.css?v=1.0.0" />
        <style type="text/css"></style>
        <%@ include file="./common/head_Bottom.jsp" %>
	</head>
    
	<body>

		<s:form id="SampleFormID" method="post" action="./XXXXX/SampleAction.action" theme="simple">
            <s:hidden id="scrActionID" name="scrActionID" value="SampleAction" />
            <s:hidden id="fatherForwardID" name="fatherForward" />
            
			<div class="container" role="main">









			</div>

		</s:form>
        <%-- post送信用 Start --%>
        <form id="hiddenFormID" name="getToPost" action="" method="post" autocomplete="off">
            <input type="hidden" id="fatherForwardHidId" name="fatherForward" value="" >
        </form>
        <%-- post送信用 End --%>
	</body>
    <%@ include file="./common/html_Bottom.jsp" %>
    <script src="<%=path %>/assets/js/process/sample.js?v=1.0.0"></script>
	<script type="text/javascript">
    <!--
    //-->
	</script>
</html>