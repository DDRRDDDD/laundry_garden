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
        "url": `/review/getOne?boardSeq=${boardSeq}`,
        "method": "POST",
        "timeout": 0
    }).done(function (response) {
        $('#contents-container').append(
            `
        <div class="title">${response.boardTitle}</div>
        <ul>
            <li>작성자 : ${response.name}</li>
            <li class="modDate">수정일 : ${response.boardEditDate.toString().split("T")[0]}</li>
        </ul>
        <div>${response.boardContent}</div>
            `
        );
        if(response.boardImg !== "" || response.boardImg !== null || response.boardImg !== "null" ){
        $('#contents-container').append(`
        <div><img src="${response.boardImg }" onerror="this.style.display='none'" alt='' /></div>
            `
        );
        }

        if(logClientCode.toString() === response.clientCode.toString()) {
            $('#button-box').append(`
                <div><input type="button" value="수정" onclick="location.href='modifyReview?boardSeq=${boardSeq}'"></div>
                <div><input type="button" value="삭제" onclick="deleteReview()"></div>
            `)
        }
    }).fail(error => {
        history.back();
    })
}
else {
    history.back();
}
