const URL = "http://localhost:8080/Project1/controller";

const getStory = () => {
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = recieveData;

  xhttp.open("GET", URL + "/employee-screen", true);
  xhttp.send();

  function recieveData() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        let r = xhttp.response;
        rr = r.replace("EmployeeLogin.html", "");
        employee = JSON.parse(rr);
        console.log(employee);
        populateData(employee);
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
};

let penBtn = document.getElementById("austat");
penBtn.addEventListener("submit", (ev) => {
  updateStatus(ev);
});

window.onload = getStory();

function populateData(em) {
  let prioExists = false;
  let storySection = document.getElementById("stories");
  let eType = em.type;

  // Employee Welcome
  let authorWelcome = document.createElement("h2");
  authorWelcome.innerHTML = " Welcome: " + em.firstname + " " + em.lastname;
  authorWelcome.setAttribute("class", "author-welcome");
  storySection.appendChild(authorWelcome);

  let mattArray = [];
  mattArray.push(em.story);
  if (em.story2 != null) {
    mattArray.push(em.story2);
  }
  if (em.story3 != null) {
    mattArray.push(em.story3);
  }

  console.log(mattArray);

  // finding if any statuses are high prio
  mattArray.map((st) => {
    if (st.story_status.priority) {
      prioExists = true;
    }
  });

  //Employee Genres
  let authorGenreBox = document.createElement("div");
  authorGenreBox.setAttribute("class", "author-box");
  storySection.appendChild(authorGenreBox);

  let genArr = [];
  genArr.push(em.genrename);
  genArr.map((g) => {
    let geEl = document.createElement("h4");
    geEl.innerHTML = "Employee Genre: " + "" + g;
    geEl.setAttribute("class", "genre");
    authorGenreBox.appendChild(geEl);
  });

  // Employee Type
  let eeType = document.createElement("h3");
  eeType.innerHTML = em.type + " editor";
  storySection.appendChild(eeType);

  // Stories Container
  let storiesContainer = document.createElement("div");
  storiesContainer.setAttribute("class", "sto-container");
  storySection.appendChild(storiesContainer);

  mattArray.map((st) => {
    // Story Container
    let stoBox = document.createElement("div");
    stoBox.setAttribute("class", "sto-box");

    // Story Title
    let stoTitle = document.createElement("h3");
    stoTitle.innerHTML = "Title: " + " " + st.title;
    stoTitle.setAttribute("class", "sto-title");
    stoBox.appendChild(stoTitle);

    // Story Tagline
    let stoTagline = document.createElement("h5");
    stoTagline.innerHTML = "Tagline: " + " " + st.tagline;
    stoTagline.setAttribute("class", "sto-tagline");
    stoBox.appendChild(stoTagline);

    // Story description
    let stoDescription = document.createElement("p");
    stoDescription.innerHTML = "Description: " + " " + st.description;
    stoDescription.setAttribute("class", "sto-description");
    stoBox.appendChild(stoDescription);

    // Story completionDate
    let stoCompletionDate = document.createElement("p");
    stoCompletionDate.innerHTML = "Submit Date: " + st.submit_date;
    stoCompletionDate.setAttribute("class", "sto-completion-date");
    stoBox.appendChild(stoCompletionDate);

    // Story genre
    let stoGenre = document.createElement("p");
    stoGenre.innerHTML = "Genre: " + " " + st.genre;
    stoGenre.setAttribute("class", "sto-genre");
    stoBox.appendChild(stoGenre);

    // Story weight
    let nstoryType = st.story_type;
    if (nstoryType == 1) {
      nstoryType = "Novel";
    } else if (nstoryType == 2) {
      nstoryType = "Novella";
    } else if (nstoryType == 3) {
      nstoryType = "Short Story";
    } else if (nstoryType == 4) {
      nstoryType = "Article";
    }
    let stoWeight = document.createElement("p");
    stoWeight.innerHTML = "Type: " + " " + nstoryType;
    stoWeight.setAttribute("class", "sto-genre");
    stoBox.appendChild(stoWeight);

    //Senior Editor Edit Story form
    console.log(st);
    if (em.type === "senior" && st.story_type == 1) {
      let editForm = document.createElement("form");
      editForm.setAttribute("id", "editForm");
      editForm.setAttribute("name", "eForm");
      editForm.addEventListener("submit", (e) => updateStory(e, st));
      stoBox.appendChild(editForm);

      let newTitle = document.createElement("input");
      newTitle.setAttribute("type", "text");
      newTitle.setAttribute("id", "titleInput");
      newTitle.setAttribute("placeholder", "New Title:");
      newTitle.setAttribute("name", "tInput");
      editForm.appendChild(newTitle);

      let newTagline = document.createElement("input");
      newTagline.setAttribute("type", "text");
      newTagline.setAttribute("id", "taglineInput");
      newTagline.setAttribute("placeholder", "New Tagline:");
      newTagline.setAttribute("name", "tagInput");
      editForm.appendChild(newTagline);

      let newDesc = document.createElement("textarea");
      newDesc.setAttribute("cols", 30);
      newDesc.setAttribute("rows", 5);
      newDesc.setAttribute("placeholder", "Type New Description Here:");
      newDesc.setAttribute("name", "dInput");
      newDesc.setAttribute("id", "descInput");
      editForm.appendChild(newDesc);

      let editbtn = document.createElement("button");
      editbtn.innerHTML = "Update Story";
      editbtn.setAttribute("type", "submit");
      editbtn.setAttribute("id", "editbtn");
      editbtn.setAttribute("class", "login_link");
      editForm.appendChild(editbtn);
    }

    //Request Additional Info
    let infoForm = document.createElement("form");
    infoForm.setAttribute("id", "infoForm");
    infoForm.setAttribute("name", "iForm");
    infoForm.addEventListener("submit", (e) => updateStatusInfo(e, st));
    stoBox.appendChild(infoForm);

    let info = document.createElement("textarea");
    info.setAttribute("cols", 30);
    info.setAttribute("rows", 5);
    info.setAttribute("placeholder", "Request Info Here:");
    info.setAttribute("name", "infoText");
    info.setAttribute("id", "info");
    infoForm.appendChild(info);

    let infobtn = document.createElement("button");
    infobtn.innerHTML = "Request Info";
    infobtn.setAttribute("type", "submit");
    infobtn.setAttribute("class", "login_link");
    infobtn.setAttribute("id", "infobtn");
    infoForm.appendChild(infobtn);

    // -----------------------------------------
    // Status Object
    let sta = st.story_status;
    let staBox = document.createElement("div");
    staBox.setAttribute("class", "sta-box");

    // Status Header
    let staHeader = document.createElement("h3");
    staHeader.innerHTML = "STATUS";
    staBox.appendChild(staHeader);

    // Status
    let staStatus = document.createElement("h5");
    staStatus.innerHTML = "Status: " + " " + sta.status;
    staStatus.setAttribute("class", "sto-tagline");
    staBox.appendChild(staStatus);

    // Priority
    let staPriority = document.createElement("h5");

    if (sta.priority) {
      staPriority.innerHTML = "High Priority";
      staPriority.setAttribute("class", "sta-priority-high");
    } else {
      staPriority.innerHTML = "Low Priority";
      staPriority.setAttribute("class", "sta-priority=low");
    }
    staBox.appendChild(staPriority);

    // Status Date
    let staDate = document.createElement("p");
    staDate.innerHTML = "Status Date: " + sta.status_date;
    staDate.setAttribute("class", "sto-completion-date");
    staBox.appendChild(staDate);

    console.log(`${em.type} does exist`);
    //Requested Info
    if (sta.author_info != null) {
      let staAuthorInfo = document.createElement("p");
      staAuthorInfo.innerHTML = `Requested Info: ${sta.author_info}`;
      staAuthorInfo.setAttribute("class", "sto-description");
      staBox.appendChild(staAuthorInfo);
    }

    // Status Approve Button
    let penBtn = document.getElementById("ustat-btn");
    penBtn.addEventListener("click", () => {
      updateStatus(sta);
    });

    // -----------------------------------------
    // Status Approve Button
    let nsta = st.story_status;
    console.log(nsta);
    jSta = JSON.stringify(nsta);

    let psta = sta.status;
    let pstaSelect = document.getElementById("ustat-sel");

    // Dynamically added priority
    if (prioExists) {
      if (sta.priority) {
        if (psta === "pending_senior") {
          if (eType === "senior") {
            let opt1 = document.createElement("option");
            opt1.innerHTML = st.id + ": " + st.title;
            opt1.setAttribute("value", jSta);
            pstaSelect.appendChild(opt1);
            console.log("hit1");
          }
        } else {
          let opt1 = document.createElement("option");
          opt1.innerHTML = st.id + ": " + st.title;
          opt1.setAttribute("value", jSta);
          pstaSelect.appendChild(opt1);
          console.log("hit2");
        }
      }
    } else {
      if (psta === "pending_senior") {
        if (eType === "senior") {
          let opt1 = document.createElement("option");
          opt1.innerHTML = st.id + ": " + st.title;
          opt1.setAttribute("value", jSta);
          pstaSelect.appendChild(opt1);
          console.log("hit3");
        }
      } else {
        let opt1 = document.createElement("option");
        opt1.innerHTML = st.id + ": " + st.title;
        opt1.setAttribute("value", jSta);
        pstaSelect.appendChild(opt1);
        console.log("hit4");
      }
    }

    //--------------------------------------
    // Approval Object

    if (sta.status === "pending_approval") {
      let app = sta.approval;
      // Approval Box
      let appBox = document.createElement("div");
      appBox.setAttribute("class", "app-box");

      // App Header
      let appHeader = document.createElement("h3");
      appHeader.innerHTML = "APPROVAL PROCESS";
      appBox.appendChild(appHeader);

      // Approval Status
      let appStatus = document.createElement("h5");
      appStatus.innerHTML = "Approval Status:" + " " + app.approval_status;
      appStatus.setAttribute("class", "sto-tagline");
      appBox.appendChild(appStatus);

      // Approval Info
      if (app.approval_info != null) {
        let appInfo = document.createElement("p");
        appInfo.innerHTML = "Approval Info:" + " " + app.approval_info;
        appInfo.setAttribute("class", "sto-description");
        appBox.appendChild(appInfo);
      }

      // Approval Number
      let appNumber = document.createElement("h5");
      appNumber.innerHTML = "Need 3 approval votes, currently at: " + app.number_of_approves;
      appNumber.setAttribute("class", "sto-genre");
      appBox.appendChild(appNumber);

      if (appNumber < 3) {
        let appBtn = document.createElement("button");
        appBtn.innerHTML = "Final Approval";
        appBtn.setAttribute("class", "app-btn");
        appBtn.addEventListener("click", () => {
          updateApproval(st);
        });
      }
      staBox.appendChild(appBox);
    }
    // attach populated containers
    stoBox.appendChild(staBox);
    storySection.appendChild(stoBox);
  });
}

