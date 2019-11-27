
var idList = [];

function readEmployer(collectionName)
{
  var pageID = "page1";
  var counter = 0;
  var pageCounter = 1;

  pageBuilder();

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
      //formatting for method use
      var valID = "'" + valueFromDB.id + "'";
      var valName = "'" + valueFromDB.name + "'";
      var valTitle = "'" + valueFromDB.title + "'";
      var valPlace = "'" + valueFromDB.place + "'";
      var valExp = "'" + valueFromDB.exp + "'";
      var valNation = "'" + valueFromDB.nation + "'";
      var valLine1 = "'" + valueFromDB.line1 + "'";
      var valLine2 = "'" + valueFromDB.line2 + "'";
      var valLine3 = "'" + valueFromDB.line3 + "'";
      var valPicName = "'" + valueFromDB.picName + "'";

      //used symbol ( ` ), its next to symbol ( ? )
      document.getElementById(pageID).innerHTML += 
      `
      <div class="box-profile">
        <img class="box-profile-image" id="${valueFromDB.id}">
      
        <div class="box-profile-text">
            <h2>${valueFromDB.name}</2>
            <h3>Id: ${valueFromDB.id}</h3>
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

            <button class="but-hover" onclick="updateEmployer(${valID},${valName},${valTitle},${valPlace},${valExp},${valNation},${valLine1},${valLine2},${valLine3},${valPicName})"><i class="fas fa-edit"></i> Redigere </button>
            <button class="but-hover" onclick="deleteEmployer(employerCollection, ${valID})"><i class="fas fa-trash-alt"></i>  delete</button>
        </div>
      </div>
      `;

      //parameter (id form div html, name form pic)
      downloadImage(valueFromDB.id, profileCollection, valueFromDB.picName);
      idList.push(valueFromDB.id);
    });
  });
  return idList;
}

function updateEmployer(id, name, title, place, exp, nation, line1, line2, line3, picName)
{
  //changing user_div to update mode!
  document.getElementById("user_div").innerHTML =
  `
  <div class="main-profile">
    <img class="main-profile-image" id="main-image" src="../Images/kids/teddybear.jpg">
  </div>

  <div class="center-main-but">
    <button class="but-hover" onclick="myConfirmEmployer(employerCollection)"><i class="far fa-save"></i>Gem </button>

    <label class="input-file">
      <select id="pics-select">
        <option value="${picName}">Nuværende pic</option>
        <option value="teddybear.jpg">Ingen</option>
      </select>
    </label> 

    <button class="but-hover" onclick="readBoss(bossCollection)">Cancel </button>
  </div>

  <div class="main-profile-textbox-update-employer">
    <h5>Navn: <input type="text" id="name" placeholder="navn" value="${name}" min="1" max="100"></h5>
    <h5>ID: <input type="text" id="id" placeholder="id" value="${id}" min="1" max="200"></h5>
    <h5>Titel: <input type="text" id="title" placeholder="titel" value="${title}" min="1" max="100"></h5>
    <h5>Område: <input type="text" id="place" placeholder="område" value="${place}" min="1" max="100"></h5>
    <h5>Erfaring: <input type="text" id="exp" placeholder="erfaring" value="${exp}" min="1" max="100"></h5>
    <h5>Nationalitet: <input type="text" id="nation" placeholder="nationalitet" value="${nation}" min="1" max="100"></h5>
    
    <h5>linje 1: <input type="text" id="line1" placeholder="line 1" value="${line1}" min="1" max="100"></h5>
    <h5>linje 2: <input type="text" id="line2" placeholder="line 2" value="${line2}" min="1" max="100"></h5>
    <h5>linje 3: <input type="text" id="line3" placeholder="line 3" value="${line3}" min="1" max="100"></h5>
  </div>

  <div class="extraSpace100"></div>
  `;

  //parameter (id form div html, name form pic)
  downloadImage(mainImageID, profileCollection, picName);
  readPicnames(picNameCollection);

  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;

  $("#pics-select").change(function()
  {
    downloadImage(mainImageID, profileCollection, this.value);
  });
}

function myConfirmEmployer(collectionName, id)
{
  var myConFirm = confirm("Er du sikker på at du vil gemme!\nDu kan ikke få din gamle tekst tilbage!");
  if (myConFirm == true) 
  {
    saveEmployer(collectionName, id);
  } 
}

function saveEmployer(collectionName)
{
  var name = document.getElementById("name").value;
  var id = document.getElementById("id").value;
  var title = document.getElementById("title").value;
  var place = document.getElementById("place").value;
  var exp = document.getElementById("exp").value;
  var nation = document.getElementById("nation").value;
  var line1 = document.getElementById("line1").value;
  var line2 = document.getElementById("line2").value;
  var line3 = document.getElementById("line3").value;
  var picName = document.getElementById("pics-select").value;

  //numer id is for auto id system, and stringID is for firebase!
  var mylist = 
  {
    id: Number(id),
    stringID: id,
    name: name,
    title: title,
    place: place, 
    exp: exp,
    nation: nation,
    line1: line1,
    line2: line2,
    line3: line3,
    picName: picName,
    author_uid: "exmHGPeyCKOh8m6xKuAgaJR3AQe2"
  };
  
  writeDB(collectionName, mylist);
  readBoss(bossCollection);
  readEmployer(employerCollection);
}