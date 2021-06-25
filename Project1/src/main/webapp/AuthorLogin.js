const URL = "http://localhost:8080/Project1/controller";

// Add event listener
document.getElementById("login-button").addEventListener("click", login);

function login() {
  console.log("button is clicked");

  let authorCred = {
    user: document.getElementById("username").value,
    pass: document.getElementById("password").value,
  };

  jsonCred = JSON.stringify(authorCred);
  console.log(jsonCred);

  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = recieveData;

  xhttp.open("POST", URL + "/author-login", true);
  xhttp.send(jsonCred);

  function recieveData() {
    console.log(authorCred.user, authorCred.pass);
    console.log("hit");
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        console.log("success");
        console.log(xhttp.responseText);
        window.location.href = xhttp.responseText;
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}
