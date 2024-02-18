
$(document).ready(function (){
    const orderCode = $('#orderCode').val();
    updateStatus(orderCode);
});

function updateStatus(orderCode){
    $.ajax({
        "url": `/order/changeStatus?statusCode=4&orderCode=${orderCode}`,
        "method": "PUT",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
        alert("결제가 완료되었습니다.")
        // 결제 시간 등록
        paymentDateUpload(orderCode);
    });
}

function paymentDateUpload(orderCode){
    $.ajax({
        "url": `/order/registPaymentDate?orderCode=${orderCode}`,
        "method": "PUT",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
    });
}