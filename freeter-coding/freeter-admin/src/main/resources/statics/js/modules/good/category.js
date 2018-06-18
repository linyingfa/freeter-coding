var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "categoryId",
            pIdKey: "parentId",
            rootPId: "-1"
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

function getchannelList() {//获取下拉学校列表
	$.ajax({
		url : baseURL +"good/channel/getChannelList",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : 'data',
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
				alert("请先添加频道数据")
			} 
				$('#search_channelId').append(
						"<option value=''>所有频道 </option>");
			$.each(data.data, function(i) {
				$('#channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
				$('#search_channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#channelId').selectpicker('refresh');
 			$('#channelId').selectpicker('val', '');
 			$('#channelId').selectpicker('render');
 			$('#search_channelId').selectpicker('refresh');
 			$('#search_channelId').selectpicker('val', '');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}


var Menu = {
    id: "menuTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Menu.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '分类ID', field: 'categoryId', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '分类名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '频道名称', field: 'channelName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '分类类型', field: 'type', align: 'center', valign: 'middle', sortable: true, width: '100px', formatter: function(item, index){
            if(item.type === 0){
                return '<span class="label label-primary">总目录</span>';
            }
            if(item.type === 1){
                return '<span class="label label-success">一级分类</span>';
            }
            if(item.type === 2){
                return '<span class="label label-warning">二级分类</span>';
            }
        }},
        {title: '是否显示', field: 'status', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
       	 if(item.status === 0){
                return '<span class="label label-primary">隐藏</span>';
            }
            if(item.status === 1){
                return '<span class="label label-success">显示</span>';
            }
       }},
       {title: '导航栏是否显示', field: 'showInNav', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
      	 if(item.showInNav === 0){
               return '<span class="label label-primary">隐藏</span>';
           }
           if(item.showInNav === 1){
               return '<span class="label label-success">显示</span>';
           }
      }},
      {title: '是否置顶', field: 'showInTop', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
     	 if(item.showInTop === 0){
              return '<span class="label label-primary">默认</span>';
          }
          if(item.showInTop === 1){
              return '<span class="label label-success">置顶</span>';
          }
     }},
     {title: '是否热门', field: 'status', align: 'center', valign: 'middle', sortable: true, width: '80px', formatter: function(item, index){
    	 if(item.status === 0){
             return '<span class="label label-primary">默认</span>';
         }
         if(item.status === 1){
             return '<span class="label label-success">热门</span>';
         }
    }},
        {title: '排序', field: 'sort', align: 'center', valign: 'middle', sortable: true, width: '100px'} 

        ]
    return columns;
};


function getMenuId () {
    var selected = $('#menuTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return null;
    } else {
        return selected[0].id;
    }
}


$(function() {
	 var colunms = Menu.initColumn();
	    var table = new TreeTable(Menu.id, baseURL + "good/category/getCategoryTreeTable", colunms);
	    table.setExpandColumn(1);
	    table.setIdField("categoryId");
	    table.setCodeField("categoryId");
	    table.setParentCodeField("parentId");
	    table.setExpandAll(true);
	    table.setData(vm.search);
	    table.init();
	    Menu.table = table;
	$(".selectpicker").selectpicker({  
	    noneSelectedText : '请选择'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	getchannelList();
	 
});

var vm = new Vue({
	el : '#rrapp',
	data : {
		showList : true,
		title : null,
		search:{
			channelId:''
		},
		category : {
			  	parentName:null,
	            parentId:0,
	            type:1,
	            orderNum:0
			
		}
	},
	methods : {
		  getMenu: function(menuId){
	            //加载菜单树
	            $.get(baseURL + "good/category/getCategorylist", function(r){
	                ztree = $.fn.zTree.init($("#menuTree"), setting, r.data);
	                console.info(ztree.getNodes()    );
	                var node = ztree.getNodeByParam("categoryId", vm.category.parentId);
	                ztree.selectNode(node);
	                vm.category.parentName = node.name;
	                Vue.set(vm.category, 'parentName', node.name)

	            })
	        },
		query : function() {
			vm.search.channelId =$('#search_channelId').selectpicker('val');
			vm.reload();
		},
		add : function() {
			vm.category = {parentName:null,parentId:0,type:1,orderNum:0,sort:0,status:1,showInNav:0,showInTop:0,showInHot:0};
			vm.showList = false;
			vm.title = "新增";
			 vm.getMenu();
		},
		update : function(event) {
			   var categoryId = getMenuId();
	            if(categoryId == null){
	                return ;
	            }
		
			$.get(baseURL + "good/category/info/" + categoryId, function(r) {
				vm.showList = false;
				vm.category = r.category;
				 Vue.set(vm.category, 'parentName','');
				vm.title = "修改";
				vm.getMenu();
				$('#channelId').selectpicker('val', vm.category.channelId);
 			});
 		},
		saveOrUpdate : function(event) {
 
 			vm.category.channelId =$('#channelId').selectpicker('val');
			var url = vm.category.categoryId == null ? "good/category/save"
					: "good/category/update";
			$.ajax({
				type : "POST",
				url : baseURL + url,
				contentType : "application/json",
				data : JSON.stringify(vm.category),
				success : function(r) {
					if (r.code === 0) {
						alert('操作成功', function(index) {
							vm.reload();
						});
					} else {
						alert(r.msg);
					}
				}
			});
		},
		del : function(event) {
			var categoryIds = getMenuId();
			if (categoryIds == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type : "POST",
					url : baseURL + "good/category/delete",
 					data : {"categoryIds":categoryIds},
					success : function(r) {
						if (r.code == 0) {
							alert('操作成功', function(index) {
								  Menu.table.refresh();
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
        menuTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    if(node[0].type == 2){
                    	alert("不能选择二级分类");
                    	return false;
                    }
                     if( node[0].categoryId == 0){
                    	 vm.category.type =1;
                    	 
                    }else{
                     vm.category.type =2;
                    }
                  
                 	$('#channelId').selectpicker('val',    node[0].channelId);
                    
                    //选择上级菜单
                    vm.category.parentId = node[0].categoryId;
                    vm.category.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
		getInfo : function(categoryId) {
			$.get(baseURL + "good/category/info/" + categoryId, function(r) {
				vm.showList = false;
				vm.category = r.category;
 
 			});
		},
		reload : function(event) {
			 vm.showList = true;
	            Menu.table.refresh();
		}
	}
	


});