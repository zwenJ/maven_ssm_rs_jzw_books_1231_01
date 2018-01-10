/**
 * 修改商品状态的方法
 * @param bookid
 * @param value
 */
function fun_update(bookid, value){
    $.post("book/updatebooks/list_books1.controller",{
        bookId: bookid,
        bookStatus: value,
        pages: 1
    },function(_result){
        _result = _result.trim();
        if ("success" == _result) {
            alert("操作成功！");
            location.replace("/books/book/select/manager/books/list_books1.controller?status="+(value-1));
        }
        else {
            alert("操作失败！");
        }
    });
}

/**
 * 删除商品
 * @param bookid
 * @param bookstatus
 */
function fun_delete(bookid) {
    if (confirm("你确定要删除？该操作不可逆转！")) {
        $.post("book/deletebook.controller",{
            bookId:bookid
        },function (_result) {
            if ("success" == _result.trim()){
                //刷新页面
                location.replace("/books/book/select/manager/books/list_books1.controller?status=1");
            }
            else {
                alert("删除失败！")
            }
        });
    }
}



function fun_update_order(orderid, value){
    $.post("/books/order/updateorder.controller",{
        orderId: orderid,
        orderStatus: value
    },function(_result){
        _result = _result.trim();
        if ("success" == _result) {
            alert("操作成功！");
            location.replace("/books/order/showorder/user/orders/order.controller?status=2");
        }
        else {
            alert("操作失败！");
        }
    });
}