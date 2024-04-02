<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
        *   
        {
            padding: 0;
            margin: 0;
        }
        body{
            width: 100vw;
            height: 100vh;
            background-image:url(snow.jpg);
            background-size:100vw 100vh;
            display: flex;
            flex-direction:column;
            justify-content: center;
            align-items: center;
        }
        form{
            width: 30%;
            height: 80%;
           background-color:transparent;
            border: 2px black solid;
            border-radius: 30px;
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            flex-direction: column;
        }
         input{
            width: 20vw;
            height: 3vw;
            border: none;
            outline: none;
            font-size: 1vw;
            text-align: center;
            border-radius: 10px;
            letter-spacing: 4px;
         }
       
       #button{
        width: 10vw;
        background-color: cornflowerblue;
       }
       #button:hover{
        background-color: graytext;
        cursor: pointer;
       }
     
    </style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="registration" method="post">
<h1>User Registration</h1>
<input placeholder="Enter Your Name" name="name">
<input placeholder="Enter Your EmailId" name="id">
<input placeholder="Enter Your Mobile Number" name="mobileNumber">
<input placeholder="Enter Your Password" name="pass">
<input placeholder="Enter Your Address" name="address">
<input type="submit" value="Registration" id="button">
</form>


</body>
</html>