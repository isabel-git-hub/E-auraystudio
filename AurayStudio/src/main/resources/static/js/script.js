var url = new URL(window.location.href);
var error = url.searchParams.get('error');

if (error != null) {
    document.getElementById('msg').innerText = "※ 아이디 또는 패스워드가 잘못되었습니다.";
}

function checkLoginForm() {
    const form = document.loginForm;
    const userid = document.getElementById('userid').value;
    const userpw = document.getElementById('userpw').value;

    if (userid.length < 3 || userid.length > 8) {
        window.alert('아이디는 3~8자로 입력해주세요.');
        form.userid.focus();
        return;
    }
    if (userpw.length < 4 || userpw.length > 20) {
        window.alert('패스워드는 4~20자로 입력해주세요.');
        form.userpw.focus();
        return;
    }
    form.submit();
}

function checkId() {
    var snd_data = $("#userid").val();
    $.ajax({
        type: "get",
        dataType: "text",
        async: true,
        url: "http://localhost:8080/checkid",
        data: { data: snd_data },
        success: function (data) {
            console.log("Response from server:", data);
            if (data === "true") {
                $("#id-area").html("<p>※ 사용 가능한 아이디입니다.</p>");
            } else {
                $("#id-area").html("<p>※ 사용할 수 없는 아이디입니다.</p>");
            }
        },
        error: function (xhr, textStatus, errorThrown) { // 에러 핸들링
            console.log("Error occurred:", textStatus, errorThrown);
            window.alert("에러가 발생했습니다.");
        }
    });
}

function checkJoinForm() {
    const form = document.joinForm;
    const userid = document.getElementById('userid').value;
    const userpw = document.getElementById('userpw').value;
    const username = document.getElementById('username').value;
    const birthdate = document.getElementById('birthdate').value;
    const genderM = document.getElementById('genderM').checked;
    const genderF = document.getElementById('genderF').checked;
    const telnumber = document.getElementById('telnumber').value;
    const addr = document.getElementById('addr').value;
    const email = document.getElementById('email').value;

    console.log("Form values:", {
        userid, userpw, username, birthdate, genderM, genderF, telnumber, addr, email
    });

    if(userid.length < 3 || userid.length > 8) {
        window.alert('3~8자 입력');
        form.userid.focus();
        return;
    }
    if(userpw.length < 4 || userpw.length > 20) {
        window.alert('4~20자 입력');
        form.userpw.focus();
        return;
    }
    if(username == '') {
        window.alert('이름을 입력해주세요.');
        form.username.focus();
        return;
    }
    if(birthdate == '') {
        window.alert('생년월일을 입력해주세요.');
        form.birthdate.focus();
        return;
    }
    if(!genderM && !genderF) {
        window.alert('성별을 입력해주세요.');
        return;
    }
    if(telnumber == '') {
        window.alert('전화번호를 입력해주세요.');
        form.telnumber.focus();
        return;
    }
    if(addr == '') {
        window.alert('주소를 입력해주세요.');
        form.addr.focus();
        return;
    }
    if(email == '') {
        window.alert('이메일을 입력해주세요.');
        form.addr.focus();
        return;
    }
    window.alert("회원가입이 완료되었습니다.");
    form.submit();
    //location.href='../index.html';
}

function checkFormJquery() {
    const form = $('#joinForm');
    const userid = $('#userid').val();
    const userpw = $('#userpw').val();
    const username = $('#username').val();
    const birthdate = $('#birthdate').val();
    const genderM = $('#genderM').is(':checked');
    const genderF = $('#genderF').is(':checked');
    const telnumber = $('#telnumber').val();
    const addr = $('#addr').val();

    if(userid.length < 3 || userid.length > 8) {
        window.alert('아이디는 3~8자로 입력해주세요.');
        $('#userid').focus();
        return;
    }
    if(userpw.length < 4 || userpw.length > 20) {
        window.alert('패스워드는 4~20자로 입력해주세요.');
        $('#userpw').focus();
        return;
    }
    if(username == '') {
        window.alert('이름을 입력해주세요.');
        $('#username').focus();
        return;
    }
    if(birthdate == '') {
        window.alert('생년월일을 입력해주세요.');
        $('#birthdate').focus();
        return;
    }
    if(!genderM && !genderF) {
        window.alert('성별을 입력해주세요.');
        return;
    }
    if(telnumber == '') {
        window.alert('전화번호를 입력해주세요.');
        $('#telnumber').focus();
        return;
    }
    if(addr == '') {
        window.alert('주소를 입력해주세요.');
        $('#addr').focus();
        return;
    }
    window.alert("회원가입이 완료되었습니다.");
    form.submit();
}

function findPw() {
    window.open('/findpw','비밀번호 찾기','width=420,height=400,scrollbars=no,resizable=no,history=no,status=no,menubar=no');
}

function findId() {
    window.open('/findId','아이디 찾기','width=420,height=400,scrollbars=no,resizable=no,history=no,status=no,menubar=no');
}


function validateForm() {
            var consentCheckbox = document.getElementById("consentCheckbox");
            if (!consentCheckbox.checked) {
                alert("개인정보 처리에 동의해주셔야 합니다.");
                return false;
            }
            return true;
        }