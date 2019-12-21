//The code was written by Jackie Vuong

// Your web app's Firebase configuration
var firebaseConfig = 
{
   apiKey: "AIzaSyBTJfWo--kUE-VQimE3mW8HysFTyqBOmlk",
   authDomain: "myfirstfirestore-22b13.firebaseapp.com",
   databaseURL: "https://myfirstfirestore-22b13.firebaseio.com",
   projectId: "myfirstfirestore-22b13",
   storageBucket: "myfirstfirestore-22b13.appspot.com",
   messagingSenderId: "225945953549",
   appId: "1:225945953549:web:9fe7b6a84cbb3b888b3c44"
 };
 // Initialize Firebase
 firebase.initializeApp(firebaseConfig);
 var firestoreDB = firebase.firestore();
 var storageRef = firebase.storage().ref();

 // Variables for Collection names, id´s, lists
 var bossCollection = "profile-boss";
 var employerCollection = "profile-employer";
 
 var picNameCollection = "profile-pics-namelist";
 var logoNameCollection = "logo-pics-namelist";

 var profileCollection = "profile/";
 var logoCollection = "logo/";

 var mainImageID = "main-image"; 
 var imageDisplayID = "imageDisplay";
 var employerIDList = [];
 
 var pages = 0;
 var countList = [];
 var slideIndex = 1;

 // Variables for login triggered by the enter key button
 var input = document.getElementById("password_input");
 input.addEventListener("keyup", function(event)
 {
   if (event.keyCode === 13) 
   {
    event.preventDefault();
    document.getElementById("login_but").click();
   }
 });
 var input2 = document.getElementById("email_input");
 input2.addEventListener("keyup", function(event)
 {
   if (event.keyCode === 13) 
   {
    event.preventDefault();
    document.getElementById("login_but").click();
   }
 });

 // Check if user is loggin or not
 firebase.auth().onAuthStateChanged(function(user) 
{
  if (user)
    {
    // User is signed in.
    //window.alert("your are login test");
    document.getElementById("login_div").style.display = "none";

    document.getElementById("user_logout").style.display = "initial";
    document.getElementById("user_div").style.display = "initial";

    document.getElementById("user_logout").innerHTML = 
    `
    <div class="dropdown-menu">
        <div><p><i class="fas fa-bars"></i> Upload billeder</p></div> 
        <li class="dropdown-content-menu">
          <div id="user_logout" onclick="uploadImageSection()"><p1>Profil</p1></div>
        </li>
    </div>
    <div id="user_logout" onclick="logout()"><p>Logout</p></div> 
    `;

    countEmployer(employerCollection);
    readBoss(bossCollection);
    setTimeout(setupEmployer, 2000); // Change image every 2 seconds

    document.getElementById("user_div3").innerHTML += 
    `
    <div onclick="addProfile()" class="box-profile">
    <img class="box-profile-add" src="../images/divers/add-icon.png">
    </div>
    `;

    document.getElementById("user_div4").innerHTML += 
    `
    <button class="but-hover" onclick="plusSlides(-1)">❮ Tilbage</button>
    <button class="but-hover" onclick="plusSlides(1)">Frem ❯</button>
    `;
  } else
  {
    // No user is signed in.
    document.getElementById("login_div").style.display = "block";
    document.getElementById("user_logout").style.display = "none";
    document.getElementById("user_div").style.display = "none";
  }
});

function login()
{
  var userEmail = document.getElementById("email_input").value;
  var userPassword = document.getElementById("password_input").value;
  //window.alert(userEmail + " " + userPassword);

 
  firebase.auth().signInWithEmailAndPassword(userEmail, userPassword).then(function()
  {
    //loggedin successful
    //reset data
    document.getElementById("email_input").value = "";
    document.getElementById("password_input").value = "";

  }).catch(function(error)
  {
    //Handle error here.
    var errorCode = error.code;
    var errorMessage = error.message;
    window.alert("Error occured: " + errorMessage);
  });  
}

function logout()
{
  firebase.auth().signOut().then(function()
  {
    //after signout
    location.replace("minside")
  }).catch(function(error)
  {
     //Handle error here.
    var errorCode = error.code;
    var errorMessage = error.message;
    window.alert("Error occured: " + errorMessage);
  });
}

