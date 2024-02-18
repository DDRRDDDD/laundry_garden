$(document).ready(function () {
    const orderCode = $('#orderCode').val();
    orderDetailHistory(orderCode);
})

function orderDetailHistory(orderCode) {

    $.ajax({
        "url": `/orderdetailHistory?orderCode=${orderCode}`,
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
        $('#orderdetails').empty();
        let totalPrice = 0;
        let count = 0;
        let orderCode = "";
        response.forEach( order => {
            $('#orderdetails').append(
                `<tr>
                 <td>${++count}</td>
                 <td>${order.itemCategoryKind}</td>
                 <td>${order.itemName}</td>
                 <td>${order.itemPrice}원</td>
                 <td>${order.orderDetailsAmount}</td>
                 <td>${order.subtotal}원</td>
                </tr>`
            )
            totalPrice += order.subtotal;
            orderCode = order.orderCode;
        })
        if( totalPrice > 0){
            $('#total-price').text(`총계 : ${totalPrice} 원`);
        }else{
            $('#total-price').text("상세항목이 존재 하지 않습니다.");
        }
        orderstatusValidation(orderCode,totalPrice,count,orderCode);
    });
}


// 결제 대기에서만 결제 버튼 생성
function orderstatusValidation(orderCode,totalPrice,count,orderCode){
    $.ajax({
        "url": `/order/orderByorderCode?orderCode=${orderCode}`,
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
        const statusCode = response.orderstatusCategoryCode;
        console.log(response.orderstatusCategoryCode);
        console.log("statusCode : ",statusCode);
        if(statusCode === 3){
            $('#payment').append(
                `<input type="hidden" id="totalPrice" name="totalPrice" value="${totalPrice}">
                 <input type="hidden" id="count" name="count" value="${count}">
                 <input type="hidden" id="orderCode" name="orderCode" value="${orderCode}">
                 <button>카카오페이 결제</button>`)}
    });
}