var express = require('express');
var router = express.Router();
var request = require('request');

var heartBeatOptions = {
    method: 'GET',
    url: 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/heartbeat'
};
var date = new Date();
var utcDate = new Date(date.toUTCString());
utcDate.setHours(utcDate.getHours()-8);
var todayDate = new Date(utcDate).toISOString().slice(0, 10);

function isTodayData(obj) {
    return obj.date == todayDate;
}

var activityOptions = { method: 'GET',
    url: 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/activity'
};

var currentHeartBeatOptions = { method: 'GET',
    url : 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/currentHeartRate/' +todayDate
};

var bloodPressureOptions = { method: 'GET',
    url: 'http://outpatient.hep5pmeidw.us-west-1.elasticbeanstalk.com/rest/bloodpressure'
};

/* GET home page. */
router.get('/', function(req, res, next) {
    if (!req.session.user_id) {
        res.redirect('http://localhost:3020/signin/?errorData=+' +
            encodeURIComponent('You need to login to view dashboard!'));
    }
    request(heartBeatOptions, function (error, response, heartBeatRes) {
        if (error) throw new Error(error);

        request(activityOptions, function (error, response, activityRes) {
            if (error) throw new Error(error);

            request(currentHeartBeatOptions, function (error, response, currentHeartBeatRes) {
                if (error) throw new Error(error);

                request(bloodPressureOptions, function (error, response, bloodPressureRes) {
                    if (error) throw new Error(error);

                    // var curHeartBeatData = JSON.parse(currentHeartBeatRes);
                    var curActivityData = JSON.parse(activityRes).filter(isTodayData);
                    var currentData = {steps: 0, calories: 0, value: 0};
                    console.log(currentData)

                    if (curActivityData.length !== 0) {
                        currentData.steps = curActivityData[0].steps;
                        currentData.calories = curActivityData[0].calories;
                    }

                    if (currentHeartBeatRes != '') {
                        currentData.value = JSON.parse(currentHeartBeatRes).value;
                    }
                    console.log(currentData)
                    res.render('index', {
                        heartBeatData: JSON.parse(heartBeatRes),
                        activityData: JSON.parse(activityRes),
                        bloodPressureData: JSON.parse(bloodPressureRes),
                        currentData: currentData
                    });
                });
            });
        });
    });
});
module.exports = router;