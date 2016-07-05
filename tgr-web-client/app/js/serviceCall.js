function call($http) {
	var request = {
			  "id":"2015"
	  };
	  
	  $http.defaults.headers.post["Content-Type"] = "application/json";
	  $http.defaults.headers.post["login"] = "toto";
	  var response = $http.post('http://localhost:8080/tgr-accounting-webapp/AccountingService/readBalance', request);       
}