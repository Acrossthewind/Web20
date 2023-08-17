$(function (){


    $(".button-iframeLiteratureText").click(function (){

        $(".div-iframeLiteratureText").fadeOut(500);
        setTimeout(function (){
            $(".div-iframeLiteratureText").hide();
        },500);

    })

    $(".a-readText-Literature").click(function (){

        $(".div-iframeLiteratureText").fadeIn(500);
        setTimeout(function (){
            $(".div-iframeLiteratureText").show();
        },500);
    })

})