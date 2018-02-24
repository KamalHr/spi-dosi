myApp.controller('homeCtrl', function ($scope, $http) {
    $scope.formations = [];
    $scope.enseignants = [];
    $scope.promotions = [];
    $scope.candidats = [];
    $http.get("http://localhost:8090/formations")
    .then((data) => {
        $scope.formations = data.data;
    });
    $http.get("http://localhost:8090/enseignants")
    .then((data) => {
        $scope.enseignants = data.data;
    });
    $http.get("http://localhost:8090/promotions")
    .then((data) => {
        $scope.promotions = data.data;
    });
    $http.get("http://localhost:8090/candidats")
    .then((data) => {
        $scope.candidats = data.data;
    });
});