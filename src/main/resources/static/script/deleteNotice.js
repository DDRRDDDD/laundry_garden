function deleteNotice() {
    if (boardSeq !== 0) {

        $.ajax({
            "url": `/board/remove?boardSeq=${boardSeq}`,
            "method": "DELETE",
            "timeout": 0
        }).done(response => {
            alert('공지사항이 삭제되었습니다');
            location.href = 'noticeList';
        }).fail(error => {
            alert('잘못된 접근입니다. ');
        })
    } else {
        history.back();
    }

}
