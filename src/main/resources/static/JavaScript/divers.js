$(function()
{
  $("#includedMenubar").load("menubar");
  $("#includedFooter").load("footer");
});

function sendEmail()
{
  var name = document.getElementById("form-name").value; 
  var number = document.getElementById("form-number").value; 
  var email = document.getElementById("form-email").value; 

  var fulltext = "Firma navn: "+ name + " Tlf: "+ number +" Email: "+ email;

  window.open('mailto:thilde.rex@rexkyoo.com?subject=Kontakt RexKyoo&body=' + fulltext);
}