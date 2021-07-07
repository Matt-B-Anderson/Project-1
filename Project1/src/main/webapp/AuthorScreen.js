const URL = "http://localhost:8080/Project1/controller";
let author = {};

document.getElementById("logout-button").addEventListener("click", logout);

const form = document.querySelector("form");
form.addEventListener("submit", (e) => addStory(e));

function logout() {
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = changePage;
  xhttp.open("GET", URL + "/logout", true);
  xhttp.send();

  function changePage() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        window.location.href = "AuthorLogin.html";
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function addStory(e) {
  e.preventDefault();

  let story = {
    title: e.target["title"].value,
    tagline: e.target["tagline"].value,
    description: e.target["description"].value,
    submit_date: e.target["date"].value,
    genre: e.target["genre"].value,
    story_type: e.target["type"].value,
    story_status: {
      status: "pending_assistant",
      priority: false,
      status_date: "2021-06-26",
      approval: {
        approval_status: null,
        approval_info: null,
        number_of_approves: null,
      },
    },
  };

  console.log(story.story_type);

  let pts = 0;

  if (story.story_type === "novel") {
    pts = 50;
  }

  if (story.story_type === "novella") {
    pts = 25;
  }

  if (story.story_type === "short-story") {
    pts = 20;
  }

  if (story.story_type === "article") {
    pts = 10;
  }

  storyJson = JSON.stringify(story);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = sendData;
  xhttp.open("POST", URL + "/add-story", true);
  xhttp.send(storyJson);

  function sendData() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        updateAuthor(author, pts);
        alert("Thank you for the submission. Entry will be visible on next Log-In.");
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
}

function updateAuthor(at, pts) {
  at["points"] = at.points - pts;

  autJson = JSON.stringify(at);

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = postAuthor;
  xhttp.open("POST", URL + "/update-author", true);
  xhttp.send(autJson);
  console.log("Author Sent to Back end: " + autJson);

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

const getStory = () => {
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = recieveData;

  xhttp.open("GET", URL + "/author-screen", true);
  xhttp.send();

  function recieveData() {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        let r = xhttp.response;
        rr = r.replace("AuthorLogin.html", "");
        author = JSON.parse(rr);
        console.log(author);
        populateData(author);
      } else {
        // Ready state is done but status code is not "Ok"
      }
    } else {
      // error handling
    }
  }
};

window.onload = getStory();

