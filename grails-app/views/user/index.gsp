<%@ page import="com.timeshots.blacklabel.onlinedirectory.User" %>
<!DOCTYPE html>
<html>
	<head>
	    <r:require modules="bootstrap"/>
        <r:require modules="bootstrap-modal"/>
		<meta name="layout" content="main">
		<title></title>
		<style type="text/css">
		    label{
		        float:left;
		        width:65px;
		    }
		</style>
	</head>
	<body>
        <g:if test="${flash.message}">
            <div class="message">
                ${flash.message}
            </div>
        </g:if>

		<g:form controller="user" action="login" style="padding-left:200px">
			<div style="width:300px">
	            Username :<br/><input type="text" name="username" /><br/>
	            Password :<br/><input type="password" name="password" />
	            <br/><input type="submit" value="Login" />
			</div>
		</g:form>

		<g:if test="${session.user}">
            <br/>
            <div class="message">
                Login as : ${session.user} : <g:link controller="user" action="logout">Logout</g:link>
            </div>
        </g:if>
    </body>
</html>