
function readBoss(collectionName)
{
  firestoreDB.collection(collectionName).get().then((querySnapshot) =>
  {
    document.getElementById("user_div").innerHTML = ""; 

    querySnapshot.forEach((doc) => 
    {
      console.log(`${doc.id} => ${doc.data()}`);
      var valueFromDB = doc.data(); 

      //formatting for method use
      var valID = "'" + valueFromDB.id + "'";
      var valHeadline1 = "'" + valueFromDB.headline1 + "'";
      var valHeadline2 = "'" + valueFromDB.headline2 + "'";
      var valLine1 = "'" + valueFromDB.line1 + "'";
      var valLine2 = "'" + valueFromDB.line2 + "'";
      var valLine3 = "'" + valueFromDB.line3 + "'";
      var valQuoteline1 = "'" + valueFromDB.quoteline1 + "'";
      var valQuoteline2 = "'" + valueFromDB.quoteline2 + "'";

      var valName = "'" + valueFromDB.name + "'";
      var valTlf = "'" + valueFromDB.tlf + "'";
      var valEmail = "'" + valueFromDB.email + "'";
      var valPicName = "'" + valueFromDB.picName + "'";

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

      <div class="center-main-but">
        <button class="but-hover" onclick="updateBoss(${valID},${valHeadline1},${valHeadline2},${valLine1},${valLine2},${valLine3},${valQuoteline1},${valQuoteline2},${valName},${valTlf},${valEmail},${valPicName})"><i class="fas fa-edit"></i> Redigere </button>
      </div>
  
      <div class="extraSpace200"></div>
      <div class="extraSpace100"></div>
      `;

      //parameter (id form div html, name form pic)
      downloadImage(mainImageID, profileCollection, valueFromDB.picName);
    });
  });
}

function updateBoss(id,headline1,headline2,line1,line2,line3,quoteline1,quoteline2,name,tlf,email,picName)
{
  var valID = "'" + id + "'";

  //changing user_div to update mode!
  document.getElementById("user_div").innerHTML =
  `
  <div class="main-profile">
    <img class="main-profile-image" id="${mainImageID}" src="../images/kids/teddybear.jpg">
  </div>

  <div class="center-main-but">
    <button class="but-hover" onclick="myConfirmBoss(bossCollection, ${valID})"><i class="far fa-save"></i>Gem </button>

    <label class="input-file">
      <select id="pics-select">
        <option value="${picName}">Nuværende pic</option>
        <option value="teddybear.jpg">Ingen</option>
      </select>
    </label> 

    <button class="but-hover" onclick="readBoss(bossCollection)">Cancel </button>
  </div>

  <div class="main-profile-textbox-update">
    <h5 style="text-transform: uppercase">
        &nbsp;&nbsp;<input type="text" id="headline1" placeholder="headline 1" value="${headline1}" min="1" max="100" size="60">
        &nbsp;&nbsp;<input type="text" id="headline2" placeholder="headline 2" value="${headline2}" min="1" max="100" size="60">
    </h5>
    <p>
        &nbsp;&nbsp;<input type="text" id="line1" placeholder="line 1" value="${line1}" min="1" max="100" size="60">
        &nbsp;&nbsp;<input type="text" id="line2" placeholder="line 2" value="${line2}" min="1" max="100" size="60">
        &nbsp;&nbsp;<input type="text" id="line3" placeholder="line 3" value="${line3}" min="1" max="100" size="60"><br>
    </p>
    <p >
        &nbsp;Teksten står i italic på ansat-siden!<br>
        &nbsp;&nbsp;<input type="text" id="quoteline1" placeholder="quoteline 1" value="${quoteline1}" min="1" max="100" size="60">
        &nbsp;&nbsp;<input type="text" id="quoteline2" placeholder="quoteline 2" value="${quoteline2}" min="1" max="100" size="60"><br>
    </p>
    
    <p class="main-profile-text">    
        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<input type="text" id="name" placeholder="navn" value="${name}" min="1" max="100"><br>
        &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stifter af <strong>RexKyoo</strong><br>
        &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-phone-volume"></i> <strong>Telefon: </strong><input type="text" id="tlf" placeholder="tlf nummer" value="${tlf}" min="1" max="100"><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="far fa-envelope"></i> <strong>E-mail: </strong><input type="text" id="email" placeholder="e-mail" value="${email}" min="1" max="100"><br>
    </p>
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

function myConfirmBoss(collectionName, id)
{
  var myConFirm = confirm("Er du sikker på at du vil gemme!\nDu kan ikke få din gamle tekst tilbage!");
  if (myConFirm == true) 
  {
    saveBoss(collectionName, id);
  } 
}

function saveBoss(collectionName, id)
{

  var headline1 = document.getElementById("headline1").value;
  var headline2 = document.getElementById("headline2").value;
  var line1 = document.getElementById("line1").value;
  var line2 = document.getElementById("line2").value;
  var line3 = document.getElementById("line3").value;
  var quoteline1 = document.getElementById("quoteline1").value;
  var quoteline2 = document.getElementById("quoteline2").value;

  var name = document.getElementById("name").value;
  var tlf = document.getElementById("tlf").value;
  var email = document.getElementById("email").value;
  var picName = document.getElementById("pics-select").value;

  //numer id is for auto id system, and stringID is for firebase!
  var mylist = 
  {
    id: Number(id),
    stringID: id,

    headline1: headline1,
    headline2: headline2,
    line1: line1,
    line2: line2,
    line3: line3,
    quoteline1: quoteline1,
    quoteline2: quoteline2,

    name: name,
    tlf: tlf,
    email: email,
    picName: picName,
    author_uid: "exmHGPeyCKOh8m6xKuAgaJR3AQe2"
  };
  
  writeDB(collectionName, mylist);
  readBoss(bossCollection);
  readEmployer(employerCollection);
}
