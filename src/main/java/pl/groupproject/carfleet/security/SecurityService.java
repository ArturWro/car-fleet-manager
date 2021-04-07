package pl.groupproject.carfleet.security;

public interface SecurityService {

   // String findLoggedInDriverEmail();
    String findByLogin ();

    void autoLogin(String login, String password);
}
