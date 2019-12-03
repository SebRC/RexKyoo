
//read and add to optionlist for image stored in database
function readPicnames(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    querySnapshot.forEach((doc) => 
    {
      console.log(`${doc.id} => ${doc.data()}`);
      var valueFromDB = doc.data();

      if(valueFromDB.stringID != "teddybear.jpg")
      {
        //used symbol ( ` ), its next to symbol ( ? )
        document.getElementById("pics-select").innerHTML += 
        `
        <option value="${valueFromDB.stringID}">${valueFromDB.stringID}</option>
         `;
      }
    });
  });
}

function uploadImageSection()
{
  document.getElementById("user_div").innerHTML =
  `
  <div class="main-profile">
    <div class="center-text">
      <h1 style="font-size:40px; color: white"><br>Billder for profil</h1>
    </div>
    <img class="main-profile-image" id="imageDisplay" src="../Images/kids/teddybear.jpg">
  </div>

  <div class="center-main-but">

    <label class="input-file">
      <input type="file" id="fileInput" size="20" accept="image/*">
    </label> 
    
    <button class="but-hover" onclick="uploadImage(picNameCollection, profileCollection)">Upload dit billede </button>
    <label class="input-file">
      <select id="pics-select">
        <option value="teddybear.jpg">default</option>
      </select>
    </label> 
    <button class="but-hover" onclick="deleteImage(profileCollection)">delete</button>
    <button class="but-hover" onclick="readBoss(bossCollection)">Cancel </button>
  </div>

  <div class="extraSpace200"></div>
  <div class="extraSpace100"></div>
  `;

  readPicnames(picNameCollection);
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;

  //jQuery selector (#id, .class)
  //This part is jQuery because I just learned this function! 
  $("#fileInput").change(function()
  {
    previewProfileImage(this);
  });
  $("#pics-select").change(function()
  {
    downloadImage(imageDisplayID, profileCollection, this.value);
  });
}

function uploadLogoSection1()
{
  document.getElementById("user_div").innerHTML =
  `
  <div class="main-profile">
    <div class="center-text">
      <h1 style="font-size:40px"><br>Logoer for slideshow 1</h1>
    </div>
    <img class="main-profile-image" id="imageDisplay" src="../Images/divers/Original-logoSmall.png">
  </div>
 
  <div class="center-main-but">

    <label class="input-file">
      <input type="file" id="fileInput" size="20" accept="image/*">
    </label> 
    
    <button class="but-hover" onclick="uploadImage(logoNameCollection, logoCollection)">Upload dit billede </button>
    <label class="input-file">
      <select id="pics-select">
        <option value="teddybear.jpg">default</option>
      </select>
    </label> 
    <button class="but-hover" onclick="deleteImage(logoCollection)">delete</button>
    <button class="but-hover" onclick="readBoss(bossCollection)">Cancel </button>
  </div>

  <div class="extraSpace200"></div>
  <div class="extraSpace100"></div>
  `;

  readPicnames(logoNameCollection);
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;

  //jQuery selector (#id, .class)
  //This part is jQuery because I just learned this function! 
  $("#fileInput").change(function()
  {
    previewProfileImage(this);
  });
  $("#pics-select").change(function()
  {
    downloadImage(imageDisplayID, logoCollection, this.value);
  });
}

function uploadLogoSection2()
{
  document.getElementById("user_div").innerHTML =
  `
  <div class="main-profile">
    <div class="center-text">
      <h1 style="font-size:40px"><br>Logoer for slideshow 2</h1>
    </div>
    <img class="main-profile-image" id="imageDisplay" src="../Images/divers/Original-logoSmall.png">
  </div>
 
  <div class="center-main-but">

    <label class="input-file">
      <input type="file" id="fileInput" size="20" accept="image/*">
    </label> 
    
    <button class="but-hover" onclick="uploadImage(logoNameCollection, logoCollection)">Upload dit billede </button>
    <label class="input-file">
      <select id="pics-select">
        <option value="teddybear.jpg">default</option>
      </select>
    </label> 
    <button class="but-hover" onclick="deleteImage(logoCollection)">delete</button>
    <button class="but-hover" onclick="readBoss(bossCollection)">Cancel </button>
  </div>

  <div class="main-profile-textbox-update">
    <h5>Tekst under logo: <input type="text" id="name" placeholder="navn" value="test" min="1" max="100"></h5>
  </div>

  <div class="extraSpace200"></div>
  <div class="extraSpace100"></div>
  `;

  readPicnames(logoNameCollection);
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;

  //jQuery selector (#id, .class)
  //This part is jQuery because I just learned this function! 
  $("#fileInput").change(function()
  {
    previewProfileImage(this);
  });
  $("#pics-select").change(function()
  {
    downloadImage(imageDisplayID, logoCollection, this.value);
  });
}


function previewProfileImage(uploader)
{ 
  //ensure a file was selected 
  if (uploader.files && uploader.files[0]) 
  {
      var imageFile = uploader.files[0];
      var reader = new FileReader();    
      reader.onload = function (e) 
      {
        //set the image data as source
        $('#imageDisplay').attr('src', e.target.result);
      }    
      reader.readAsDataURL(imageFile);
  }
}

function downloadImage(id, storageCollectionName, name)
{
  var valName = storageCollectionName+ name;
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

function uploadImage(collectionName, storageCollectionName)
{
  //Get file
  var pic = document.getElementById("fileInput"); 
  var file= pic.files[0];
  var picName = file.name; 

  if(picName != null)
  {
    //for pic list in database
    var mylist = 
    {
      stringID: picName,
      author_uid: "exmHGPeyCKOh8m6xKuAgaJR3AQe2"
    };
    writeDB(collectionName, mylist);

    //Create a storage ref
    var storageRef = firebase.storage().ref(storageCollectionName + picName);

    //upload file
    storageRef.put(file).then(function(snapshot) 
    {
      console.log('file uploaded to firebase! '+ picName);
      readBoss(bossCollection);
    });
  }else
  {
    console.log('You can not upload nothing!');
  }
}

function deleteImage(storageCollectionName)
{
  var picName = document.getElementById("pics-select").value;
  var valName = storageCollectionName + picName;

  if(picName != "teddybear.jpg")
  {
    // Delete from list
    deleteFromDB(picNameCollection, picName);

    // Create a reference to the file to delete
    var desertRef = storageRef.child(valName);

    // Delete the file
    desertRef.delete().then(function()
    {
      // File deleted successfully
      console.log(valName + "was delete from database");
      readBoss(bossCollection);
    }).catch(function(error) 
    {
      // Uh-oh, an error occurred!
      console.log("error message" + error);
    });
  }
}
