function submitForm(url) {
    const form = document.getElementById('authentication');
    form.action = url;
    form.submit();
}

function logValidation(isLoggedIn) {
    if (isLoggedIn === true) {
        location.href = "/login";
    } else {
        location.href = "/myPage";
    }
}

function orderorderValidation(isLoggedIn) {
    if (isLoggedIn === true) {
        alert('로그인 화면으로 이동합니다.');
        location.href = '/login';
    } else {
        location.href = '/order';
    }
}

function inquiry(value) {
    location.href = value;
}

function generalLogin() {
    $('#error-message').remove();
    const request = {
        'clientEmail': $('#clientEmail').val(),
        'clientPassword': $('#clientPassword').val()
    };
    fetch('/login/loginPro', {
        method: "POST",
        headers: {'Content-Type': 'application/json; charset=UTF-8'},
        body: JSON.stringify(request)
    }).then((response) => {
        return response.json();
    }).then((data) => {
        if (data === true) {
            location.href = "/";
        } else {
            $('#login-error').append(`
            <p id="error-message">${data.errorMessage}</p>`
            );
        }
    });

}

function errorValidator(data){

    if(data.clientEmail !== undefined){
        $('#email-error').append(`<p class="error-message">${data.clientEmail}</p>`);
    }
    if(data.clientPassword !== undefined){
        $('#password-error').append(`<p class="error-message">${data.clientPassword}</p>`);
    }
    if(data.clientName !== undefined){
        $('#name-error').append(`<p class="error-message">${data.clientName}</p>`);
    }
    if(data.clientPhone !== undefined){
        $('#phone-error').append(`<p class="error-message">${data.clientPhone}</p>`);
    }
    if(data.clientAddress !== undefined){
        $('#address-error').append(`<p class="error-message">${data.clientAddress}</p>`);
    }
    if(data.isDuplication !== undefined){
        $('#registration-error').append(`<p class="error-message">${data.isDuplication}</p>`);
    }
}

function keepValues(values){
    $('#clientName').val(values.clientName);
    $('#clientPassword').val(values.clientPassword);
    $('#clientEmail').val(values.clientEmail);
    $('#clientPhone').val(values.clientPhone);
    $('#clientAddress').val(values.clientAddress);
}
function registration(){
    $(`.error-message`).remove();
    const request = {
        'clientName' : $('#clientName').val(),
        'clientPassword' : $('#clientPassword').val(),
        'clientEmail' : $('#clientEmail').val(),
        'clientPhone' : $('#clientPhone').val(),
        'clientAddress': $('#clientAddress').val()
    };
    fetch('/regist/registPro',{
        method: "POST",
        headers:{'Content-Type': 'application/json; charset=UTF-8'},
        body: JSON.stringify(request)
    }).then(response => {
        return response.json()
    }).then(data => {
        if(data === true){
            // location.href="/";
        }else{
            errorValidator(data);
            keepValues(request);
        }
    });
}

function kakaoLogin() {
    const REST_API_KEY = "19f3073e18916acec0a298992f4eda22";
    const REDIRECT_URI = "https://laundrygarden.store/login/KAKAO";
    const kakaoAuthorize = "https://kauth.kakao.com/oauth/authorize";
    const kakaoAuthUrl = `${kakaoAuthorize}?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;
    location.href = kakaoAuthUrl;
}

