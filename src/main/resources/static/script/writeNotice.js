const clientCode = $('#clientCode').val();

function writeNotice(){
    let check = true;
    const title = $('#title').val();
    const contents = $('#contents').val();
    if(title === "") {
        alert('제목이 입력되지 않았습니다.');
        check = false;
    }
    else if(contents === "") {
        alert('내용이 입력되지 않았습니다.');
        check = false;
    }

    if(check === true) {
    $.ajax({
        "url": "/board/write",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "boardCategoryCode": "2",
            "clientCode": clientCode,
            "boardTitle": title,
            "boardContent": contents
        }),
    }).done(function (response) {
        alert('공지사항작성완료!');
        location.href = "noticeList";
    });
    }else{
        location.href="writeNotice";
    }
}
