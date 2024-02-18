window.onload = () => {
    let page = 1;
    const search = location.search.substring(1).split('?');
    search.forEach(e => {
        const data = e.split('=');
        if (data[0] === 'page')
            page = parseInt(data[1]);
    });
    changePage(page);
}

function changePage(page) {

    $.ajax({
        "url": `/review/page?page=${page}`,
        "method": "GET",
        "timeout": 0
    }).done(response => {
        $('#contents-container').empty();
        response.forEach(content => {
            $('#contents-container').append(`
        	<tr>
				<td>${content.boardSeq}</td>
				<td><a href="readReview?boardSeq=${content.boardSeq}">${content.boardTitle}</a></td>
				<td>${content.name}</td>
				<td>${content.boardRegDate.toString().split("T")[0]}</td>
				<td>${content.boardViewCount}</td>
			</tr>
        `)
        })
    });
}

$.ajax({
    "url": "/review/getAll",
    "method": "POST",
    "timeout": 0,
}).done(function (response) {
    let count = 0;
    response.forEach(content => {
        count++;
    })
    let pageSize = 10;
    let totalPages = Math.ceil(count / pageSize);
    let currentPage = 1;
    pageBox(totalPages, currentPage);
});

function pageBox(totalPages, currentPage) {
    $('#page-box').empty();
    for (let i = 1; i <= totalPages; i++) {
        if (i === currentPage) {
            $('#page-box').append(`
				<span onclick='changePage(${i})' >${i}</span>
			`);
        } else {
            $('#page-box').append(`
				<span onclick='changePage(${i})'>${i}</span>
			`);
        }
    }
}
//===========================================================================
function searchNotice(page) {
    const category = $('select[name="category"] option:selected').val();
    const keyword = $('input[name="keyword"]').val();
    if (category === '1') {
        title(keyword);
    } else if (category === '2') {
        content(keyword);
    } else if (category === '3') {
        titleAndContent(keyword);
    }
    
}


function pageBoxByTitle(totalPages, currentPage) {
    $('#page-box').empty();
    for (let i = 1; i <= totalPages; i++) {
        if (i === currentPage) {
            $('#page-box').append(`
				<span onclick='title(${i})' >${i}</span>
			`);
        } else {
            $('#page-box').append(`
				<span onclick='title(${i})'>${i}</span>
			`);
        }
    }
}




function title(keyword) {
    $.ajax({
        "url": `/review/search/byTitle?text=${keyword}`,
        "method": "GET",
        "timeout": 0,
    }).done(function (response) {
        $('#contents-container').empty();
        response.forEach(content => {
            $('#contents-container').append(`
        	<tr>
				<td>${content.boardSeq}</td>
				<td><a href="readReview?boardSeq=${content.boardSeq}">${content.boardTitle}</a></td>
				<td>${content.name}</td>
				<td>${content.boardRegDate.toString().split("T")[0]}</td>
				<td>${content.boardViewCount}</td>
			</tr>
        `);
            let count = 0;
            response.forEach(content => {
                count++;
            })
            let pageSize = 10;
            let totalPages = Math.ceil(count / pageSize);
            let currentPage = 1;
            pageBoxByTitle(totalPages, currentPage);
        })
    });
}

function content(keyword) {

}

function titleAndContent(keyword) {

}



