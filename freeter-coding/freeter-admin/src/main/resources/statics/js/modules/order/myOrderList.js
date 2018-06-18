$(function () {
    $("#seleceType").bind("change",function(){
        var selectTypeValue=$(this).val();
        if(selectTypeValue=="userName"){
            $(".form-control")[0].placeholder="请输入用户名";
        }else if(selectTypeValue=="tel"){
            $(".form-control")[0].placeholder="请输入收货人电话";
        }else{
            $(".form-control")[0].placeholder="请输入订单号";
        }
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'order/myOrderList',
        datatype: "json",
        colModel: [
            { label: '用户名', name: 'userName', width: 80 },
            { label: '订单编号', name: 'orderNo', width: 80 },
            { label: '订单金额', name: 'totalAmount',  width: 80  },
            { label: '收货人', name: 'consignee',  width: 80 },
            { label: '订单提交时间', name: 'strCreatedTime', width: 80  },
            { label: '收货地址', name: 'address',width:80},
            { label: '收货人电话', name: 'tel', width: 80 },
            { label: '配送方式', name: 'expressType', width: 80 },
            { label: '快递信息', name: 'expressMsg',width: 80},
            { label: '订单状态', name: 'orderStatus', width: 80 },

            {
                label: '订单商品', name: '', index: 'operate', width: 80, align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                    var detail="<input type='button' value='查看' onclick='getOrderGood(\""+rowObject.orderId+"\")'>";
                    return detail;
                }
            },
            { label: '订单id',  name:'orderId',width:80,hidden:'true'}


        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: false,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            sel: null
        },
        showList: true,
        showGoodList:true,
        title: null,
        orderModel:{},
        orderGoodModel:{},
        selectType:null


    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            var selectType=$("#selectType").val();
            console.log(selectType);
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{"selectValue":vm.q.sel ,"selectType":selectType},
                page:page
            }).trigger("reloadGrid");
        },
        update:function(event){
            //var rowId=$("#jqGrid").jqGrid("getGridParam","selrow");
            var rowId=getSelectedRow();
            var orderId = $("#jqGrid").jqGrid("getRowData",rowId).orderId;
            if(orderId == null){
                return ;
            }
            vm.showList = false;
            vm.showGoodList=true;
            vm.title = "修改";
            vm.getInfo(orderId);
        },
        saveOrUpdate: function (event) {
            var url = vm.orderModel.orderId == null ? "order/save" : "order/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.orderModel),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getInfo: function(orderId){
            $.get(baseURL + "order/info/"+orderId, function(r){
                vm.orderModel = r.orderModel;
            });
        }

    }
});
var i=0;
function getOrderGood(orderId){
    i++;
    if(i>1){
        $("#goodTable").jqGrid("setGridParam",{
            url: baseURL + 'order/good/'+orderId
        }).trigger("reloadGrid");
    }
    console.log(orderId);
        vm.showGoodList=false;
        $("#goodTable").jqGrid({
                url:baseURL+'order/good/'+orderId,
                datatype: "json",
                colModel: [
                    { label: '商品名称', name: 'goodTitle', width: 200 },
                    { label: '商品规格', name: 'goodSpec', width: 400},
                    { label: '单价', name: 'unitPrice', width: 200},
                    { label: '购买数量', name: 'goodCount',  width: 300 }
                ],
                viewrecords: true,
                height: 200,
                rowNum: 10,
                rowList : [10,30,50],
                rownumbers: true,
                rownumWidth: 25,
                autowidth:true,
                multiselect: false,
                pager: "#orderGoodPager",
                jsonReader : {
                    root: "page.list",
                    page: "page.currPage",
                    total: "page.totalPage",
                    records: "page.totalCount"
                },
                prmNames : {
                    page:"page",
                    rows:"limit",
                    order: "order"
                },
                gridComplete:function(){
                    //隐藏grid底部滚动条
                    $("#goodTable").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
                }
            }
        )


}

function delivery(orderId){
    layer.closeAll();
    layer.open({
        type:1,
        title:"填写物流信息",
        maxmin:true,
        area:['400px','267px'],
        content:$("#delivery"),
        btn:['保存','返回'],
        success:function(){
            $("#delivery").show();
        },
        yes:function(){
            debugger
            var expressNumber=$("input[name='expressNumber']").val();
            var expressCompany=$("#expressCompany").val();
            $.post("/order/delivery",{"orderId":orderId,"expressNumber":expressNumber,"expressCompany":expressCompany},function(r){
                   layer.closeAll();
                   layer.alert("发货成功",{icon:6},function () {
                       layer.closeAll();
                       $("#jqGrid").jqGrid('setGridParam',{
                           url:baseURL + 'order/orderSelectList'
                       }).trigger("reloadGrid");
                   });
                }
            );

        }

        }
    )
}




