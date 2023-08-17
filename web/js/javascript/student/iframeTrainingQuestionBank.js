$(function () {
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


        $("#button-examKnow-id").click(function () {
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
            console.log(length)

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
                success:function (rs){
                    alert("success")
                    var count=rs.count
                    score=rs.score
                    var accuracy=rs.accuracy
                    var msgSuccess=rs.msgSuccess
                    var msgError=rs.msgError

                    var arrSuccess = msgSuccess.split(",");
                    var arrError = msgError.split(",");

                    var arrSuccessSpan ="";
                    var arrErrorSpan = "";

                    for (let i = 0; i < arrSuccess.length-1; i++) {
                        arrSuccessSpan +=
                            $('input:radio[name="' + arrSuccess[i] + '"]:checked')
                                .parent().children(".stem").children(".questionNum").text()
                        if (i!==arrSuccess.length-2){
                            arrSuccessSpan +=",";
                        }
                    }

                    for (let i = 0; i < arrError.length-1; i++) {
                        arrErrorSpan +=
                            $('input:radio[name="' + arrError[i] + '"]:checked')
                                .parent().children(".stem").children(".questionNum").text()
                        if (i!==arrError.length-2){
                            arrErrorSpan +=",";
                        }
                    }

                    $("#countP").html("一共作答："+count);
                    $("#scoreP").html("成绩："+score);
                    $("#successP").html("正确："+arrSuccessSpan);
                    $("#errorP").html("错误："+arrErrorSpan);
                    $("#accuracyP").html("正确率："+accuracy+"%");

                },
                error: function(rs) {
                    console.log('请求失败');
                }
            })







        })

    })





