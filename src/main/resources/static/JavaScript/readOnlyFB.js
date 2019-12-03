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

// Variables for Collection names, id´s
var bossCollection = "profile-boss";
var employerCollection = "profile-employer";
var picNameCollection = "profile-pics-namelist";
var mainImageID = "main-image"; 

var pages = 0;
var countList = [];
var slideIndex = 1;

$(function()
{
  countEmployer(employerCollection);
  readBoss(bossCollection);
  setTimeout(setupEmployer, 2000); // Change image every 2 seconds
});

//setup is for Firebase to get the data needed before building the page!
function setupEmployer()
{
  pageBuilder();
  readEmployer(employerCollection);
  showSlides(slideIndex);
}

function readBoss(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    document.getElementById("user_div").innerHTML = ""; 

    querySnapshot.forEach((doc) => 
    {
      var valueFromDB = doc.data(); 


      //used symbol ( ` ), its next to symbol ( ? )
      document.getElementById("user_div").innerHTML += 
      `
      <div class="main-profile">
        <img class="main-profile-image" id="${mainImageID}" >
        <div class="main-profile-textbox">
            <h4 style="text-transform: uppercase">
                &nbsp;&nbsp;${valueFromDB.headline1}<br>
                &nbsp;&nbsp;${valueFromDB.headline2}
            </h4>
            <p  style="font-size: 14px">
                &nbsp;&nbsp;${valueFromDB.line1}<br>
                &nbsp;&nbsp;${valueFromDB.line2}<br>
                &nbsp;&nbsp;${valueFromDB.line3}<br><br>
            </p>
            <p  style="font-size: 14px" ><i>
                &nbsp;&nbsp;<strong>${valueFromDB.quoteline1}<br>
                &nbsp;&nbsp;&nbsp;&nbsp;${valueFromDB.quoteline2}<br>
               </strong>
            </i></p>
            
            <p class="main-profile-text">    
                &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<strong>${valueFromDB.name}</strong><br>
                &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stifter af <strong>RexKyoo</strong><br>
                &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-phone-volume"></i> <strong>Telefon: </strong>${valueFromDB.tlf}<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="far fa-envelope"></i> <strong>E-mail:</strong> ${valueFromDB.email}
            </p>
        </div>
    </div>

    <div class="extraSpace200"></div>
    <div class="extraSpace100"></div>
    `;

      //parameter (id form div html, name form pic)
      downloadImage(mainImageID, valueFromDB.picName);
    });
  });
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

function readEmployer(collectionName)
{
  var pageID = "page1";
  var counter = 0;
  var pageCounter = 1;

  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    querySnapshot.forEach((doc) => 
    {
      counter++;
      if(counter == 10)
      {
        pageCounter++;
        pageID = "page"+pageCounter;
        counter = 0;
      } 

      var valueFromDB = doc.data(); 

      //used symbol ( ` ), its next to symbol ( ? )
      document.getElementById(pageID).innerHTML += 
      `
      <div class="box-profile">
        <img class="box-profile-image" id="${valueFromDB.id}">
      
        <div class="box-profile-text">

            <h2>${valueFromDB.name}</2>
            <h3>Titel: ${valueFromDB.title}</h3>
            <h3>Område: ${valueFromDB.place}</h3>
            <h3>Erfaring: ${valueFromDB.exp}</h3>
            <h3>Ren straffeattest: <font color="green"><i class="fas fa-check"></i></font></h3>
            <h3>Nationalitet: ${valueFromDB.nation}</h3>
            <p>
                ${valueFromDB.line1}<br>
                ${valueFromDB.line2}<br>
                ${valueFromDB.line3}
            </p>
            <h1 class="box-profile-star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></h1>
        </div>
      </div>
      `;

      //parameter (id form div html, name form pic)
      downloadImage(valueFromDB.id, valueFromDB.picName);
    });
  });
}

function downloadImage(id, name)
{
  var valName = "profile/"+ name;
  var valID = "#" + id;

  var picRef = storageRef.child(valName);
  picRef.getDownloadURL().then(function(url) 
  {
    $(valID).attr('src', url);
    console.log(url);
  }).catch(function(error) 
  {
    // A full list of error codes is available at
    // https://firebase.google.com/docs/storage/web/handle-errors
  });
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