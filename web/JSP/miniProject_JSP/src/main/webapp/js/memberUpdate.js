
function check() {
	document.getElementById("checkNameDiv").innerText = "";
	document.getElementById("checkIdDiv").innerText = "";
	document.getElementById("checkPwDiv").innerText = "";
	document.getElementById("checkRePwDiv").innerText = "";
	document.getElementById("checkGenderDiv").innerText = "";
	document.getElementById("checkEmailDiv").innerText = "";

	if (document.writeForm.name.value == "") {
		document.getElementById("checkNameDiv").innerText = "이름을 입력하세요."
	}
	else if (document.writeForm.id.value == "") {
		document.getElementById("checkIdDiv").innerText = "아이디를 입력하세요."
	}
	else if (document.writeForm.pw.value == "") {
		document.getElementById("checkPwDiv").innerText = "비밀번호를 입력하세요."
	}
	else if (document.writeForm.pw_check.value == "") {
		document.getElementById("checkRePwDiv").innerText = "재확인을 입력하세요."
	}
	else if (document.writeForm.pw.value != document.writeForm.pw_check.value) {
		document.getElementById("checkRePwDiv").innerText = "비밀번호 재확인이 맞지않아요."
	}
	else if (document.writeForm.gender.value == "") {
		document.getElementById("checkGenderDiv").innerText = "성별을 선택하세요."
	}
	else if (document.writeForm.email1.value == "") {
		document.getElementById("checkEmailDiv").innerText = "이메일 첫번째 칸을 입력하세요."
	}
	else if (document.writeForm.email2.value == "") {
		document.getElementById("checkEmailDiv").innerText = "이메일 두번째 칸을 입력하세요."
	}
	else {
		document.writeForm.submit();
	}
}

function checkId() {
	if (document.writeForm.id.value == "") {
		document.getElementById("checkIdDiv").innerText = "먼저 아이디를 입력하세요."
	} else {
		var url = "checkId.jsp?id=" + document.writeForm.id.value;
		window.open(url, "checkId",
			"width=300 height=150 left=900 top=200"); //같은 이름은 하나만 열린다
	}
}

function inputId() {
	document.writeForm.idCheck.value = "0";
}

function select() {
	if (document.writeForm.mail_select.value == 'self') {
		document.writeForm.email2.readOnly = false;
		document.writeForm.email2.value = '';
		document.writeForm.email2.focus();
	}
	else {
		document.writeForm.email2.readOnly = true;
		document.writeForm.email2.value = document.writeForm.mail_select.value;
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
			document.getElementById("d_zipcode").value = data.zonecode;
			document.getElementById("d_addr1").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("d_addr2").focus();
		}
	}).open();
}