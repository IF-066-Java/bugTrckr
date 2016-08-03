<%--
  User: ihorlt
  Date: 20.07.16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<header class="topbar container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <ul class="left-topbar">
                <li>Agile Software - An essential tool for a project developer</li>
            </ul>
        </div>
        <div class="col-sm-6 col-md-6">
            <div class="row">
                <ul class="right-topbar">

                    <c:if test="${not empty loginForm.email}">
                        <div class="col-sm-6 col-sm-offset-4">
                            <li>Signed in as ${loginForm.email}</li>
                        </div>
                        <div class="col-sm-2">
                            <li>
                                <form:form commandName="logoutForm" modelAttribute="loginForm" class="form-inline"
                                           action="?logout" method="POST">
                                    <input class="btn btn-default btn-sm" type="submit" value="Logout"/>
                                </form:form>
                            </li>
                        </div>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</header>
