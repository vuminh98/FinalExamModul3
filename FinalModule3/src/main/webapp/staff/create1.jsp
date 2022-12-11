<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/11/2022
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>

  .get-in-touch {
    max-width: 800px;
    margin: 50px auto;
    position: relative;

  }
  .get-in-touch .title {
    text-align: center;
    text-transform: uppercase;
    letter-spacing: 3px;
    font-size: 3.2em;
    line-height: 48px;
    padding-bottom: 48px;
    color: #5543ca;
    background: #5543ca;
    background: -moz-linear-gradient(left,#f4524d  0%,#5543ca 100%) !important;
    background: -webkit-linear-gradient(left,#f4524d  0%,#5543ca 100%) !important;
    background: linear-gradient(to right,#f4524d  0%,#5543ca  100%) !important;
    -webkit-background-clip: text !important;
    -webkit-text-fill-color: transparent !important;
  }

  .contact-form .form-field {
    position: relative;
    margin: 32px 0;
  }
  .contact-form .input-text {
    display: block;
    width: 100%;
    height: 36px;
    border-width: 0 0 2px 0;
    border-color: #5543ca;
    font-size: 18px;
    line-height: 26px;
    font-weight: 400;
  }
  .contact-form .input-text:focus {
    outline: none;
  }
  .contact-form .input-text:focus + .label,
  .contact-form .input-text.not-empty + .label {
    -webkit-transform: translateY(-24px);
    transform: translateY(-24px);
  }
  .contact-form .label {
    position: absolute;
    left: 20px;
    bottom: 11px;
    font-size: 18px;
    line-height: 26px;
    font-weight: 400;
    color: #5543ca;
    cursor: text;
    transition: -webkit-transform .2s ease-in-out;
    transition: transform .2s ease-in-out;
    transition: transform .2s ease-in-out,
    -webkit-transform .2s ease-in-out;
  }
  .contact-form .submit-btn {
    display: inline-block;
    background-color: #000;
    background-image: linear-gradient(125deg,#a72879,#064497);
    color: #fff;
    text-transform: uppercase;
    letter-spacing: 2px;
    font-size: 16px;
    padding: 8px 16px;
    border: none;
    width:200px;
    cursor: pointer;
  }


</style>
<section class="get-in-touch">
  <h1 class="title">Create Form</h1>
  <form class="contact-form row" method="post">
    <div class="form-field col-lg-6">
      <input id="name" class="input-text js-input" type="text" name="name" required>
      <label class="label" for="name">Name</label>
    </div>
    <div class="form-field col-lg-6 ">
      <input id="email" class="input-text js-input" type="email" name="email" required>
      <label class="label" for="email">E-mail</label>
    </div>
    <div class="form-field col-lg-6 ">
      <input id="company" class="input-text js-input" type="text" name="address" required>
      <label class="label" for="company">Address</label>
    </div>
    <div class="form-field col-lg-6 ">
      <input id="phone" class="input-text js-input" type="text" name="phonenumber" required>
      <label class="label" for="phone">Contact Number</label>
    </div>
    <div class="form-field col-lg-6">
      <input id="message" class="input-text js-input" type="text" name="salary" required>
      <label class="label" for="message">Salary</label>
    </div>
    <div class="form-field col-lg-6">
      <label for="department" class="label">Department</label>
      <select class="input-text js-input" id="department" name="department" style="border-radius:25px">
        <option></option>
        <c:forEach items="${departments}" var="d">
          <option value="${d.getId()}"><c:out value="${d.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
    <div class="form-field col-lg-12">
      <input class="submit-btn" type="submit" value="Submit">
    </div>
  </form>
</section>
</body>
</html>
