myApp.controller('indexCtrl', function ($scope, $translate) {
    $scope.lang = "EN";
    $scope.changeLang = () => {
        $translate.use($scope.lang);
    }
});