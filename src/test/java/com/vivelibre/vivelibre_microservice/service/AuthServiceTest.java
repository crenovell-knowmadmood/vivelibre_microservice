package com.vivelibre.vivelibre_microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.vivelibre.vivelibre_microservice.entities.AuthUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;


@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

  @InjectMocks
  AuthServiceImpl service;
  @Mock
  RestTemplate restTemplate;

  @Test
  void getToken() {
    final String expectedToken = "token";
    final String username = "auth-vivelibre";
    final String password = "password";
    final ResponseEntity<String> re = new ResponseEntity<>(expectedToken, HttpStatus.OK);
    AuthUser user = AuthUser.builder().username(username).password(password).build();
    HttpEntity httpEntity = new HttpEntity(user);
    final String authServiceUrl = (String) ReflectionTestUtils.getField(service, "authServiceUrl");
    when(restTemplate.exchange(eq(authServiceUrl), eq(HttpMethod.POST), eq(httpEntity), eq(String.class))
    ).thenReturn(re);
    final String token = service.getToken();
    assertNotNull(token);
    assertEquals(expectedToken, token);
  }
}