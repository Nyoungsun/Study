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

}