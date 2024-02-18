let orderCode;
const search = location.search.substring(1).split('?');
search.forEach(e => {
    const data = e.split('=');
    if(data[0] === 'orderCode')
        orderCode = data[1];
});

const clientCode = $('#clientCode').val();
function writeReview(){

    let check = true;
    const title = $('#title').val();
    let contents = $('#contents').val();
    let imgUrl = $('#imgUrl').val();

    if(title === "") {
        alert('제목이 입력되지 않았습니다.');
        check = false;
    }
    else if(contents === "") {
        alert('내용이 입력되지 않았습니다.');
        check = false;
    }
    if(check === true) {

    let recontents = null;
    recontents = contents.replaceAll('\n', '<br>');
    recontents = recontents.replaceAll('\r\n', '<br>');
    $.ajax({
        "url": "/board/write",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "boardCategoryCode": "1",
            "clientCode": clientCode,
            "boardTitle": title,
            "boardContent": recontents,
            "boardViewCount": 1,
            "boardImg": imgUrl
        }),
    }).done(function (response) {
        updateIsWritten();
        alert('리뷰작성완료!');
        location.href = "list";
    });

    }else{
        location.href=`writeReview?orderCode=${orderCode}`;
    }
}

function updateIsWritten(){

    $.ajax({
        "url": `/order/updateIsWritten?orderCode=${orderCode}`,
        "method": "PUT",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
    });
}

