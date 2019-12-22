$(document).ready(function(){
	$('#test').DataTable();
	$(".delete").click(function(){
		var empId1 = $(this).attr('empId');
		var employee = {};
		employee['id'] = empId1;
		 $.ajax({
	            url: '/deleteEmpData',
	            type: 'post',
	            contentType: 'application/json',
	            success: function (data) {
	            	if(data == "success"){
						alert("Record deleted")	
						
	                }else{
	                	alert("Fail to delete");
	                }
	            	location.reload();
	            },
	            error: function ( error ) {
	            	alert(error);
	            },
	            data: JSON.stringify(employee)
	        });
	});
	
	$(".edit").click(function(){
		renderContent(this);
	});
	function renderContent(element){
		bootbox.dialog({
			title: "Edit User",
			message: renderPopupContent(element),
			buttons: {
				ok: {
					label: "Submit",
					className: 'btn-success',
					callback:function(){
							var type="POST";
							var data=getDataFromForm();
							$.ajax({
								url: "/editEmployeeData",
								contentType: 'application/json',
								type: "POST",
								data: JSON.stringify(data),
								success: function(result){
									if(result=="success"){
										alert("Edited Successfully");
									}else{
										alert("Fail to update Data");
									}
									location.reload();
								}
							}); 


					}
				},

				cancel: {
					label: "Cancel",
					className: 'btn-danger',

				},

			}
		
	});
	}
	function renderPopupContent(elem){
		var arr=[];

		arr.push('<div class="form-horizontal" id="updateStatus_dlg">');
		arr.push('    <div class="form-group hidden">');
		arr.push('        <label class="col-sm-4 control-label no-padding-right">UserId</label>');
		arr.push('        <div class="col-sm-5">');
		arr.push('            <input type="text" class="form-control" id="id" value="'+$(elem).attr('empId')+'" readonly/>');
		arr.push('        </div>');
		arr.push('    </div>');


		arr.push('    <div class="form-group">');
		arr.push('        <label class="col-sm-4 control-label no-padding-right">Name</label>');
		arr.push('        <div class="col-sm-5">');
		arr.push('            <input type="text" class="form-control" id="name" value="'+$(elem).attr('name')+'"/>');
		arr.push('        </div>');
		arr.push('    </div>');
		
		arr.push('    <div class="form-group">');
		arr.push('        <label class="col-sm-4 control-label no-padding-right">Designation</label>');
		arr.push('        <div class="col-sm-5">');
		arr.push('            <input type="text" class="form-control" id="designation" value="'+$(elem).attr('designation')+'"/>');
		arr.push('        </div>');
		arr.push('    </div>');
		
		arr.push('    <div class="form-group">');
		arr.push('        <label class="col-sm-4 control-label no-padding-right">DOB</label>');
		arr.push('        <div class="col-sm-5">');
		arr.push('            <input type="text" class="form-control" id="dateOfBirth" value="'+$(elem).attr('dob')+'"/>');
		arr.push('        </div>');
		arr.push('    </div>');
		
		arr.push('    <div class="form-group">');
		arr.push('        <label class="col-sm-4 control-label no-padding-right">Salary</label>');
		arr.push('        <div class="col-sm-5">');
		arr.push('            <input type="text" class="form-control" id="salary" value="'+$(elem).attr('salary')+'"/>');
		arr.push('        </div>');
		arr.push('    </div>');
		
		arr.push('</div>');
		return arr.join('');
	}
	function getDataFromForm(){
		var data = {};
		data['id'] = $("#id").val();
		data['name'] = $("#name").val();
		data['designation'] = $("#designation").val();
		data['dateOfBirth'] = $("#dateOfBirth").val();
		data['salary'] = $("#salary").val();
		return data;
		
	}
});