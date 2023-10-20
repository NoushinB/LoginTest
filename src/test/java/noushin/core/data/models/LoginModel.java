package noushin.core.data.models;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel {
    @JsonProperty("user_name")
    public String userName;

    @JsonProperty("password")
    public String password;
}
