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
            background-image:url(lake.jpg);
             background-size:100vw 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        form{
            width : 25vw;
            height:76vh;
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
            letter-spacing: 3px;
            
            
         }
       
       #button{
        width: 10vw;
        background-color:cornflowerblue ;
       }
       #button:hover{
        background-color: maroon;
        cursor: pointer;
       }
     
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="statement" method="post">
<h3>From</h3> <input type="date"  name="input1" required="required"> <h3>To</h3><input  type="date" name="input2" required="required">
<input type="submit" value="Statement" id="button">
</form>

</body>
</html>