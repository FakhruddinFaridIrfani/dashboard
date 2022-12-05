package com.project.dashboard.service;

import com.project.dashboard.model.Users;
import com.project.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    //TOKEN AUTH
    public Map<String, Object> tokenAuthentication(String token) {
        Map<String, Object> result = new HashMap();
//        List<Users> usersList;
//        try {
//            usersList = userRepository.tokenAuth(token);
//            if (usersList.size() > 0) {
//                result.put("valid", true);
//                result.put("user_name", usersList.get(0).getUser_name());
//            } else {
//                result.put("valid", false);
//                result.put("user_name", "");
//            }
//
//        } catch (Exception e) {
//            result.put("valid", false);
//            result.put("user_name", "");
//        }
        return result;
    }
}
