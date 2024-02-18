function deleteReview() {
    if (boardSeq !== 0) {

        $.ajax({
            "url": `/board/remove?boardSeq=${boardSeq}`,
            "method": "DELETE",
            "timeout": 0
        }).done(response => {
            alert('게시글이 삭제되었습니다');
            location.href = 'list';
        }).fail(error => {
            alert('잘못된 접근입니다. ');
        })
    } else {
        history.back();
    }

}

