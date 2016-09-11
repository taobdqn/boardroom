

function checkall(){
	var time=$("input[name='time']").val();
	var userName=$("input[name='userName']").val();
	if(time==""||userName==""){
		alert("预定人和时间不能为空!");
		return false;
	}	
	return true;
}
function checkTime() {
	var destine_time = $("input[name='time']").val();
	var reg = /^\d{4}-\d{1,2}-\d{1,2}$/;
	if (reg.test(destine_time) == false) {
		alert("预定日期格式不正确！");
		return false;
	}
	return true;
}
