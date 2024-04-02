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
           background-image:url(sea.jpg);
           background-size:100vw 100vh;
            display: flex;
            flex-direction:column;
            justify-content: center;
            align-items: center;
        }
        form{
            width: 25%;
            height: 75%;
            background-color: transparent;
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
        background-color: gray;
       }
       #button:hover{
        background-color: olive ;
        cursor: pointer;
       }
     
    </style>

</head>
<body>

<form action="login" method="post">
<h1>User Login</h1>
<input placeholder="Enter Your EmailId or MobileNumber" name="login"  required="required">
<input placeholder="Enter Your Password" name="password" required="required">
<input type="submit" value="Login" id="button">
<div><a href="UserRegistration.jsp">New Account?</a></div>
</form>

</body>
</html>
