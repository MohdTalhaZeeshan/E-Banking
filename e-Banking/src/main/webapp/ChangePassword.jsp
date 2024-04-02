<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style >
*   
        {
            padding: 0;
            margin: 0;
        }
        body{
            width: 100vw;
            height: 100vh;
            background-image:url(river.jpg);
            background-size: 100vw 100vh;
            display: flex;
            flex-direction:column;
            justify-content: center;
            align-items: center;
        }
        form{
            width: 25%;
            height: 70%;
            background-color: transparent;
            border: 3px black solid;
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
        background-color: orange;
       }
       #button:hover{
        background-color:graytext;
        cursor: pointer;
       }
       </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="changepassword" method="post">
 <input placeholder="Enter Your Email" name="mailId" required="required">
 <input placeholder="Enter Your accountNumber" name="accNumber" required="required">
 <input placeholder="Enter New Password" name="pass" required="required">
 <input type="submit" id="button">
</form>


</body>
</html>