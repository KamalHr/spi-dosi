myApp.controller('formationsCtrl', function ($scope, $http, SERVER_URL) {
    $scope.formations = [];
    $scope.formationToUpdate = {};
    $http.get(SERVER_URL+"formations/")
        .then((data) => {
            $scope.formations = data.data;
            setTimeout(() => {
                $(document).ready(function() {
                    $('#formations').DataTable();
                } );
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
                $http.delete(SERVER_URL+"formations/" + id + "/")
                    .then((done) => {
                        swal(
                            'Supprimer!',
                            'La formations est bien supprimer.',
                            'success'
                        );
                        $http.get(SERVER_URL+"formations/")
                            .then((data) => {
                                $scope.formations = data.data;
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
    };
    $scope.updateFormation = (formation) => {
        $scope.formationToUpdate = formation;
        $('#updateFormation').modal('show');
    };
    $scope.doneUpdateFormation = () => {
        $('#updateFormation').modal('hide');
        $http.put(SERVER_URL+"formations/", $scope.formationToUpdate)
        .then((res) => {
            $scope.formationToUpdate = {};
            swal('Done!', 'Mise à jours bien effectuée!', 'success');
            $http.get(SERVER_URL+"formations/")
            .then((data) => {
                $scope.formations = data.data;
                setTimeout(() => {
                    $(document).ready(function() {
                        $('#formations').DataTable();
                    } );
                }, 0);
            }, (err) => {
                swal('Oops...', 'Something went wrong!', 'error');
            });
        }, (err) => {
            swal('Oops...', 'Something went wrong!', 'error');
        });
    };
});
myApp.controller('formationDetailsCtrl', function ($scope, $http, $stateParams, SERVER_URL) {
    $scope.formation = {};
    $http.get(SERVER_URL+"formations/"+$stateParams.id)
    .then((data) => {
        $scope.formation = data.data;
        console.log(data.data);
    }, (err) => {

    });
});
myApp.controller('newFormationCtrl', function ($scope, $http, $stateParams, $state, SERVER_URL) {
    $scope.formation = {};
    $scope.newFormation = () => {
        console.log($scope.formation);
        $http.post(SERVER_URL+"formations/", $scope.formation)
        .then((data) => {
            swal("Done!", "Formation bien ajoutée", "success");
            $state.go('formations');
        }, (err) => {
            swal("STOP!", "Formation pas bien ajoutée", "error");
            $state.go('formations');
        });
    }
});