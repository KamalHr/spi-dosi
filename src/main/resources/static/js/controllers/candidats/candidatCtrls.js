myApp.controller('candidatsCtrl', function ($scope, $http, SERVER_URL) {
    $scope.candidats = [];
    $http.get(SERVER_URL + "candidats/")
        .then((data) => {
            $scope.candidats = data.data;
            setTimeout(() => {
                $(document).ready(function () {
                    $('#candidats').DataTable();
                });
            }, 0);
        }, (err) => {
            swal('Oops...', 'Something went wrong!', 'error');
        });
    $scope.delete = (id) => {
        swal({
            title: 'Vous êtes Sûr?',
            text: "C'est irréversible!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Oui!',
            cancelButtonText: 'Annuler'
        }).then((result) => {
            if (result.value) {
                $http.delete(SERVER_URL+"candidats/" + id + "/")
                    .then((done) => {
                        swal(
                            'Supprimer!',
                            'Le candidat est bien supprimer.',
                            'success'
                        );
                        $http.get(SERVER_URL+"candidats/")
                            .then((data) => {
                                $scope.candidats = data.data;
                                console.log(data.data);
                            }, (err) => {
                                swal('Oops...', 'Something went wrong!', 'error');
                            });
                    }, (err) => {
                        swal(
                            'Cancelled',
                            'Your imaginary file is safe :)',
                            'error'
                        )
                    })

            } else if (result.dismiss === swal.DismissReason.cancel) {
                swal(
                    'Cancelled',
                    'Your imaginary file is safe :)',
                    'error'
                )
            }
        })
    }
});
myApp.controller('candidatDetailsCtrl', function ($scope, $http, $stateParams, SERVER_URL) {
    $scope.candidat = {};
    console.log($stateParams);
    $http.get(SERVER_URL+"candidats/" + $stateParams.id)
        .then((data) => {
            $scope.candidat = data.data;
            console.log(data.data);
        }, (err) => {

        });
});
myApp.controller('newCandidatCtrl', function ($scope, $http, $stateParams, $state, SERVER_URL) {
    $scope.candidat = {
        promotion: {
            id: {}
        }
    };
    $scope.promotions = [];
    $scope.countries = [];
    $http.get("https://restcountries.eu/rest/v2/all?fields=name;alpha2Code")
    .then((res) => {
        
        setTimeout(() => {
            $scope.countries = res.data;
            console.log($scope.countries);
        }, 0);
    });
    $http.get("http://localhost:8090/promotions")
        .then((data) => {
            setTimeout(() => {
                $scope.promotions = data.data;
            }, 0);
        }, (err) => {
            $scope.promotions = [];
        });
    $scope.newCandidat = () => {
        $http.post("http://localhost:8090/candidats", $scope.candidat)
            .then((data) => {
                swal("Done!", "Candidat bien ajouté", "success");
                $state.go('candidats');
            }, (err) => {
                swal("STOP!", "Candidat pas bien ajouté", "error");
                $state.go('candidats');
            });
    }
});