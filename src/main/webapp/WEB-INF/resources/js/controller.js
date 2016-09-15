/**
 * Created by zhy on 2016/9/9.
 */
var cartApp = angular.module("cartApp", []);
cartApp.controller("cartCtrl", function ($scope, $http) {
    $scope.refreshCart = function () {
        $http.get('/eMusicStore/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/eMusicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productID) {
        console.log(productID);
        $http.put('/eMusicStore/rest/cart/add/' + productID).success(function () {
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (productID) {
        $http.put('/eMusicStore/rest/cart/remove/' + productID).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        if($scope.cart != null) {
            var grandTotal = 0;
            for (var i = 0; i < $scope.cart.cartItems.length; i++) {
                grandTotal += $scope.cart.cartItems[i].totalPrice;
            }
            //console.log($scope.cart.cartItems.length);
            return grandTotal;
        }else{
            //console.log("calGrandTotal is called but cart is null");
        }
    };
});