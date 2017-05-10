var express = require('express');
var router = express.Router();
var request = require('request');

var options = {
    method: 'GET'
};

router.post('/', function(req, res, next) {
    console.log(req.body)
    options.url = 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/users/' +
            req.body.email + '/' + req.body.password

    request(options, function (error, response, loginRes) {
        if (error) throw new Error(error);

        if (loginRes!= ''){
            req.session.user_id = JSON.parse(loginRes).userId;
            res.redirect('http://localhost:3020/dashboard');
        } else {
            res.render('signin', {
                errorData: 'Cannot login. You are not registered!'
            });
        }
    });
});
router.get('/', function(req, res, next) {
    var errorData = req.query.errorData || '';
    res.render('signin.ejs', {errorData: errorData});
});
module.exports = router;