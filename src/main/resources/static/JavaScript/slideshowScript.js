//The code for slideshows was written by w3schools. 
//I just configured it to do 5 slides!
//https://www.w3schools.com/w3css/w3css_slideshow.asp

var slideIndex = 0;

$(function()
{
  showSlides();
});

function showSlides()
{
  var slides = document.getElementsByClassName("mySlides");
  var slides2 = document.getElementsByClassName("mySlides2");
  var slides3 = document.getElementsByClassName("mySlides3");
  var slides4 = document.getElementsByClassName("mySlides4");
  var dots = document.getElementsByClassName("dot");

  for (let i = 0; i < slides.length; i++) 
  {
    slides[i].style.display = "none";  
    slides2[i].style.display = "none"; 
    slides3[i].style.display = "none"; 
    slides4[i].style.display = "none"; 
  }

  slideIndex++;
  if (slideIndex > slides.length) 
  {
    slideIndex = 1
  }   
  for (i = 0; i < dots.length; i++) 
  {
    dots[i].className = dots[i].className.replace(" active", "");
  }

  slides[slideIndex-1].style.display = "block";  
  slides2[slideIndex-1].style.display = "block";  
  slides3[slideIndex-1].style.display = "block";  
  slides4[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 10000); // Change image every 10 seconds
}