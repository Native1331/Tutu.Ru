package config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credential.properties")
    public interface CredentialsConfig extends Config {
        String selenoidLogin();
        String selenoidPassword();
        String baseUrl();
        String login();
        String password();
        String authCookieName();
    }
