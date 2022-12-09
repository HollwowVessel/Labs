import java.util.Objects;

enum AuthorizeUser {
    Dean,
    Admin,
    User
}

public class AuthorizedUser extends AnyUser {
    AuthorizeUser type;

    AuthorizedUser(String type){
        if(Objects.equals(type, "Dean")){
            this.type = AuthorizeUser.Dean;
        }
        else if(Objects.equals(type, "Admin")){
            this.type = AuthorizeUser.Admin;
        }
        else{
            this.type = AuthorizeUser.User;
        }
    }

    public void exit(){

        this.authStatus = false;
    }
}
