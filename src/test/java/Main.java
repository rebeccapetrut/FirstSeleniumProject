public class Main {
    public static void main(String[] args) {
        LoginTest login = new LoginTest();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Starting tests...");
//        login.loginWithValidCredentials();
//

//        WishlistTest wishlist = new WishlistTest();
//        wishlist.addToWishlist();

        RegisterTest register = new RegisterTest();
        register.register();

    }



}
