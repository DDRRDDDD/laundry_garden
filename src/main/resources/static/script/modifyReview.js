let boardSeq = 0;
window.onload = () => {
const params = location.search.substring(1).split('&');

params.forEach(e => {
    const data = e.split('=');
    if(data[0] === 'boardSeq') {
        boardSeq = data[1];
    }
})
    ready();
}
function ready(){
$.ajax({
    "url": `/review/getOne?boardSeq=${boardSeq}`,
    "method": "POST",
    "timeout": 0,
}).done(function (response) {
    let recontents = null;
    recontents = response.boardContent.replaceAll('<br>', '\n');
    recontents = recontents.replaceAll('<br>', '\r\n');
    $('#title').val(response.boardTitle);
    $('#contents').val(recontents);
    $('#img').attr('src',response.boardImg);

});

}

function updateReview(){

    const title = $('#title').val();
    const contents = $('#contents').val();
    let imgUrl = $('#imgUrl').val();
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

    let recontents = null;
    recontents = contents.replaceAll('\n', '<br>');
    recontents = recontents.replaceAll('\r\n', '<br>');
    $.ajax({
        "url": `/board/modify`,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "boardTitle": title,
            "boardContent": recontents,
            "boardSeq": `${boardSeq}`,
            "boardImg": imgUrl
        }),
    }).done(function (response) {
        alert('리뷰가 수정되었습니다!');
        location.href = "list";
    }).fail(error =>{
        alert('리뷰 수정실패');
        location.href = "list";
    });
    }else{
        location.reload();
    }
}

function deleteImg(){
    let src = $('#img').attr('src');
    if(src === "" || src === "null" || src === null){
        alert('삭제할 이미지가 존재하지 않습니다');
    }else{

    const title = $('#title').val();
    const contents = $('#contents').val();
    let recontents = null;
    recontents = contents.replaceAll('\n', '<br>');
    recontents = recontents.replaceAll('\r\n', '<br>');
    $.ajax({
        "url": `/board/modify`,
        "method": "PUT",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({
            "boardTitle": title,
            "boardContent": recontents,
            "boardImg": '',
            "boardSeq": `${boardSeq}`
        }),
    }).done(function (response) {
        alert('이미지가 삭제되었습니다!');
        ready();
    }).fail(error =>{
        alert('이미지 삭제실패');
        location.reload();
    });
    }
}

