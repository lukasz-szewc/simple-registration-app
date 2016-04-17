var app = angular.module("registrationApp", []);
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
                        scope.kokosza = data.status;
                        def.resolve();
                    },
                    function(data) {
                        scope.passwordServerAnswer = false;
                        scope.kokosza = data.status;
                        def.reject();
                    });

                return def.promise;
            };
        }
    };
});
