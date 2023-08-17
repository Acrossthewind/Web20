$(function (){


    var examKnowFlag = 0;

    var secs = 10;
    $("#button-examKnow-id").click(function (){
        $("#button-closeModal-id").attr("disabled",true);

        for (let i = 0; i <= secs; i++) {
            setTimeout(function (){
                if (i===10){
                    $("#button-closeModal-id").html("我已仔细阅读上述条款");
                    $("#button-closeModal-id").attr("disabled",false);
                    return;
                }
                $("#button-closeModal-id").html("我已仔细阅读上述条款( "+(secs-i)+" )");
            },i*1000)
        }
    })

    $("#button-examSubmit-id").click(function (){
        if (confirm("您是否交卷，请检查卷面完毕后点击确定（注意：动作无法撤销）")){
            //数据库比对题目正确与否，计算分数后录入数据库
        }
    })


    $("#button-closeModal-id").click(function (){
        alert("考试开始!")
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/test",
            data:"action=findAll",
            type:"Post",
            dataType:"json",
            success:function (rs){
                var html="<form id='questionForm_id' >";
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
                html=html+" <div >\n" +
                    "<button id=\"button-examSubmit-id\" class=\"btn btn-danger mybtn\" type='button'>交卷</button>\n"+
                    "</div>"+"</form>";


                setTimeout(function() {
                    $(function (){$(".question-box").html(html)})
                },10);

                setTimeout(function() {
                        $("#button-examSubmit-id").click(function () {
                            submit();
                        });
                },50);

                setTimeout(function () {
                    $(function () {
                        /*alert("已加载")*/
                        $(".Question input").click(function () {
                            var clickSelect = $(this).attr("value");
                            /*alert(clickSelect);*/
                            $(this).parent().children(".stem").children(".questionAnswer").html(clickSelect.toString())

                        })
                    })
                },50)

            },error:function(rs){
                alert("error");
            }
        })
    })


    let submit = function () {

        alert("交卷成功！可重复做题，取最后一次作为成绩");
        var length
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/test",
            data:"action=findAll",
            type:"Post",
            dataType:"json",
            async:false,
            success:function (rs){
                length=rs.length;
            }
        })

        var myAnswers= {};
        for(var i=1; i<=length; i++){
            var data=$('input:radio[name="' + i + '"]:checked').val()
            myAnswers[i] = data;

        }
        var score="";
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/comp",
            data:myAnswers,
            type:"Post",
            dataType:"json",
            async:false,
            success:function (rs){

                score=rs.score
                $("#scoreDiv").html("成绩："+score+"分");

            },
            error: function(rs) {
                console.log('请求失败');
            }
        })

        //插入成绩
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/score",
            data:"score="+score,
            type:"Post",
            dataType:"json",
            success:function (rs){
                console.log(rs.msg)
            },
            error: function(rs) {
                console.log('请求失败');
            }
        })







    }









})