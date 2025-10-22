package Api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {
    private final static String userUrl = "api/users?page=2";
    private final static String userCreateUrl = "api/users";
    private final static String registerSuccess = "api/register";

    /**
     * Тест для списка пользователей.
     * 1) Проверка совпадения содержания id в аватарах
     * 2) Проверка корректности создания пользователя
     */
    @Test
    public void usersTest() {
        List<UserData> data = RestAssured.given(Specifications.requestSpecification())
                .when()
                .get(userUrl)
                .then()
                .spec(Specifications.responseSpec200())
                .log().all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);
        data.stream().forEach(user -> assertTrue(user.getAvatar().contains(user.getId().toString())));

        UserCreate user = new UserCreate("morpheus", "leader");
        UserCreateSuccess create = RestAssured.given(Specifications.requestSpecification())
                .header("x-api-key", "reqres-free-v1")
                .body(user)
                .when()
                .post(userCreateUrl)
                .then()
                .spec(Specifications.responseSpec201())
                .log().all()
                .extract().as(UserCreateSuccess.class);
        assertEquals(create.name, user.name);
        assertEquals(create.job, user.job);

        RegisterSuccessReq registerBody = new RegisterSuccessReq("eve.holt@reqres.in", "pistol");
        RegisterSuccsessRes registerResponse = RestAssured.given(Specifications.requestSpecification())
                .header("x-api-key", "reqres-free-v1")
                .body(registerBody)
                .when()
                .post(registerSuccess)
                .then()
                .spec(Specifications.responseSpec200())
                .log().all()
                .extract().as(RegisterSuccsessRes.class);
        assertEquals(registerResponse.getId().toString(), "4");
        assertEquals(registerResponse.getToken(), "QpwL5tke4Pnpja7X4");
    }
}
