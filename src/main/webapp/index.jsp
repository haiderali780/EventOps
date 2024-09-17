<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <script src="formvalidation.js"></script>
    <title>Modern Login Page | AsmrProg</title>
    <style>
        .error-message {
            color: red;
        }
        .success-message {
            color: green;
        }
    </style>
</head>

<body>

    <div class="container <%= request.getAttribute("formType") != null && "signUp".equals(request.getAttribute("formType")) ? "active" : "" %>" id="container">
        <div class="form-container sign-up">
            <form action="SignUp" method="post">
                <h1>Create Account</h1>
                
                <input type="text" placeholder="Name"  name="name" id="username" required >
                <input type="password" placeholder="Password"  name="password" id="password" required >
                <label>
                    <input type="radio" name="userType" value="regular" checked> Regular User
                </label>
                <label>
                    <input type="radio" name="userType" value="admin"> Admin
                </label>
                <input type="submit" value="Sign Up">
                <% String signupErrorMessage = (String) request.getAttribute("signupErrorMessage");
                   if (signupErrorMessage != null) { %>
                    <p class="error-message"><%= signupErrorMessage %></p>
                <% } %>
                <% String signupSuccessMessage = (String) request.getAttribute("signupSuccessMessage");
                   if (signupSuccessMessage != null) { %>
                    <p class="success-message"><%= signupSuccessMessage %></p>
                <% } %>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="SignIn" method="post" >
                <h1>Sign In</h1>
                <input type="text" placeholder="username" name="name" id="uname" required>
                <input type="password" placeholder="Password" name="password" id="pass" required>
                <label>
                    <input type="radio" name="usertype" value="regular" checked> Regular User
                </label>
                <label>
                    <input type="radio" name="usertype" value="admin"> Admin
                </label>
                <input type="submit" value="Sign In">
                <% String loginErrorMessage = (String) request.getAttribute("loginErrorMessage");
                   if (loginErrorMessage != null) { %>
                    <p class="error-message"><%= loginErrorMessage %></p>
                <% } %>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    <input type="button" class="hidden" id="login" value="Sign In">
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Friend!</h1>
                    <p>Register with your personal details to use all of site features</p>
                    <input type="button" class="hidden" id="register" value="Sign Up">
                </div>
            </div>
        </div>
    </div>

    <script>
        const container = document.getElementById('container');
        const registerBtn = document.getElementById('register');
        const loginBtn = document.getElementById('login');

        registerBtn.addEventListener('click', () => {
            container.classList.add("active");
        });

        loginBtn.addEventListener('click', () => {
            container.classList.remove("active");
        });
    </script>
</body>

</html>