//setup is for Firebase to get the data needed before building the page!
function setupEmployer()
{
  employerIDList = readEmployer(employerCollection);
  showSlides(slideIndex);
}

function countEmployer(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    querySnapshot.forEach((doc) => 
    {
      var valueFromDB = doc.data(); 
      countList.push(valueFromDB.id);      
    });
  });
}

function pageBuilder()
{
  //Every page can hold 9 profil-cards!
  pages = Math.floor(countList.length/9)+1;

  document.getElementById("user_div2").innerHTML = ""; 
  document.getElementById("dotsEmployer").innerHTML = ""; 

  for (i = 1; i < pages+1; i++) 
  {
    //used symbol ( ` ), its next to symbol ( ? )
   document.getElementById("user_div2").innerHTML += 
   `
   <div class="page-slider" id="page${i}"></div>
   `;

   document.getElementById("dotsEmployer").innerHTML += 
   `
   <span class="dot" onclick="currentSlide(${i})"></span> 
   `;
  }
}

function plusSlides(n) 
{
  document.body.scrollTop = 680;
  document.documentElement.scrollTop = 680;
  showSlides(slideIndex += n);
}

function currentSlide(n)
{
  document.body.scrollTop = 680;
  document.documentElement.scrollTop = 680;
  showSlides(slideIndex = n);
}

function showSlides(n)
{
  var i;
  var slides = document.getElementsByClassName("page-slider");
 
  var dots = document.getElementsByClassName("dot");
  //var captionText = document.getElementById("caption");
  if (n > slides.length) 
  {
    slideIndex = 1
  }
  if (n < 1) 
  {
    slideIndex = slides.length
  }
  for (i = 0; i < slides.length; i++) 
  {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) 
  {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  // captionText.innerHTML = dots[slideIndex-1].alt;
}

function addProfile()
{
  var newId = myIdCreator(employerIDList);
  employerIDList.push(newId);

  document.getElementById("user_div2").innerHTML += 
  `
  <div class="box-profile">
    <img class="box-profile-image" id="0" src="../images/kids/teddybear.jpg">
  
    <div class="box-profile-text">
        <h2>Dit Navn</2>
        <h3>Titel: Rengørings assistent</h3>
        <h3>Område: Køge</h3>
        <h3>Erfaring: 4 års erfaring</h3>
        <h3>Ren straffeattest: <font color="green"><i class="fas fa-check"></i></font></h3>
        <h3>Nationalitet: Dansk </h3>
        <p>
            hey ${newId},<br>
            vidste du, at<br>
            kage er godt.
        </p>

        <button class="but-hover" onclick="updateEmployer(${newId},'','','','','','','','','teddybear.jpg')"><i class="fas fa-edit"></i> Redigere </button>
        <button class="but-hover" onclick="deleteEmployer(employerCollection, ${newId})"><i class="fas fa-trash-alt"></i>  delete</button>
    </div>
  </div>
  `;

}

//Makes a id that do not exist
function myIdCreator(list)
{
  var newId = 0;
  var id = 0;

  for (let index = 0; index < list.length+1; index++)
  {
    var check = list.includes(index);
    
    if(check == false)
    {
      return newId;
    }else
    {
      id++;
      newId = id;
    }
  }
  return "fejl";
}

function writeDB(collectionName, mylist)
{
  firestoreDB.collection(collectionName).doc(mylist.stringID).set(mylist)
  .catch(function(error) 
  {
    console.error("Error adding document: ", error);
  });
}

function deleteFromDB(collectionName, dataID)
{
  firestoreDB.collection(collectionName).doc(dataID).delete().then(function() 
  {
    console.log("Document successfully deleted! " + dataID);
  }).catch(function(error)
  {
    console.error("Error removing document: ", error);
  });
}

function deleteEmployer(collectionName, dataID)
{
  var myConFirm = confirm("Er du sikker på at du vil slette den bruger!\nDu kan ikke hente dataen tilbage!");
  if (myConFirm == true) 
  {
    employerIDList.pop(dataID);
    deleteFromDB(collectionName, dataID);
    readEmployer(employerCollection);
  }  
}

