$(document).ready(function(){
  console.log("Loaded");
  // var capture = document.getElementById("capture");
    $("#submit").click(function(){
    	
    	var arr ={};
    	arr["name"] = $("#name").val();
    	arr["designation"] = $("#designation").val();
    	arr["dateOfBirth"] = $("#dateOfBirth").val()
    	arr["salary"] = $("#salary").val();
    	$.ajax({
    	    type: "POST",
    	    url: "/registerEmployee",
    	    contentType: "application/json; charset=utf-8",
    	    dataType: "json",
    	    data:JSON.stringify(arr),
    	    success: function(result) {
    	        if(result==true){
    	        	alert("Employee information Saved Successfully");
    	        }else{
    	        	alert("Fail to save employee Data");
    	        }
    	        location.reload();
    	    }
    	});
    });
});