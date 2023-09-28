/**
 * Created by Administrator on 2016/8/4.
 */

var workTitle, Publisher, currentID, workTime, flag = true;

function Workload() {
    $(function () {
        $('#table').bootstrapTable({
            url: "http://localhost:8080/WorkRecord/SearchWork",
            cache: false, //
            striped: true,
            pageList: [5,10,15],
            pageNumber: 1,
            pageSize: 10,
            paginationNextText: "下一页",
            paginationPreText: "上一页",
            sidePagination: "server",
            showRefresh: true,
            pagination: true,
            showPaginationSwitch: true,
            smartDisplay: false,
            contentType: "application/x-www-form-urlencoded",
            queryParams: function () {
                return {
                    pageSize: this.pageSize,
                    pageNumber: this.pageNumber,
                    id: $("#tit").val(),
                    username: $("#person").val(),
                    createTime: $("#demo").val()
                }
            },
            onLoadSuccess(res) {
                console.log(res)
            },
            columns: [
                {
                    checkbox: "true",
                    field: 'ID',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: "日志编号",
                    field: 'id',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '用户编号',
                    field: 'customerid',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '发布人',
                    field: 'username',
                    align: 'center'
                },
                {
                    title: '发布时间',
                    field: 'createTime',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '发布内容',
                    field: 'workContext',
                    align: 'center'
                },
                {
                    title: '操作',
                    field: 'id',
                    align: 'center',
                    formatter: function (value, row) {
                        var e = '<button button="#" mce_href="#" onclick="delWork(\'' + row.WORKRECORDID + '\')">审批</button> '

                        return e;
                    }
                }
            ]
        });
    });
    getWorkTableData();
}

function getWorkTableData() {
    if (flag) {
        workTitle = "";
        Publisher = "";
        workTime = "";
        flag = false;
    } else {
        workTitle = $("#tit").val();
        Publisher = $("#person").val();
        workTime = $("#demo").val();

    }
    // $.ajax({
    //     type: "GET",
    //     data: {id: workTitle, username: Publisher, createTime: workTime},
    //     url: "http://localhost:8080/WorkRecord/SearchWork",
    //     dataType: "json",
    //     success: function (result) {
    //         if (result) {
    //             console.log(result.records)
    //             var NoticeTableData = result.records;
    //             $('#table').bootstrapTable("load", NoticeTableData);
    //         }
    //     }
    // })
}

function addWork() {
    openlayer()
    currentID = "";
}

function editWork(id) {
    openlayer()
    currentID = id;
}

function outWork(id) {
    alert(id)
    var NoticeId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NoticeId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("删除成功！")
                // getNoticeTableData();
            } else {
                alert("删除失败")
            }
        },
        error: function (err) {
        }
    });
}

function getCurrentID() {
    return currentID;
}

function openlayer() {
    layer.open({
        type: 2,
        title: '通知信息',
        shadeClose: true,
        shade: 0.5,
        skin: 'layui-layer-rim',
        closeBtn: 2,
        area: ['98%', '98%'],
        shadeClose: true,
        closeBtn: 2,
        content: "http://localhost:8080/work_tail"

    });

}





