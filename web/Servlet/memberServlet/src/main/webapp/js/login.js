const form = document.loginform;

function check_login() {
	document.getElementById("id_check").innerText = ""
	document.getElementById("pw_check").innerText = ""
	
	if (form.login_id.value == "") {
		document.getElementById("id_check").innerText = "아이디를 입력하세요."
	}
	else if (form.login_pw.value == "") {
		document.getElementById("pw_check").innerText = "비밀번호를 입력하세요."
	}
	else {
		form.submit();
	}
}