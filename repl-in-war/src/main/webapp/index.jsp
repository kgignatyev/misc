<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="kgi.repro.repl_in_war.ReplService" %>
REPL should be here


<%
    ReplService repl =  WebApplicationContextUtils.getRequiredWebApplicationContext(application).getBean(ReplService.class)
%>

<%= repl.interpret("var a = 123 ")%>