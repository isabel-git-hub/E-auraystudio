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
        
document.addEventListener('DOMContentLoaded', function() {
	let selectedCategory = null;
	let selectedColor = null;
	let selectedFeatures = [];

	const filterProducts = () => {
		const products = document.querySelectorAll('.product-item');
		products.forEach(product => {
			const categoryMatch = !selectedCategory || product.getAttribute('data-category') === selectedCategory;
			const colorMatch = !selectedColor || product.getAttribute('data-color') === selectedColor;
			const featureMatch = selectedFeatures.length === 0 || selectedFeatures.includes(product.getAttribute('data-feature'));

			if (categoryMatch && colorMatch && featureMatch) {
				product.style.display = 'block';
			} else {
				product.style.display = 'none';
			}
		});
	};

	// 카테고리 필터 클릭 이벤트
	const categoryFilters = document.querySelectorAll('.category-filter');
	categoryFilters.forEach(filter => {
		filter.addEventListener('click', function() {
			selectedCategory = this.getAttribute('data-category');
			filterProducts();
		});
	});

	// 색상 필터 클릭 이벤트
	const colorOptions = document.querySelectorAll('.color-option');
	colorOptions.forEach(option => {
		option.addEventListener('click', function() {
			selectedColor = this.getAttribute('data-color');
			filterProducts();
		});
	});

	// 기능 필터 체크박스 이벤트
	const featureCheckboxes = document.querySelectorAll('input[type="checkbox"]');
	featureCheckboxes.forEach(checkbox => {
		checkbox.addEventListener('change', function() {
			selectedFeatures = Array.from(document.querySelectorAll('input[type="checkbox"]:checked')).map(checkbox => checkbox.value);
			filterProducts();
		});
	});

	// 페이지 로드시 모든 제품을 기본으로 표시
	filterProducts();
});

/*window.addEventListener('DOMContentLoaded', () => {
    const scrollWrappers = document.querySelectorAll('.scrollable-wrapper');  // 모든 스크롤 가능한 영역 선택

    scrollWrappers.forEach(wrapper => {
        const leftArrow = wrapper.querySelector('.left-arrow');  // 좌측 화살표 선택
        const rightArrow = wrapper.querySelector('.right-arrow');  // 우측 화살표 선택
        const scrollableContainer = wrapper.querySelector('.scrollable-container');  // 스크롤할 컨테이너 선택

        const optionWidth = 150;  // 옵션 하나의 너비 (CSS의 min-width와 동일하게 설정)
        const optionGap = 20;  // 옵션 간의 간격 (CSS의 gap과 동일하게 설정)
        const scrollAmount = optionWidth + optionGap;  // 한 번에 하나의 옵션만큼 이동하도록 설정

        // 스크롤이 필요한지 여부 확인하는 함수
        const checkScroll = () => {
            if (scrollableContainer.scrollWidth > scrollableContainer.clientWidth) {
                leftArrow.style.display = 'block';
                rightArrow.style.display = 'block';
            } else {
                leftArrow.style.display = 'none';
                rightArrow.style.display = 'none';
            }
        };

        checkScroll();  // 페이지 로드 후 스크롤 가능 여부 체크

        // 왼쪽 화살표 클릭 시 좌측으로 하나의 옵션만큼 스크롤
        leftArrow.onclick = () => {
            scrollableContainer.scrollBy({
                left: -scrollAmount,  // 한 번에 하나의 옵션만큼 스크롤
                behavior: 'smooth'
            });
        };

        // 오른쪽 화살표 클릭 시 우측으로 하나의 옵션만큼 스크롤
        rightArrow.onclick = () => {
            scrollableContainer.scrollBy({
                left: scrollAmount,  // 한 번에 하나의 옵션만큼 스크롤
                behavior: 'smooth'
            });
        };

        // 윈도우 크기 변경 시에도 스크롤 상태 재확인
        window.addEventListener('resize', checkScroll);
    });
});
*/
window.addEventListener('DOMContentLoaded', () => {
    const leftArrow = document.querySelector('.left-arrow');
    const rightArrow = document.querySelector('.right-arrow');
    const scrollableContainer = document.querySelector('.scrollable-container');

    const optionWidth = 150;  // 옵션 하나의 너비
    const optionGap = 20;     // 옵션 간의 간격
    const scrollAmount = optionWidth + optionGap;  // 스크롤할 총 너비 계산 (옵션 하나의 너비 + 간격)

    // 왼쪽 화살표 클릭 시 좌측으로 스크롤
    leftArrow.addEventListener('click', () => {
        scrollableContainer.scrollBy({
            left: -scrollAmount,  // 왼쪽으로 옵션 하나 만큼 이동
            behavior: 'smooth'
        });
    });

    // 오른쪽 화살표 클릭 시 우측으로 스크롤
    rightArrow.addEventListener('click', () => {
        scrollableContainer.scrollBy({
            left: scrollAmount,  // 오른쪽으로 옵션 하나 만큼 이동
            behavior: 'smooth'
        });
    });
});
