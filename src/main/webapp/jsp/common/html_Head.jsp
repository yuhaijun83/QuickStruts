<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
    String path = request.getContextPath();
    String basePath = "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + path; 
    String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ taglib uri="/struts-tags" prefix="s" %>