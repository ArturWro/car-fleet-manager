package pl.groupproject.carfleet.security;

public interface SecurityService {

  String findByLogin();

  void autoLogin(String login, String password);
}
