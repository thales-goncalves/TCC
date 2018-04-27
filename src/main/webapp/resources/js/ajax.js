function requestAJAX(method, url, data, token, header) {
    
	data = data || null
	
    $.ajax({
        type: method,
        contentType: "application/json;",
        url: url,
        data: data,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
        }
    });
}

function requestAJAXCallback(method, url, data, token, header, callback) {
    
	data = data || null
	
    $.ajax({
        type: method,
        contentType: "application/json;",
        url: url,
        data: data,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
        },
        timeout: 300000,
        success: function (data) {
            callback(data);
            
        },
        error: function (e) {
            //errorFunction(e);
        },
        done: function (e) {
            //errorFunction(e);

        }
    });
}


