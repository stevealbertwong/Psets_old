/*

“Listing 18.2 express_routes.js: Implementing route parameters in Express”

Excerpt From: Brad Dayley. “Node.js, MongoDB, and AngularJS Web Development (Developer's Library).” iBooks. 
*/

var express = require("express");
var url = require("url");
var http = require("http");

var app = express();
// http.createServer(app).listen(8080);

app.listen(8080); // rudimentary implementation

app.get("/", function(req,res){
	res.send("Hello world")
});

// Query String e.g. /find?author=steven&title=ilovesunshine

app.get("/find", function(req, res){
	var url = url.parse(req.url, true);
	var query = url.query;
	var response = query.author + query.title;
	// res.send("response" + req.originalUrl);
	console.log(response);
})