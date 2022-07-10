package rw.ac.rca.nat2022.anselme.client.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rw.ac.rca.nat2022.anselme.client.utils.ApiResponse;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static rw.ac.rca.nat2022.anselme.client.utils.Utility.formatURL;

@Controller
@RequestMapping("auth")
public class AuthResource {

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("register")
    public String index() {
        return "auth/register";
    }

    @PostMapping("register")
    public String storeUser(HttpServletRequest request, Model model) throws JsonProcessingException {
        try {
            RestTemplate restTemplate = new RestTemplate();

            Map<String, String> requestBody = new HashMap<>();

            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                requestBody.put(entry.getKey(), entry.getValue()[0]);
            }

            ResponseEntity<ApiResponse> res = restTemplate.postForEntity(formatURL("/api/auth/register"), requestBody, ApiResponse.class);


            return "redirect:/auth/login?registered=true";
        } catch (Exception e) {
            ApiResponse response = new ObjectMapper().readValue(e.getMessage().substring(7, e.getMessage().length() - 1), ApiResponse.class);
            model.addAttribute("error", response.getMessage());

            return "auth/register";
        }
    }

    @PostMapping("login")
    public String loginUser(HttpServletRequest request, Model model) throws JsonProcessingException {
        try {
            RestTemplate restTemplate = new RestTemplate();

            Map<String, String> requestBody = new HashMap<>();

            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                requestBody.put(entry.getKey(), entry.getValue()[0]);
            }

            ResponseEntity<ApiResponse> res = restTemplate.postForEntity(formatURL("/api/auth/signin"), requestBody, ApiResponse.class);

            request.getSession().setAttribute("token", Objects.requireNonNull(res.getBody()).getMessage());

            return "redirect:/auth/profile";

        } catch (Exception e) {
            ApiResponse response = new ObjectMapper().readValue(e.getMessage().substring(7, e.getMessage().length() - 1), ApiResponse.class);

            model.addAttribute("error", response.getMessage());

            return "auth/login";
        }
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {

        System.out.println(request.getSession().getAttribute("token"));

        return "auth/profile";
    }
}
