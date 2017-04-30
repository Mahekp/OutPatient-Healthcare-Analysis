(function() {
  var app = angular.module('myApp', ['ui.router']);
  
  app.run(function($rootScope, $location, $state, LoginService) {
    $rootScope.$on('$stateChangeStart', 
      function(event, toState, toParams, fromState, fromParams){ 
      var isLogInRequired = toState.data && toState.data.requiresLogin && ! LoginService.isLoggedIn();
        if (isLogInRequired == true) {
            LoginService.setToState(toState);
            event.preventDefault();
            $state.transitionTo('index');
          }
  });

  app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/index');
    $stateProvider
      .state('register', {
        url : '/register',
        templateUrl : 'app/public/register.html'
      })
      .state('login', {
        url : '/login',
        templateUrl : 'app/public/login.html'
      })
      .state('dashboard', {
        url : '/dashboard',
        templateUrl : 'app/public/dashboard.html'
      });
  }]);

  app.controller("RegisterController", function ($scope, $http, $rootScope, $state, LoginService) {
     $scope.registerformSubmit = {};
     $rootScope.registertitle = "Outpatient Healthcare Register";
     $scope.registerformSubmit = function(valid) {
      if(valid) {
        $http.post('http://healthcareAnalytics.2xqy3nnzyw.us-east-2.elasticbeanstalk.com/rest/user/register', $scope.formModel).success(
        function(data)
        {
        console.log("User Registered!")}).
        error(function(data){
        console.log("Error")
      });
   };
      } else{

      }
     $state.transitionTo('login');
  }

  app.controller('LoginController', function($scope, $http, $rootScope, $stateParams, $state, LoginService) {
    $rootScope.title = "Outpatient Healthcare Login"
    $scope.formSubmit = function() {
      if(LoginService.login($scope.username, $scope.password)) {
        $scope.username = '';
        $scope.password = '';
        $state.transitionTo('dashboard');
      } else {
        $scope.error = "Incorrect username/password !";
      }   
    };
  });
  
  app.controller('DashboardController', function($scope, $rootScope, $stateParams, $state, LoginService) {
    $rootScope.title = "Outpatient Fitness";
  });

  app.factory('LoginService', function($http) {
    var pass = 'pass';
    var loggedIn = false;
    var toState;
    return {
        isLoggedIn: function() {
          return loggedIn;
        },
        setToState: function(state) {
          toState = state;
        }, 
        login: function($scope){
          var response = $http ({
            method: 'POST',
            url: 'http//healthcareAnalytics.2xqy3nnzyw.us-east-2.elasticbeanstalk.com/rest/user/login';
            headers: {'Content-Type': ''}
            data: formData})
          .success(function (data, status, headers, config) {
            loggedIn = true;
            } else
            $state.transitionTo('login');
          })
          .error(function (data,status,headers,config){
            loggedIn = false;
          });
        })
      };