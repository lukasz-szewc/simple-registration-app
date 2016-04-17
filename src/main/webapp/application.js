var app = angular.module("registrationApp", []);

app.controller('RegisterUserController', ['$http', '$scope', function($http, $scope) {
    $scope.submit = function() {
        $scope.objectSaved = null;
        $scope.objectNotSaved = null;
        $http.post('/user/add', {
            password : $scope.password,
            name : $scope.username
        }).then(
            function(data) {
                $scope.objectSaved = true;
            },
            function(data) {
                $scope.objectNotSaved = true;
            });
    };

}]);

app.directive('userpassword', function ($q, $timeout, $http) {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$asyncValidators.password = function (modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue) || modelValue.length < 8) {
                    return $q.when();
                }

                var def = $q.defer();

                $http.post('/password/verify', {
                    password : modelValue
                }).then(
                    function(data) {
                        scope.passwordServerAnswer = true;
                        def.resolve();
                    },
                    function(data) {
                        scope.passwordServerAnswer = false;
                        def.reject();
                    });

                return def.promise;
            };
        }
    };
});

app.directive('username', function ($q, $timeout, $http) {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$asyncValidators.username = function (modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue) || modelValue.length < 5) {
                    return $q.when();
                }

                var def = $q.defer();

                $http.post('/username/verify', {
                    name : modelValue
                }).then(
                    function(data) {
                        scope.usernameServerAnswer = true;
                        def.resolve();
                    },
                    function(response) {
                        scope.usernameErrorMessage = response.data.message;
                        scope.usernameServerAnswer = false;
                        def.reject();
                    });

                return def.promise;
            };
        }
    };
});
