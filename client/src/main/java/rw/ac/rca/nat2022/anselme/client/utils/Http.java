package rw.ac.rca.nat2022.anselme.client.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rw.ac.rca.nat2022.anselme.client.dao.Course;

import javax.servlet.http.HttpServletRequest;

import static rw.ac.rca.nat2022.anselme.client.utils.Utility.formatURL;

public class Http {

    public static void post(HttpServletRequest request, String url, Object data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String token = request.getSession().getAttribute("token").toString();

        headers.setBearerAuth(token);

        HttpEntity<Object> entity = new HttpEntity<>(data, headers);

        ResponseEntity<String> userResponse = restTemplate.exchange(formatURL(url), HttpMethod.POST, entity, String.class);

        System.out.println(userResponse.getBody());
    }
}
