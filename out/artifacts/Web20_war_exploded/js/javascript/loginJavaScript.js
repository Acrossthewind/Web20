
// import "../jQuery/http_ajax.aspnetcdn.com_ajax_jquery_jquery-3.3.1"

$(function (){

    // -------------------------------------------------↓有关账号注册的

    $(".a-accountRegistration").click(function () {
        $(".login-box").fadeOut(1000)

        $("#login-container").removeClass();
        $("#login-container").addClass("login-container-account");

        setTimeout(function () {
            $(".accountRegistration-box").fadeIn(1000);
        },1000)

    })

    $("#return-button").click(function () {
        $(".accountRegistration-box").fadeOut(1000);
        setTimeout(function () {
            $("#login-container").removeClass();
            $("#login-container").addClass("login-container");

            setTimeout(function () {
                $(".login-box").fadeIn(1000)
            },1000)
        },1000)
    })

    $("#accountRegistration-button").click(function (){
        var account=$("#account").val();
        var password=$("#accountPassword").val();
        var passwordAgain=$("#accountPasswordAgain").val();
        $.ajax({
            url:"http://10.200.95.186:8080/Web20/insert",
            data:"action=insertUser"+"&username="+account+"&password="+password+"&passwordAgain="+passwordAgain,
            type:"Get",
            dataType:'text',
            success:function (rs){
                $("#pShowMsg").html(rs);

            }
        })

    })


    // -------------------------------------------------↑有关账号注册的



    // -------------------------------------------------↓有关重置密码的

    $(".a-resetPassword").click(function () {
        $(".login-box").fadeOut(1000);

        $("#login-container").removeClass();
        $("#login-container").addClass("login-container-resetPassword");

        setTimeout(function () {
            $(".resetPassword-box").fadeIn(1000);
        },1000)
    })

    $(".return-button-resetPassword").click(function () {
        $(".resetPassword-box").fadeOut(1000);
        setTimeout(function () {
            $("#login-container").removeClass();
            $("#login-container").addClass("login-container");

            setTimeout(function () {
                $(".login-box").fadeIn(1000)
            },1000)
        },1000)
    })

    $("#resetPassword-button").click(function (){
        var account=$("#account-resetPassword").val();
        var password=$("#password-resetPassword").val();
        var newPassword=$("#newPassword-resetPassword").val();
        var newPasswordAgain=$("#newPasswordAgain-resetPassword").val();

        $.ajax({
            url:"http://10.200.95.186:8080/Web20/update",
            data:"action=update"+"&username="+account+"&password="+password+"&newPassword="+newPassword+"&newPasswordAgain="+newPasswordAgain,
            type:"Get",
            dataType:'text',
            success:function (rs){
                $("#pShowMsg1").html(rs);

            }
        })

    })


    // -------------------------------------------------↑有关重置密码的




    // -------------------------------------------------↓有关登录选择的（学生、教师）

    $(".student-login-option").click(function (){
        $("#login-choose-div").removeClass();
        $("#login-choose-div").addClass("login-choose-div_student");
        $("#choose").attr("value","student")
    })

    $(".teacher-login-option").click(function (){
        $("#login-choose-div").removeClass();
        $("#login-choose-div").addClass("login-choose-div_teacher");
        $("#choose").attr("value","teacher")
    })

    // -------------------------------------------------↑有关登录选择的（学生、教师）


    // ----------------------------------------------------↓有关文字切换的

    setInterval(()=>{changeText()},10000);
    var arrText = ["广大青年要肩负历史使命，坚定前进信心，立大志、明大德、成大才、担大任，努力成为堪当民族复兴重任的时代新人，让青春在为祖国、为民族、为人民、为人类的不懈奋斗中绽放绚丽之花",
        "世界是你们的，也是我们的，但是归根结底是你们的。你们青年人朝气蓬勃，正在兴旺时期，好像早晨八、九点钟的太阳。希望寄托在你们身上。",
        "青年一代的成长，正是我们事业必定要兴旺发达的希望所在。",
        "党和人民对全国各族青年寄予殷切期望，希望你们在改革开放和社会主义现代化建设的伟大实践中，以自己的青春活力和满腔热血，为祖国和人民建立杰出的功绩！"]
    var arrAuthor = ["——习近平","——毛泽东","——邓小平","——江泽民"]


    var count = 0;
    var changeText = async function (){
        if (count === 4){
            count = 0;
        }

        $(".redText").fadeOut(0);


        $(".sentence").html(arrText[count]);
        $(".author").html(arrAuthor[count]);


        $(".redText").fadeIn(3000);


        count++;

    }

    // ----------------------------------------------------↑有关文字切换的

    // ----------------------------------------------------↓有关图标的

    $("#weiXin-icon").mouseover(function (){
        $("#weiXin-ewm").show();
    })
    $("#weiXin-icon").mouseout(function (){
        $("#weiXin-ewm").hide();
    })
    $("#xinLang-icon").mouseover(function (){
        $("#xinLang-ewm").show();
    })
    $("#xinLang-icon").mouseout(function (){
        $("#xinLang-ewm").hide();
    })
    $("#douYin-icon").mouseover(function (){
        $("#douYin-ewm").show();
    })
    $("#douYin-icon").mouseout(function (){
        $("#douYin-ewm").hide();
    })

    $("#weiXin-ewm").hide();
    $("#douYin-ewm").hide();
    $("#xinLang-ewm").hide();

    // ----------------------------------------------------↑有关图标的



    // setTimeout(()=>{changeText()},2000); //只执行一次


})