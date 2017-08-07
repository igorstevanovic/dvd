var dvdtekaApp = angular.module('dvdtekaApp', ['ngRoute']);

dvdtekaApp.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/',{
        templateUrl : '/static/app/html/partial/home.html'
    })
    .when('/dvds',{
        templateUrl : '/static/app/html/partial/dvds.html'
    })
    .when('/dvd/:id',{
        templateUrl : '/static/app/html/partial/dvd.html'
    })
    .otherwise({
        redirectTo : '/'
    });
}]);

dvdtekaApp.controller('dvdCtrl', function($scope, $http, $routeParams, $location){
   
    var selected;

    $scope.alerts = [
        { type: 'danger', msg: 'Došlo je do greške prilikom snimanja podataka.' },
        { type: 'success', msg: 'Podaci uspešno sačuvani.' }
    ];
    
    console.log($routeParams.id);
    $scope.loadDvd = function () {
        $http.get('/api/dvds/'+$routeParams.id)
            .then(function (resp) {
                $scope.dvd = resp.data;
                $scope.selected = resp.data.genreDTO;
                console.log($scope.selected) ;
            });
    }

    $scope.loadDvd();

    $scope.save = function () {
        $scope.dvd.genreDTO = $scope.selected;
        $http.put('/api/dvds/'+$scope.dvd.id, $scope.dvd)
            .then(function () {
                $location.path('/dvds')
            });            
    }

    var loadGenres = function(){
        var genresPromise = $http.get('/api/genres/');
            genresPromise.then(function(resp){
                $scope.genres = resp.data;
                console.log($scope.genres);
            }, function(resp){
                console.log(resp);
            });
    }
    loadGenres();
       
});

dvdtekaApp.controller('dvdsCtrl', function($scope, $http, $location){
    var newDvd;
    var selected;
    $scope.totalPages;
    $scope.currentPage=0;

    $scope.perPageValues = [
            {id : '5'},
            {id : '10'},
            {id : '20'}
        ];

   $scope.chosenData = $scope.perPageValues[1];

   $scope.changePageSize = function(){
        $scope.currentPage = 0;
        loadDvds();
   }

    var loadDvds = function(){
        var config = {params:{}};
        config.params.vpp = $scope.chosenData.id;
        if($scope.title){
            config.params.title=$scope.title;
        }
        if($scope.priceFrom){
            config.params.priceFrom=$scope.priceFrom;
        }
        if($scope.priceTo){
            config.params.priceTo=$scope.priceTo;
        }
        if($scope.currentPage){
            config.params.page=$scope.currentPage;            
        }
        console.log(config);
        var dvdsPromise = $http.get('/api/dvds/', config);
            dvdsPromise.then(function(resp){
                $scope.dvds = resp.data;
                $scope.totalPages = Number(resp.headers().totalpages);
                 console.log(resp.data);

            }, function(resp){
                console.log(resp);
            });
        
    }

    var loadGenres = function(){
        var genresPromise = $http.get('/api/genres/');
            genresPromise.then(function(resp){
                $scope.genres = resp.data;
            }, function(resp){
                console.log(resp);
            });
    }

    $scope.showInNewPage = function (id) {
        $location.path('/dvd/'+id);
    }

    loadDvds();
    loadGenres();

    $scope.prepForUpdate = function (dvd) {

        $scope.newDvd = angular.copy(dvd);
        $scope.selected = dvd.genreDTO;
    }

    $scope.save = function () {
        $scope.newDvd.genreDTO = $scope.selected;
        if(!$scope.newDvd.id){
            $http.post('/api/dvds/',$scope.newDvd)
                .then(function (){
                    loadDvds();
                    $scope.newDvd={};
                    $scope.selected = undefined;
                    
                    });
        }
        else{
            console.log($scope.selected);
            $http.put('/api/dvds/'+$scope.newDvd.id, $scope.newDvd)
                .then(function () {
                    loadDvds();
                    $scope.newDvd={};
                    $scope.selected = undefined;

                });            
        }
    }

    $scope.del = function (id) {
        console.log('delete dvd id:',id);
        $http.delete('/api/dvds/'+id).then(function  () {
            loadDvds();
        });
    }

    var loadGenres = function(){
        var genresPromise = $http.get('/api/genres/');
            genresPromise.then(function(resp){
                $scope.genres = resp.data;
                console.log($scope.genres);
            }, function(resp){
                console.log(resp);
            });
    }
    loadGenres();

    $scope.filtriraj = function () {
        $scope.currentPage = 0;
        loadDvds();        
    }

    $scope.changePage = function(i){
        if(($scope.currentPage>0&&i<0)||(i>0&&$scope.currentPage<$scope.totalPages)){
            $scope.currentPage+=i;
           loadDvds();

        }
    };

});
