<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
		$("#addURL").click(function(){
		    var $lastRow = $("[id$=blah] tr:not('.ui-widget-header'):last"); //grab row before the last row
		    var $newRow = $lastRow.clone(); //clone it
		    var lastId = $lastRow.find(":text").attr('id');
		    var newId = parseInt(lastId) + 1;
		    $newRow.find(":text").val(""); //clear out textbox values    
		    $newRow.find(":text").attr("id",newId);
		    $newRow.find(":text").attr("name","webModel["+newId+"].url");
		    $lastRow.after($newRow); //add in the new row at the end
		});
		
	});
	
	</script>
</head>
<body>
	<h3>Enter Url to Monitor</h3>

	<form:form id="formMonitor" method="POST" action="/submit" modelAttribute="urlModel">
		<table id='ct_blah'>
			<tr>
				<td><form:label path="webModel[0].url" >Input URL</form:label></td>
				<td><form:input id="0" path="webModel[0].url" /></td>
			</tr>

			<tr class="ui-widget-header">
				<td><input id="addURL" value="Add URL" type='button' /></td>
				<td><input type="submit" value="Check Availability" /></td>
			</tr>

		</table>
	</form:form>
</body>


</html>