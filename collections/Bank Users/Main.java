package coll.UserAccounts;

public class Main {

    public static void main(String[] args){
        try{
            User user = new User ("Alice", "password");
        } catch (UserException e) {
            System.out.println("Invalid username or password");
        }
        try{
            User user2 = new User ("Alice", "passwords");
        } catch (UserException e) {
            System.out.println("Invalid username or password");
        }
    }
}
