
myApp.controller('promotionsCtrl', function ($scope, $http, $state, SERVER_URL) {
    $scope.promotions = [];
    $scope.promotionToUpdate = {};
    $http.get(SERVER_URL+"promotions/")
        .then((data) => {
            $scope.promotions = data.data;
            setTimeout(() => {
                $(document).ready(function() {
                    $('#promotions').DataTable();
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
                $http.delete(SERVER_URL+"promotions/" + id + "/")
                    .then((done) => {
                        swal(
                            'Supprimer!',
                            'La promotion est bien supprimer.',
                            'success'
                        );
                        $http.get(SERVER_URL+"promotions/")
                            .then((data) => {
                                $scope.promotions = data.data;
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
    $scope.updatePromotion = (promotion) => {
        $scope.formationToUpdate = enseignant;
        $('#updateEnseignant').modal('show');
    };
    $scope.doneUpdatePromotion = () => {
        $('#updatePromotions').modal('hide');
        $http.put("http://localhost:8090/promotions", $scope.promotionToUpdate)
        .then((res) => {
            $scope.promotionToUpdate = {};
            swal('Done!', 'Mise à jours bien effectuée!', 'success');
            $http.get(SERVER_URL+"promotions/")
            .then((data) => {
                $scope.promotions = data.data;
                setTimeout(() => {
                    $(document).ready(function() {
                        $('#promotions').DataTable();
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