<%@page import="com.ebanking.model.BankUserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

#i1{
    height: 3pc;
    width: 10pc;
    margin-inline-start: auto;
    margin-top: 11pc;
    border-radius: 0.3pc;
    background-color:transparent;
    border: 2px solid black;
}
#i2{
    height: 3pc;
    width: 10pc;
    margin-inline-start: auto;
    margin-bottom: 18pc;
    border-radius: 0.3pc;
    background-color:transparent;
      border: 2px solid black;
}
body{
     width:100vw;
     height:100vh;
    background-image: url(snowfall.jpg);
    background-size: 100vw 100vh;
}
h3{
   position: relative;
   left: 35pc;
}
button{
cursor:pointer;
}

 
     
           
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% 
    
     BankUserDetails bankUserDetails = (BankUserDetails) session.getAttribute("BankUserDetails");
       String name=bankUserDetails.getUsername();
       String number=bankUserDetails.getAccountnumber();
        String newSubString=number.substring(2, 5);
        number=number.replace(newSubString, "***");
    %>
   
   <% if(name!=null) 
        {%>
        <center>
      <h1 id="name">Welcome Mr.<%=name%> </h1>
       <h1 id="accountNumber">Account Number : <%= number %> </h1>
       
   
       <div>
        <a href="Debit.jsp" ><button id="i1"><b>Withdraw Amount</b></button></a>
        &nbsp;&nbsp;
   <a href="Credit.jsp"><button id="i1"><b>Credit Amount</b></button></a>&nbsp;
   <br>&nbsp;
   </div>
   
   <div>
   <a href="Statment.jsp"><button id="i2"><b>Check Statement</b></button></a>&nbsp;
   &nbsp;&nbsp;
   <a href="ChangePassword.jsp"><button id="i2"><b>Change Password</b></button></a>
   </div>
   </center>

     <%} %>
     
    	     
</body>
</html>