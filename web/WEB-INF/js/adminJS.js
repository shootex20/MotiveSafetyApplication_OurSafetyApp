/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
function checkPasswordMatch() {
    var password = $("#password").val();
    var confirmPassword = $("confirmPassword").val();
    
    if (password != confirmPassword)
    $("#doPasswordsMatch").html("Passwords do not match");
    else 
        $("#doPasswordsMatch").html("Password do match");
    
    
}


$(document).ready(function () {
    $("#password, confirmPassword").keyup(checkPasswordMatch);
});

/**
    var input, filter, table, tr,td, inputvalue;
    
    input = document.querySelector("searchbycompname");
    input.addEventListener("keyup", function(e){
        console.log(e.target.value);
    })

 /**   function mySearchFunction() {
    inputM = document.getElementById("searchbycompname");
    filter = input.value.toUpperCase();
    table = document.getElementById("companyTable")
    tr = table.getElementsByTagName("tr");
    
    // loop thru table
    for (var i = 0; i< tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            inputvalue = td.textContent || td.innerText;
            if (inputvalue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
        
        
    }**/

