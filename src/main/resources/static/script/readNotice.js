const params = location.search.substring(1).split('&');

let boardSeq = 0;
params.forEach(e => {
    const data = e.split('=');
    if(data[0] === 'boardSeq') {
        boardSeq = data[1];
    }
})
const logClientCode = $('#clientCode').val();

if(boardSeq !== 0) {
    $.ajax({
        "url": `/notice/getOne?boardSeq=${boardSeq}`,
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        $('#contents-container').append(
            `
        <div class="title">${response.boardTitle}</div>
        <div>${response.boardContent}</div>
        <div class="modDate">수정일 : ${response.boardEditDate.toString().split("T")[0]}</div>
            `
        );
        if(logClientCode.toString() === "9999") {
            $('#button-box').append(`
                <div><input type="button" value="수정" onclick="location.href='modifyNotice?boardSeq=${boardSeq}'"></div>
                <div><input type="button" value="삭제" onclick="deleteNotice()"></div>
            `)
        }
    }).fail(error => {
        history.back();
    })
}
else {
    history.back();
}
