//Is not finish!!!

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
  var logoCollection = "logo";
  var mainImageID = "main-image"; 

$(function()
{
  readLogoSlidder1(logoCollection);
  readLogoSlidder2(logoCollection);
});

function readLogoSlidder1(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    document.getElementById("slider1").innerHTML = ""; 

    querySnapshot.forEach((doc) => 
    {
      console.log(`${doc.id} => ${doc.data()}`);
      var valueFromDB = doc.data(); 

      //used symbol ( ` ), its next to symbol ( ? )
      document.getElementById("slider1").innerHTML += 
      `
        <div class="mySlides fade">
            <img id="${valueFromDB.id}" src="../images/reference/sats.jpg" style="width:70%">
            <div class="sliderText">${valueFromDB.text}</div>
        </div>
      `;

      //parameter (id form div html, name form pic)
      downloadImage(valueFromDB.id, valueFromDB.picName);
    });
  });
}

function readLogoSlidder2(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    document.getElementById("slider2").innerHTML = ""; 

    querySnapshot.forEach((doc) => 
    {
      console.log(`${doc.id} => ${doc.data()}`);
      var valueFromDB = doc.data(); 

      //used symbol ( ` ), its next to symbol ( ? )
      document.getElementById("slider2").innerHTML += 
      `
        <div class="mySlides fade">
            <img id="${valueFromDB.id}" src="../images/reference/sats.jpg" style="width:70%">
            <div class="sliderText">${valueFromDB.text}</div>
        </div>
      `;

      //parameter (id form div html, name form pic)
      downloadImage(valueFromDB.id, valueFromDB.picName);
    });
  });
}

function downloadImage(id, name)
{
  var valName = "logo/"+ name;
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