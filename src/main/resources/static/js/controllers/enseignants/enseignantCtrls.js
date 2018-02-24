myApp.controller('enseignantsCtrl', function ($scope, $http, $state, SERVER_URL) {
    $scope.enseignants = [];
    $scope.enseignantToUpdate = {};
    $http.get(SERVER_URL+"enseignants/")
        .then((data) => {
            $scope.enseignants = data.data;
            setTimeout(() => {
                $(document).ready(function() {
                    $('#enseignants').DataTable();
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
                $http.delete(SERVER_URL+"enseignants/" + id + "/")
                    .then((done) => {
                        swal(
                            'Supprimer!',
                            'L\'enseignant est bien supprimer.',
                            'success'
                        );
                        $http.get(SERVER_URL+"enseignants/")
                            .then((data) => {
                                $scope.enseignants = data.data;
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
    $scope.updateEnseignant = (enseignant) => {
        $scope.formationToUpdate = enseignant;
        $('#updateEnseignant').modal('show');
    };
    $scope.doneUpdateEnseignant = () => {
        $('#updateEnseignants').modal('hide');
        $http.put("http://localhost:8090/enseignants", $scope.enseignantToUpdate)
        .then((res) => {
            $scope.enseignantToUpdate = {};
            swal('Done!', 'Mise à jours bien effectuée!', 'success');
            $http.get(SERVER_URL+"enseignants/")
            .then((data) => {
                $scope.enseignants = data.data;
                setTimeout(() => {
                    $(document).ready(function() {
                        $('#enseignants').DataTable();
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
myApp.controller('newEnseignantCtrl', function ($scope, $http, $stateParams, $state, SERVER_URL) {
    $scope.enseignant = {};
    $scope.newCandidat = () => {
        $http.post("http://localhost:8090/enseignants", $scope.enseignant)
        .then((data) => {
            swal("Done!", "Enseignant bien ajouté", "success");
            $state.go('enseignants');
        }, (err) => {
            swal("STOP!", "Enseignant pas bien ajouté", "error");
            $state.go('enseignants');
        });
    }
});