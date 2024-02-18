/*<input type="checkbox" id="custom" name="laundry-type" value="custom">*/

function addEvent() {
    $('#order-date').on('change', () =>{
        const date = $('#order-date').val().split("-");
        const selectedDate = new Date(date[0], date[1]-1, date[2]);
        const deliveryDate = new Date(selectedDate.getTime() + (3 * 24 * 60 * 60 * 1000));

        $('#collection-date').empty();
        $('#delivery-date').empty();

        const options = { year:'numeric', month: 'short', day: 'numeric', weekday: 'short' };
        $('#collection-date').text("수거일 : " + selectedDate.toLocaleString('ko-KR', options));
        $('#delivery-date').text("배송일[예정 배송일] : " + deliveryDate.toLocaleString('ko-KR', options));
    })
}
$(document).ready(function () {
    const code = $('#client-code').val();
    const address = $('#client-address').val();
    console.log(code);
    console.log(address);

    $('#order-box').append(
        `<div class="laundry-info">
            <label for="custom">맞춤 세탁</label>
            <p>드라이클리닝, 웨트클리닝 등 제품 별 가장 알맞은 방식으로 세탁합니다.</p>
            <div class="cate-info">
                <span class="left-info">가능 품목</span>
                <span class="right-info">의류,신발,침구,커튼 등</span>
            </div>
        </div>
        <span><h1>수거일</h1></span><input type="date" id="order-date">
        <input type="button" onclick="validationOrder()" value="신청하기">`
    );
    // 날자 변경시 수거일, 배송일 변환 처리
    addEvent();
    // 내 정보에 맞는 간단 주문내역 보여주기
    setReceipt();
    // 수거일과 배송일 날짜 세팅
    setOrderDate();
})

function setOrderDate(){
    const now = new Date();
    let year = now.getFullYear();
    let month = String(now.getMonth()+1).padStart(2,'0');
    let nowDate = String(now.getDate()).padStart(2, '0');
    let newDate = `${year}-${month}-${nowDate}`;

    $('#order-date').val(newDate);
    const minDate = newDate;

    const max = new Date(now.getTime() + (7 * 24 * 60 * 60 * 1000));
    year = max.getFullYear();
    month = String(max.getMonth()+1).padStart(2,'0');
    nowDate = String(max.getDate()).padStart(2, '0');
    newDate = `${year}-${month}-${nowDate}`;
    const maxDate = newDate;

    $('#order-date').attr('min', minDate);
    $('#order-date').attr('max', maxDate);

    const date = $('#order-date').val().split("-");
    const selectedDate = new Date(date[0], date[1]-1, date[2]);
    const deliveryDate = new Date(selectedDate.getTime() + (3 * 24 * 60 * 60 * 1000));

    const options = { year:'numeric', month: 'short', day: 'numeric', weekday: 'short' };
    $('#collection-date').text("수거일 : " + selectedDate.toLocaleString('ko-KR', options));
    $('#delivery-date').text("배송일[예정 배송일] : " + deliveryDate.toLocaleString('ko-KR', options));
}

function setReceipt(){
    const address = $('#client-address').val();
    $('#receipt-box').append(
        `<div class="receipt-info">
            <span class="left-info">주문내용</span>
            <span class="right-info">맞춤세탁</span>
        </div>
        <div class="receipt-schedule">
            <p>일정</p>
            <p id="collection-date"></p>
            <p id="delivery-date"></p>
        </div>
        <div class="receipt-address">
            <p>주소</p>
            <p>${address}</p>
        </div>`
    )
}

function validationOrder(){
    const orderDate = $('#order-date').val().split("-");
    const selectedDate = new Date(orderDate[0], orderDate[1]-1, orderDate[2]);
    const code = $('#client-code').val();
    const deliveryDate = new Date(selectedDate.getTime() + (3 * 24 * 60 * 60 * 1000));

    $.ajax({
        "url": "/order/create",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "clientCode": code,
            "orderstatusCategoryCode": 1,
            "orderReviewIsWritten": false,
            "orderOrderDate": new Date(),
            "orderCollectionDate": selectedDate,
            "orderDeliveryDate": deliveryDate,
        })
    }).done(function (response) {
        const options = { month: 'short', day: 'numeric', weekday: 'short' };
        const printDate = selectedDate.toLocaleString('ko-KR', options);

        alert(`세탁 신청이 완료 되었습니다.\n수거일 : ${printDate}`);
        location.href= "/myOrderList";
    });

}