<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Web</title>
</head>
<body>
    <style>
    *{
        font-family: Arial, sans-serif;
        box-sizing: border-box;
        margin: 0;
        margin-top : 20px;
        padding: 0;
    }
    table {
        width: 50%;
        margin: 20px auto;
        border-collapse: collapse;
        text-align: center;
    }
    th{
        background-color: rgba(74, 170, 233, 1);
    }
    tr{
        height: 40px;
    }
    tr:nth-child(odd) {
        background-color: rgba(185, 215, 235, 0.2);
    }

    .btn{
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
    .button{
       padding: 10px 20px;
       margin: 10px;
       background-color: rgba(5, 145, 238, 1);
       color: white;
       border: none;
       border-radius: 5px;
    }

    .form{
        background-color: rgba(185, 215, 235, 0.2);
        padding: 20px;
        margin-top: 20px;
        max-width: 30%;
        margin-left: auto;
        margin-right: auto;

    }
    .form form{
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .form form input{
        padding:10px;
        width: 80%;
        margin-bottom: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }
    </style>

    <center><h1>Spring Web</h1></center>

    <c:choose>
        <c:when test="${empty data}">
            <center><h2>No data available</h2></center>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
                <c:forEach items="${data}" var="student" varStatus="status">
                    <tr key="${status.index}">
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <div class="btn">
        <button onclick="toggleFormUpdate()" class="button">Update Data</button>
        <button onclick="toggleForm()" class="button">Insert Data</button>
        <button onclick="deleteData()" class="button">Delete Data</button>
    </div>

    <div class="form" id="insertForm" style="display: none;">
        <form action="add" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
            <label for="age">Age:</label>
            <input type="number" id="age" name="age">
            <div class="btn">
                <button type="submit" class="button">Add</button>
                <button type="button" onclick="toggleForm()" class="button">Cancel</button>
            </div>
        </form>
    </div>

    <div class="form" id="updateForm" style="display: none;">
        <form action="update" method="post">
            <label for="id">ID:</label>
            <input type="number" id="id" name="id">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
            <label for="age">Age:</label>
            <input type="number" id="age" name="age">
            <div class="btn">
                <button type="submit" class="button">Update</button>
                <button type="button" onclick="toggleFormUpdate()" class="button">Cancel</button>
            </div>
        </form>
    </div>

    <div class="form" id="deleteForm" style="display: none;">
        <form action="delete" method="post">
            <label for="id">ID:</label>
            <input type="number" id="id" name="id">
            <div class="btn">
                <button type="submit" class="button">delete</button>
                <button type="button" onclick="toggleFormUpdate()" class="button">Cancel</button>
            </div>
        </form>
    </div>


    <script>
        let isUpdate = false;
        function toggleForm(){
            console.log("clicked");
            const form = document.querySelector('#insertForm');
            if(form.style.display === "none"){
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }

        function toggleFormUpdate(){
            isUpdate = true;
            console.log("Update clicked");
            const form = document.querySelector('#updateForm');
            if(form.style.display === "none"){
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }

        function deleteData(){
            console.log("Delete clicked");
            const form = document.querySelector('#deleteForm');
            if(form.style.display === "none"){
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
    </script>

</body>
</html>
