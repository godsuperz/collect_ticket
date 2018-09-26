$(document).ready(function () {

    // 获取热词列表
    $.getJSON("/getHotWords", function (data, status) {
        if (status === "success" && $.trim(data['status']) === '200') {
            $.each(data["data"], function (index, value) {
                $("#hotWord").append('<li><a href="/search?k=' + value["name"] + '">'+ value["name"] +'</a></li>');
            })
        } else {
            console.log(data['msg']);
        }
    });

    // 点击搜索按钮
    $(".search-btn").click(function (e) {
        e.preventDefault();

        var keyWord = $("#inp").val();

        location.href = "/search?k=" + keyWord;
    })
});