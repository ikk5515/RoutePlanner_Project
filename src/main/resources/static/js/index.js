function setVisible(){
    var f = document.querySelector('form');
    f.style.visibility = "visible";
    f.style.top= 0;
    f.style.transition = "1s";

    var body = document.querySelector('body');
    body.style.backgroundColor = "#F5DBAE";
    body.style.transition = "1s";
}


var widS = 0;
function beforeSlide(){
    if(widS < 1000) return;
    widS -= 1000;
    if(widS != 3000){
        document.querySelector('.submit').style.display = "none";
    }
    var d = document.querySelector('.paneWrap');
    d.style.left = `-${widS}px`;
    d.style.transition = "0.5s";
}
function nextSlide(){ 
    widS += 1000;
    if(widS == 3000){
        document.querySelector('.submit').style.display = "inline-block";    
    }
    if(widS > 3000) return;
    var d = document.querySelector('.paneWrap');
    d.style.left = `-${widS}px`;
    d.style.transition = "0.5s";
}
function slideOut(){
    var sur = doucument.querySelector('form');
    sur.style.top = "100%";  
}


/* ---------------------------------------------------- */

function pageGo(){
    if(confirm('감사합니다!')){
        document.location.href = './header.html';
    }else{

    }
}