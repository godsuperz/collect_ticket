$(document).ready(function () {

    // 当前页数
    var currPage = 1;

    var keyWord = $("#inp").val();

    // 地址列表
    var addressItem = $("#filter-address-item");
    // 类型列表
    var categoryItem = $("#filter-category-item");
    // 时间列表
    var timeItem = $("#filter-time-item");

    var city = addressItem.find(".on").text();
    var type = categoryItem.find(".on").text();
    var time = getTime();
    // 初次加载页面

    city = checkCity(city);
    type = checkType(type);

    var data = {
        "keyword" : keyWord,
        "city" : city,
        "type" : type,
        "time" : time,
        "currPage" : 1
    };

    var url = "/searchTicket";
    searchAjax(url, data);

    // 初始化'大家都在搜'
    $.getJSON("/getEveryoneLookFor", function (data, status) {
        if (status === "success" && $.trim(data['status']) === '200') {
            var index = coin();
            var ticket = data.data[index];
            $("#everyoneLookForDesc").append('<a href="javascript:void(0)" class="img" style="background-image: url(' + ticket.img + ')">\n' +
                '<p id="everyoneLookForDesc" class="">\n' + ticket.name + '</p></a>');
        } else {
            console.log(status);
        }
    });

    // 掷硬币
    function coin() {
        return Math.random() < 0.5 ? 1 : 0;
    }
    
    // 检查城市是不是全部
    function checkCity(city) {
        if (city === "全部") {
            city = "";
        }
        return city;
    }

    // 检查类型是不是全部
    function checkType(type) {
        if (type === "全部") {
            type = "";
        }
        return type;
    }
    
    // 过去时间过滤器
    function getTime() {
        var text = $.trim(timeItem.find(".on").text());
        if (text === "全部") {
            return 0;
        }
        if (text === "一周内") {
            return 1;
        }
        if (text === "一个月内") {
            return 2;
        }
        if (text === "三个月内") {
            return 3;
        }
        if (text === "12月") {
            return 4;
        }
        if (text === "明年") {
            return 5;
        }
        return 0;
    }

    // 发起异步请求
    function searchAjax(url, data) {
        $.post(url, data, function (returnData, status) {
            if (status === "success" && $.trim(returnData['status']) === "200") {
                $.each(returnData.data, function (index, ticket) {
                    $(".ticketList").append('<div class="collect-item ticket-item"><a href="/item/' + $.trim(ticket.id) +
                        '"><div class="clit-img" style="background-image:url('+ ticket.img +
                    ')"></div></a><div class="clit-info"> <h3> <a href="/item/' + $.trim(ticket.id) +
                        '">'+ ticket.name+' </a> </h3> <p class="lisa">时 间：'+ ticket.showtime +
                        '</p> <p class="lisa">场 馆： ['+ ticket.cityname + '] ' + ticket.venue +
                            '</p> <p class="lisa">票价： <span class="rmb">￥</span> <span class="num">'+ ticket.price + '~' + ticket.pricehigh +
                        '</span> </p> <p class="support"></p> <div class="ct"> <span class="tag"><a href="#">在线选座</a> </span> <span class="tag">' +
                        '<a href="#">电子票</a> </span> </div> </div> <div class="clit-btn"> <span> <a href="'+ ticket.img +
                        '" class="btn bg-fe5d36">立即购票</a> </span> <span class="f-atten"> <a href="javascript:void(0)' +
                        '" class="btn"> <i class="yen">+</i>关注 </a> </span> </div> <div class="clear"></div> </div>');
                });
                toggleCheckMore(returnData.number);
            } else {
                console.log("请求失败！");
            }
        }, "json");
    }

    // 查看更多按钮开关
    function toggleCheckMore(restPage) {
        if (restPage > 0) {
            $("#checkMoreBtn").show();
        } else {
            $("#checkMoreBtn").hide();
        }
    }

    var cityItem = $(".cityItem");
    var citySize = cityItem.length;

    // 城市列表折叠函数
    function collapse() {

        if (citySize > 24){
            $.each(cityItem, function (index, value) {
                if (index > 23){
                    $(value).hide();
                    $(value).next().hide();
                }
            });

            $(".filter-more").html("&gt;&gt;")
        }
    }

    // 城市列表展开函数
    function expansion() {

        if (citySize > 24){
            $.each($(".cityItem"), function (index, value) {
                if (index > 23){
                    $(value).show();
                    $(value).next().show();
                }
            });

            $(".filter-more").html("&lt;&lt;")
        }
    }

    // 城市列表展开与折叠
    $(".filter-more").click(function (e) {
        e.preventDefault();

        var off = "&gt;&gt;";
        var on = "&lt;&lt;";
        var status = $(this).html();
        if (status === off) {
            expansion();
        }
        if (status === on) {
            collapse();
        }
    });

    // 选择地点
    cityItem.click(function (e) {
        e.preventDefault();

        // 重置页数
        currPage = 1;
        $("#filter-address-item").find(".on").removeClass("on");
        $(this).addClass("on");
        $(".ticketList").empty();
        var formData = {
            "keyword" : keyWord,
            "city" : checkCity(addressItem.find(".on").text()),
            "type" : checkType(categoryItem.find(".on").text()),
            "time" : getTime(),
            "currPage" : currPage
        };
        searchAjax(url, formData);
    });

    // 选择类型
    $(".typeItem").click(function (e) {
        e.preventDefault();

        // 重置页数
        currPage = 1;
        $("#filter-category-item").find(".on").removeClass("on");
        $(this).addClass("on");
        $(".ticketList").empty();
        var formData = {
            "keyword" : keyWord,
            "city" : checkCity(addressItem.find(".on").text()),
            "type" : checkType(categoryItem.find(".on").text()),
            "time" : getTime(),
            "currPage" : currPage
        };
        searchAjax(url, formData);
    });

    // 选择时间
    $(".timeItem").click(function (e) {
        e.preventDefault();

        // 重置页数
        currPage = 1;
        $("#filter-time-item").find(".on").removeClass("on");
        $(this).addClass("on");
        $(".ticketList").empty();
        var formData = {
            "keyword" : keyWord,
            "city" : checkCity(addressItem.find(".on").text()),
            "type" : checkType(categoryItem.find(".on").text()),
            "time" : getTime(),
            "currPage" : currPage
        };
        searchAjax(url, formData);
    });

    // 获取更多
    $("#checkMoreBtn").click(function (e) {
        e.preventDefault();

        currPage = currPage + 1;
        console.log(currPage);
        var formData = {
            "keyword" : keyWord,
            "city" : checkCity(addressItem.find(".on").text()),
            "type" : checkType(categoryItem.find(".on").text()),
            "time" : getTime(),
            "currPage" : currPage
        };
        searchAjax(url, formData);
    });

});