function populateData(at) {
  console.log(at);
  let storySection = document.getElementById("stories");

  let selectStoryType = document.getElementById("story-type");

  // Populate StoryType options
  let pts = at.points;
  console.log(pts);
  if (pts >= 50) {
    let novel = document.createElement("option");
    novel.innerHTML = "Novel(101+ Pages) ";
    novel.setAttribute("value", "novel");
    selectStoryType.appendChild(novel);
  }

  if (pts >= 25) {
    let novella = document.createElement("option");
    novella.innerHTML = "Novella(11-100 Pages) ";
    novella.setAttribute("value", "novella");
    selectStoryType.appendChild(novella);
  }
  if (pts >= 20) {
    let shortStory = document.createElement("option");
    shortStory.innerHTML = "Short-Story(2-10 Pages) ";
    shortStory.setAttribute("value", "short-story");
    selectStoryType.appendChild(shortStory);
  }
  if (pts >= 10) {
    let article = document.createElement("option");
    article.innerHTML = "Article(1-2 Pages) ";
    article.setAttribute("value", "article");
    selectStoryType.appendChild(article);
  }
  // Author Welcome
  let authorWelcome = document.createElement("h2");
  authorWelcome.innerHTML = "Welcome, " + at.firstname + " " + at.lastname + "!";
  authorWelcome.setAttribute("class", "author-welcome");
  storySection.appendChild(authorWelcome);

  // Current points
  let authorPoints = document.createElement("h3"); // may need a diff name than author points
  authorPoints.innerHTML = "Points:" + " " + at.points;
  authorPoints.setAttribute("class", "author-points");
  storySection.appendChild(authorPoints);

  // Create a story button

  // Stories Container
  let storiesContainer = document.createElement("div");
  storiesContainer.setAttribute("class", "sto-container");
  storySection.appendChild(storiesContainer);

  at.stories.map((st) => {
    console.log(st);
    // Story Container
    let stoBox = document.createElement("div");
    stoBox.setAttribute("class", "sto-box");

    // Story Title
    let stoTitle = document.createElement("h3");
    stoTitle.innerHTML = "Title:" + " " + st.title;
    stoTitle.setAttribute("class", "sto-title");
    stoBox.appendChild(stoTitle);

    // Story Tagline
    let stoTagline = document.createElement("h5");
    stoTagline.innerHTML = "Tagline:" + " " + st.tagline;
    stoTagline.setAttribute("class", "sto-tagline");
    stoBox.appendChild(stoTagline);

    // Story description
    let stoDescription = document.createElement("p");
    stoDescription.innerHTML = "Description:" + " " + st.description;
    stoDescription.setAttribute("class", "sto-description");
    stoBox.appendChild(stoDescription);

    // Story completionDate
    let stoCompletionDate = document.createElement("p");
    stoCompletionDate.innerHTML = "Submit Date: " + " " + st.submit_date;
    stoCompletionDate.setAttribute("class", "sto-completion-date");
    stoBox.appendChild(stoCompletionDate);

    // Story genre
    let stoGenre = document.createElement("p");
    stoGenre.innerHTML = "Genre:" + " " + st.genre;
    stoGenre.setAttribute("class", "sto-genre");
    stoBox.appendChild(stoGenre);

    // Story weight
    let stoWeight = document.createElement("p");
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
    stoWeight.innerHTML = "Type:" + " " + nstoryType;
    stoWeight.setAttribute("class", "sto-genre");
    stoBox.appendChild(stoWeight);

    // -----------------------------------------
    // Status Object
    let sta = st.story_status;
    console.log(sta);
    let staBox = document.createElement("div");
    staBox.setAttribute("class", "sta-box");

    // Status
    let staStatus = document.createElement("h5");
    console.log(sta.status);
    staStatus.innerHTML = "Status:" + " " + sta.status;
    staStatus.setAttribute("class", "sto-tagline");
    staBox.appendChild(staStatus);

    //Status Date
    let staDate = document.createElement("p");
    staDate.innerHTML = "Status Date: " + " " + sta.status_date;
    staDate.setAttribute("class", "sto-completion-date");
    staBox.appendChild(staDate);

    //Author Info
    if (sta.author_info != null) {
      let staAuthorInfo = document.createElement("p");
      staAuthorInfo.innerHTML = sta.author_info;
      staAuthorInfo.setAttribute("class", "sto-description");
      staBox.appendChild(staAuthorInfo);
    }

    //--------------------------------------
    // Approval Object
    if (sta.status === "pending_approval") {
      let app = sta.approval;
      // Approval Box
      let appBox = document.createElement("div");
      appBox.setAttribute("class", "app-box");

      // Approval Status
      let appStatus = document.createElement("h5");
      appStatus.innerHTML = "Approval Status:" + " " + app.approval_status;
      appStatus.setAttribute("class", "sto-tagline");
      appBox.appendChild(appStatus);

      // Approval Info
      if (app.approvalInfo != null) {
        let appInfo = document.createElement("p");
        appInfo.innerHTML = app.approval_info;
        appInfo.setAttribute("class", "sto-description");
        appBox.appendChild(appInfo);
      }

      // Approval Number
      let appNumber = document.createElement("h5");
      appNumber.innerHTML = "Need 3, currently at: " + " " + app.number_of_approves;
      appNumber.setAttribute("class", "sto-genre");
      appBox.appendChild(appNumber);

      staBox.appendChild(appBox);
    }

    // attach populated containers
    stoBox.appendChild(staBox);
    storySection.appendChild(stoBox);
  });
}
