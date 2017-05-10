/**
 * Created by mpavagadhi on 5/6/17.
 */
var express = require('express');
var router = express.Router();
var request = require('request');

router.get('/', function(req, res, next) {
    delete req.session.user_id;
    res.redirect('http://localhost:3020/signin');
});
module.exports = router;