const doc = document.getElementById("alert");
const form = document.writeform;

function check() {
	doc.innerText = ""
	if (form.name.value == "") {
		doc.innerText = "이름을 입력하세요."
	}
	else if (form.id.value == "") {
		doc.innerText = "아이디를 입력하세요."
	}
	else if (form.pw.value == "") {
		doc.innerText = "비밀번호를 입력하세요."
	}
	else if (form.pw_check.value == "") {
		doc.innerText = "재확인을 입력하세요."
	}
	else if (form.pw.value != form.pw_check.value) {
		doc.innerText = "비밀번호 재확인이 맞지않아요."
	}
	else if (form.gender.value == "") {
		doc.innerText = "성별을 선택하세요."
	}
	else if (form.email_1.value == "") {
		doc.innerText = "이메일 첫번째 칸을 입력하세요."
	}
	else if (form.email_2.value == "") {
		doc.innerText = "이메일 두번째 칸을 입력하세요."
	}
	else {
		form.submit();
	}
}

function select() {
	if (form.mail_select.value == 'self') {
		form.email_2.readOnly = false;
		form.email_2.value = '';
		form.email_2.focus();
	}
	else {
		form.email_2.readOnly = true;
		form.email_2.value = form.mail_select.value;
	}
}

function search() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("post").value = data.zonecode;
                document.getElementById("addr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addr2").focus();
            }
        }).open();
    }