function updateStory(e, st) {
  e.preventDefault();
  console.log("HIT");
  let ust = st;
  utitle = e.target["tInput"].value;
  utagline = e.target["tagInput"].value;
  udescription = e.target["dInput"].value;

  ust["title"] = utitle;
  ust["tagline"] = utagline;
  ust["description"] = udescription;

  let jst = JSON.stringify(ust);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postStatus;
  xhttp.open("POST", URL + "/update-story", true);
  console.log(jst);
  xhttp.send(jst);

  function postStatus() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        alert("Story Updated. Changes will be visible on next Log-In");
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateStatusInfo(e, st) {
  e.preventDefault();
  let sta = st.story_status;
  console.log(sta);

  usta = e.target["infoText"].value;
  sta["author_info"] = usta;

  let jsta = JSON.stringify(sta);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postStatus;
  xhttp.open("POST", URL + "/update-status", true);
  console.log(jsta);
  xhttp.send(jsta);

  function postStatus() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        alert("Status updated. Changes will be visible on next Log-In");
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateStatus(ev) {
  ev.preventDefault();
  let sta = JSON.parse(ev.target["statusSelect"].value);
  console.log(sta);
  let xa = {};
  if (sta.approval != null) {
    xa = sta.approval;
  }
  let oldSta = sta.status;
  let nSta = "";
  let uSta = sta;

  if (oldSta === "pending_assistant") {
    nSta = "pending_general";
  }
  if (oldSta === "pending_general") {
    nSta = "pending_senior";
  }
  if (oldSta === "pending_senior") {
    nSta = "pending_approval";
    console.log(sta + "poop");
    console.log(uSta + "hit");
    addApproval(sta);
  }

  if (oldSta === "pending_approval") {
    if (xa.number_of_approves == 1) {
      nSta = "pending_approval";
      uSta.approval["number_of_approves"] = 2;
      updateApprovalF(uSta);
    } else {
      nSta = "approved";
      updateApproval(sta);
    }
  }

  uSta["status"] = nSta;
  uSta["priority"] = false;
  console.log(uSta);

  jSta = JSON.stringify(uSta);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postStatus;
  xhttp.open("POST", URL + "/update-status", true);
  console.log(jSta);
  xhttp.send(jSta);

  function postStatus() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        alert("Status updated. Changes will be visible on next Log-In");
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function addApproval(sta) {
  console.log(sta);
  let approval = {
    approval_status: "committee",
    number_of_approves: 1,
    status_id: sta.id,
  };

  console.log(approval);

  jApp = JSON.stringify(approval);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postApp;
  xhttp.open("POST", URL + "/add-approval", true);
  xhttp.send(jApp);

  function postApp() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateApproval(st) {
  console.log(st);
  let sid = st.id;
  let author = {
    id: 0,
    points: 0,
  };

  if (sid == 2) {
    author["id"] = 3;
    author["points"] = 100;
  }
  if (sid == 3) {
    author["id"] = 3;
    author["points"] = 100;
  }

  let oApp = st.approval;
  oApp[status] = "approved";

  jApp = JSON.stringify(oApp);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postApproval;
  xhttp.open("POST", URL + "/update-approval", true);
  xhttp.send(jApp);

  function postApproval() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        updateAuthor(author);
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateApprovalF(st) {
  let sid = st.story_status_id;

  let oApp = st.approval;

  jApp = JSON.stringify(oApp);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postApproval;
  xhttp.open("POST", URL + "/update-approval", true);
  xhttp.send(jApp);

  function postApproval() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateAuthor(at) {
  console.log(at);
  let author = {
    id: at.id,
    points: at.points,
  };

  jAuthor = JSON.stringify(author);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postAuthor;
  xhttp.open("POST", URL + "/update-author", true);
  xhttp.send(jAuthor);

  function postAuthor() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

// logout
let logoutbtn = document.getElementById("logout");
logoutbtn.addEventListener("click", () => {
  logout();
});

function logout() {
  // finish this on backend
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = logoutPlease;
  xhttp.open("GET", URL + "/logout", true);
  xhttp.send();

  function logoutPlease() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        window.location.href = "EmployeeLogin.html";
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}
