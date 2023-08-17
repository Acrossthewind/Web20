$(function (){



    setTimeout(function () {
        $("#studentJump").removeClass();
        $("#studentJump").addClass("studentJump1");
        setTimeout(function () {
            $("#studentJump").hide();
        },1000);
    },500);





    $("#li_20exam").click(function (){


        $("#student-choose-div-id").removeClass();
        $("#student-choose-div-id").addClass("student-choose-div_20exam");
        $("#student-iframe-id").attr("src","iframe20Exam.html");
    })
    $("#li_literature").click(function (){

        $("#student-choose-div-id").removeClass();
        $("#student-choose-div-id").addClass("student-choose-div_literature");
        $("#student-iframe-id").attr("src","iframeLiterature.html")
    })
    $("#li_question_bank").click(function (){



        $("#student-choose-div-id").removeClass();
        $("#student-choose-div-id").addClass("student-choose-div_question_bank");
        $("#student-iframe-id").attr("src","iframeTrainingQuestionBank.html")
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/test",
            data:"action=findAll",
            type:"Post",
            dataType:"json",
            success:function (rs){
                var html="<form id='questionForm_id' action=''>";
                for(var i=0;i<rs.length;i++){
                    var id=rs[i].id;
                    var question=rs[i].question;
                    var answer1=rs[i].answer1;
                    var answer2=rs[i].answer2;
                    var answer3=rs[i].answer3;
                    var answer4=rs[i].answer4;
                    html+="<div class=\"Question\">"+"<div class=\"stem\">"+
                       "<span class=\"questionNum\" style=\"float: left\"  >"+(i+1)+"</span>" +
                        "<p style=\"float: left;\" >"+question+"</p>"+
                        "<span>(</span>"+"<span class=\"questionAnswer\"></span>"+
                        "<span>)</span>"+
                        "</div>"+"<br>"+"<input type=\"radio\" name="+id+" value=\"A\" >"+
                        "<p>"+answer1+"</p>"+
                        "<input type=\"radio\" name="+id+" value=\"B\" >"+
                        "<p>"+answer2+"</p>"+
                        "<input type=\"radio\" name="+id+" value=\"C\" >"+
                        "<p>"+answer3+"</p>"+
                        "<input type=\"radio\" name="+id+" value=\"D\" >"+
                        "<p>"+answer4+"</p>"+"</div>"+"</div>"
                }
                html=html+"</form>";

                setTimeout(function() {
                    $(function (){$("#student-iframe-id").contents().find(".question-box").html(html)})
                },10);

                /*$("#student-iframe-id").contents().find(".question-box").html(html)*/
                /*console.log(html)*/
            },error:function(rs){
                alert("error");
            }
        })
    })
    $("#li_video").click(function (){

        $("#student-choose-div-id").removeClass();
        $("#student-choose-div-id").addClass("student-choose-div_video");
        $("#student-iframe-id").attr("src","iframeVideo.html")
    })


})