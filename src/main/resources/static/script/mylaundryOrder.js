/*
$(document).ready(function () {
    myorders();
})

function myorders() {
    $.ajax({
        "url": "/myoders",
        "method": "POST",
        "timeout": 0
    }).done(function (response) {
        console.log(response);
        $('#myorders').empty()
        response.forEach(order => {
            if (!order.orderReviewIsWritten && order.orderstatusCategoryKind === '배송 완료') {
                $('#myorders').append(`
        	        <tr>
                        <td>${order.orderCode}</td>
                        <td>${order.orderstatusCategoryKind}</td>
                        <td>${order.orderOrderDate.split("T")[0]}</td>
                        <td>${order.orderPaymentDate ? order.orderPaymentDate.split("T")[0] : ""}</td>
                        <td>${order.orderCollectionDate.split("T")[0]}</td>
                        <td>${order.orderDeliveryDate ? order.orderDeliveryDate.split("T")[0] : ""}</td>
                        <td><input type="button" value="주문상세" onclick="location.href='mylaundryorderDetail?orderCode=${order.orderCode}'"></td>
                        <td><input type="button" value="리뷰작성" onclick="location.href='writeReview?orderCode=${order.orderCode}'"></td>
			        </tr>`
                )
            } else {
                $('#myorders').append(`
        	        <tr>
                        <td>${order.orderCode}</td>
                        <td>${order.orderstatusCategoryKind}</td>
                        <td>${order.orderOrderDate.split("T")[0]}</td>
                        <td>${order.orderPaymentDate ? order.orderPaymentDate.split("T")[0] : ""}</td>
                        <td>${order.orderCollectionDate.split("T")[0]}</td>
                        <td>${order.orderDeliveryDate ? order.orderDeliveryDate.split("T")[0] : ""}</td>
                        <td><input type="button" value="주문상세" onclick="location.href='mylaundryorderDetail?orderCode=${order.orderCode}'"></td>
                        <td></td>
			        </tr>`
                )
            }
        })
    });
}*/
