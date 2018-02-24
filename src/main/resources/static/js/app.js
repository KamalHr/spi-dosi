var myApp = angular.module("myApp", ["ui.router", 'pascalprecht.translate']);

myApp.config(function ($translateProvider) {
	$translateProvider.translations('EN', {
		TITLE: 'Welcome to SPI',
		DASHBOARD: 'Dashboard',
		BUTTON_LANG_EN: 'English',
		BUTTON_LANG_FR: 'French',
		NBR_TEACHERS: 'Number of teachers',
		NBR_FORMATIONS: 'Number of Formations',
		NBR_PROMOTIONS: 'Number of Promotions',
		NBR_CANDIDATS: 'Number of Candidats',
		TEACHERS: 'Teachers'
	});
	$translateProvider.translations('FR', {
		TITLE: 'Bienvenue dans SPI',
		DASHBOARD: 'Tableau de bord',
		BUTTON_LANG_EN: 'Anglais',
		BUTTON_LANG_FR: 'Français',
		NBR_TEACHERS: 'Nombre d\'Enseignants',
		NBR_FORMATIONS: 'Nombre de Formations',
		NBR_PROMOTIONS: 'Nombre de Promotions',
		NBR_CANDIDATS: 'Nombre de Candidats',
		TEACHERS: 'Enseignants'
	});
	$translateProvider.preferredLanguage('EN');
});

myApp.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
	$stateProvider.state('index', {
		views: {
			"index": {
				templateUrl: "views/index.html",
				controller: "indexCtrl"
			}
		}
	});
	$stateProvider.state('home', {
		parent: 'index',
		url: '/',
		views: {
			"home": {
				templateUrl: "views/home.html",
				controller: "homeCtrl"
			}
		}
	});
	$stateProvider.state('candidats', {
		parent: 'index',
		url: '/candidats',
		views: {
			"home": {
				templateUrl: "views/candidats.html",
				controller: "candidatsCtrl"
			}
		}
	});
	$stateProvider.state('candidatDetails', {
		parent: 'index',
		url: '/candidats/:id',
		views: {
			"home": {
				templateUrl: "views/details/candidat.html",
				controller: "candidatDetailsCtrl"
			}
		}
	});
	$stateProvider.state('newCandidat', {
		parent: 'index',
		url: '/candidats/new',
		views: {
			"home": {
				templateUrl: "views/creations/candidat.html",
				controller: "newCandidatCtrl"
			}
		}
	});
	$stateProvider.state('formations', {
		parent: 'index',
		url: '/formations',
		views: {
			"home": {
				templateUrl: "views/formations.html",
				controller: "formationsCtrl"
			}
		}
	});
	$stateProvider.state('formationDetails', {
		parent: 'index',
		url: '/formations/:id',
		views: {
			"home": {
				templateUrl: "views/details/formation.html",
				controller: "formationDetailsCtrl"
			}
		}
	});
	$stateProvider.state('newFormation', {
		parent: 'index',
		url: '/formations/new',
		views: {
			"home": {
				templateUrl: "views/creations/formation.html",
				controller: "newFormationCtrl"
			}
		}
	});
	$stateProvider.state('promotions', {
		parent: 'index',
		url: '/promotions',
		views: {
			"home": {
				templateUrl: "views/promotions.html",
				controller: "promotionsCtrl"
			}
		}
	});
	$stateProvider.state('enseignants', {
		parent: 'index',
		url: '/enseignants',
		views: {
			"home": {
				templateUrl: "views/enseignants.html",
				controller: "enseignantsCtrl"
			}
		}
	});
	$stateProvider.state('newEnseignant', {
		parent: 'index',
		url: '/enseignants/new',
		views: {
			"home": {
				templateUrl: "views/creations/enseignant.html",
				controller: "newEnseignantsCtrl"
			}
		}
	});
	$urlRouterProvider.otherwise('/');
}]);
