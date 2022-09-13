/**
 * 
 */

function getDetails(){
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#id").val(),
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            //here is your json.
              // process it
        	  $("#title").text(data.title);
        	  $("#price").text(data.price);

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
        timeout: 120000,
    });
}
function deleteBookFun(){
    jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#delBookId").val(),
        type: "DELETE",
        contentType: "application/json",
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            $("#delStatus").text(`Book ${$("#delBookId").val()} deleted`);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            $("#delStatus").text("Sorry! Book not found!");
        },
        timeout: 120000,
    });
}