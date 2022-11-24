package com.cloud.auth.service;

import com.cloud.auth.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.authorization.client.util.Http;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    private final Keycloak keycloak;

    public UserDTO createUser(UserDTO userDto) {

        // 유저정보 세팅
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(userDto.getUserId());

        // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        Response response = usersResource.create(user);
        if(response.getStatus() == 201) {

            String userId = CreatedResponseUtil.getCreatedId(response);

            // create password credential
            CredentialRepresentation passwordCred = new CredentialRepresentation();
            passwordCred.setTemporary(false);
            passwordCred.setType(CredentialRepresentation.PASSWORD);
            passwordCred.setValue(userDto.getUserPwd());
            log.info("Created userId {}", userId);
            UserResource userResource = usersResource.get(userId);

            // Set password credential
            userResource.resetPassword(passwordCred);

            // role 세팅
            ClientRepresentation clientRep = realmResource.clients().findByClientId(clientId).get(0);
            RoleRepresentation clientRoleRep = realmResource.clients().get(clientRep.getId()).roles().get(userDto.getUserRole().getCode()).toRepresentation();
            userResource.roles().clientLevel(clientRep.getId()).add(Arrays.asList(clientRoleRep));

        }

        userDto.setStatus(response.getStatus());
//        userDto.setStatusInfo(response.getStatusInfo().toString());

        return userDto;
    }

    public AccessTokenResponse setAuth(HashMap<String, String> map) {
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", clientSecret);
        clientCredentials.put("grant_type", "password");

        Configuration configuration =new Configuration(authServerUrl, realm, clientId, clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);

        AccessTokenResponse response = authzClient.obtainAccessToken(map.get("username"), map.get("password"));

        return response;
    }

    public AccessTokenResponse refreshToken(String refreshToken) {
        String url = authServerUrl + "realms/" + realm + "/protocol/openid-connect/token";

        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", clientSecret);
        clientCredentials.put("grant_type", "refresh_token");
        clientCredentials.put("refresh_token", refreshToken);

        Configuration configuration =new Configuration(authServerUrl, realm, clientId, clientCredentials, null);

        Http http = new Http(configuration, (params, headers) -> {});
        return http.<AccessTokenResponse>post(url)
                .authentication()
                .client()
                .form()
                .param("grant_type", "refresh_token")
                .param("refresh_token", refreshToken)
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .response()
                .json(AccessTokenResponse.class)
                .execute();
    }

    // 사용자 존재하는지 체크
    public boolean existsByUsername(String userName) {

        List<UserRepresentation> search = keycloak.realm(realm).users().search(userName);
        if(search.size() > 0){
            log.debug("search : {}", search.get(0).getUsername());
            return true;
        }
        return false;
    }
}