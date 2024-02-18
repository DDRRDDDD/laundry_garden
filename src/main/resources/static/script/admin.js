function selorderstatus(orderCode, clientCode) {
    window.open(`statusPopup?orderCode=${orderCode}&clientCode=${clientCode}`, 'pop01', 'top=50, left=150, width=550, height=500, status=no, menubar=no, toolbar=no, resizable=no')
}

function categorizeLaundry(code) {
    window.open(`categorizePopup?orderCode=${code}`, 'pop01', 'top=50, left=150, width=550, height=500, status=no, menubar=no, toolbar=no, resizable=no');
}

function orderDatails(code) {
    window.open(`orderDetailsPopup?orderCode=${code}`, 'pop01', 'top=50, left=150, width=550, height=500, status=no, menubar=no, toolbar=no, resizable=no');
}

function changeStatus(orderCode, clientCode) {

    if(confirm("상태를 변경하시겠습니까?")){
        let statusCode = $(event.target).val();

        $.ajax({
            "url": `order/changeStatus?statusCode=${statusCode}&orderCode=${orderCode}`,
            "method": "PUT",
        }).done(function () {
            window.opener.location.reload();
            getToken(statusCode, clientCode);
        });
    }
}

function getToken(statusCode, clientCode) {
    $.ajax({
        "url": `getToken?clientCode=${clientCode}`,
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        pushMessage(statusCode, response);
    });
}

function pushMessage(statusCode, token) {
    let message;
    if(statusCode === "2")
        message = "세탁물 수거가 완료되었습니다!"
    else if(statusCode === "3")
        message = "세탁물 분류가 완료되었습니다!\n결제를 완료해주세요."
    else if(statusCode === "8")
        message = "세탁물 배송이 완료되었습니다!\n또 이용해 주세요!"
    else
        message = "";
    console.log(message)
    console.log(statusCode)
    if(message !== ""){
        $.ajax({
                "url": "push",
                "method": "POST",
                "timeout": 0,
                "headers": {
                    "Content-Type": "application/json"
                },
                "data": JSON.stringify({
                    "message": {
                        "token": token,
                        "notification": {
                            "title": "세정원",
                            "body": message
                        }
                    }
                }),
            }).done(function () {
                console.log("메세지 발송");
                window.close();
        });
    }
}


// 세탁물 분류 팝업창 내부
$('.tabcontent .items').hide();
$('.tabnav a').click(function() {
    if (this.hash === '#clothes') {
        $('.tabcontent tr').hide().filter('[id="1"]').show();
    } else if(this.hash === '#bedding') {
        $('.tabcontent tr').hide().filter('[id="2"]').show();
    } else if(this.hash === '#shoes') {
        $('.tabcontent tr').hide().filter('[id="3"]').show();
    } else if(this.hash === '#living') {
        $('.tabcontent tr').hide().filter('[id="4"]').show();
    } else if(this.hash === '#stroller') {
        $('.tabcontent tr').hide().filter('[id="5"]').show();
    } else if(this.hash === '#car-seat') {
        $('.tabcontent tr').hide().filter('[id="6"]').show();
    } else if(this.hash === '#leather') {
        $('.tabcontent tr').hide().filter('[id="7"]').show();
    }
    $('.tabnav a').removeClass('active');	// css tab 이벤트때문에 추가해주는 class
    $(this).addClass('active');
    return false;
}).filter(':eq(0)').click();

// 세탁물 분류 데이터 입력
function setOrderDetail(orderCode) {
    const requests = [];
    $('.items').filter(function() {
        return $(this).find('#amount').val() > 0;
    }).each(function() {
        const itemCode = $(this).find('#itemCode').val();
        const orderDetailsAmount = $(this).find('#amount').val();
        const orderDetailsPrice = $(this).find('#price').val();
        const request = $.ajax({
            "url": `orderDetailsPro`,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "orderCode" : orderCode,
                "itemCode" : itemCode,
                "orderDetailsAmount" : orderDetailsAmount,
                "orderDetailsPrice" : orderDetailsPrice
            })
        });
        requests.push(request);
    });
    $.when.apply($, requests).done(function() {
        alert("성공적으로 완료되었습니다.");
        window.close();
    }).fail(function() {
        alert("오류가 발생했습니다.");
    });
}
