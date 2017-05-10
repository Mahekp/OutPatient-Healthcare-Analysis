var express = require('express');
var router = express.Router();
var request = require('request');

var options = {
    method: 'POST',
    url: 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/users',
    headers:
        {
          'content-type': 'application/json'
        },
    json: true
};

router.post('/', function(req, res) {
    options.body = req.body

   request(options, function (error, response, body) {
     if (error) throw new Error(error);

     res.redirect('http://localhost:3020/signin');

     });
});
router.get('/', function(req, res, next) {
    res.render('register.ejs');
});
module.exports = router;