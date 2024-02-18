$(document).ready(function () {
    Itemcategory();
    itemSubclassification();
});


function Itemcategory() {
    $.ajax({
        "url": "/itemcategory/searchall",
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
        response.forEach((content, index) => {
            $('.item-container').append(
                `<div class="item" id="item${index + 1}">
                <div class="category">
                    <div class="category-kind"><p>${content.itemCategoryKind}</p></div>
                    <div class="category-info"><p>${content.itemCategoryInfo}</p></div>
                </div>
                <table class="subclassification">
                <thead>
                <tr>
                <th class="item-kind">품목</th>
                <th class="item-price">가격</th>
                </tr>
                </thead>
                <tbody id="subcategory${index + 1}">
                </tbody>
                </table>
            </div>`
            )
        })
    });
}


function itemSubclassification() {
    $.ajax({
        "url": "/item/searchall",
        "method": "POST",
        "timeout": 0,
    }).done(function (response) {
        console.log(response);
        response.forEach(content => {
            $(`#subcategory${content.itemCategoryCode}`).append(
                `<tr>
                <td class="item-kind">${content.itemName}</td>
                <td class="item-price">${content.itemPrice}원</td>
            </tr>`
            )
        })
    });
}


