<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>
<p>
    Username : ${currentUser.username}
    <br>
    First Name : ${currentUser.firstName}
    <br>
    Last Name : ${currentUser.lastName}
    <br>
    Email : ${currentUser.email}
    <br>
    Phone Number : ${currentUser.phoneNumber}
    <br>
    Address : ${currentUser.address}
    <br>
    Gender : ${currentUser.isMan ? "Male" : "Female"}

</p>