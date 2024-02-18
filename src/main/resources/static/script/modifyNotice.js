const params = location.search.substring(1).split('&');

let boardSeq = 0;
params.forEach(e => {
    const data = e.split('=');
    if(data[0] === 'boardSeq') {
        boardSeq = data[1];
    }
})
$.ajax({
    "url": `/notice/getOne?boardSeq=${boardSeq}`,
    "method": "POST",
    "timeout": 0,
}).done(function (response) {
    $('#title').val(response.boardTitle);
    $('#contents').val(response.boardContent);
});

function updateNotice(){

    const title = $('#title').val();
    const contents = $('#contents').val();
    let check = true;
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
        "url": `/board/modify`,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "boardTitle": title,
            "boardContent": contents,
            "boardSeq": `${boardSeq}`
        }),
    }).done(function (response) {
        alert('공지사항이 수정되었습니다!');
        location.href = "noticeList";
    }).fail(error =>{
        alert('공지사항 수정실패');
    });
    }else{
        location.reload();
    }
}
