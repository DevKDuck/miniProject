package com.devkduck.springboot.web;

import com.devkduck.springboot.config.auth.dto.SessionUser;
import com.devkduck.springboot.domain.user.User;
import com.devkduck.springboot.service.posts.PostsService;
import com.devkduck.springboot.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser user) {
    public String index(Model model) {

        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

        if (sessionUser != null) {
            User user = new User();
            user.setId(sessionUser.getId());
            user.setName(sessionUser.getName());
            user.setEmail(sessionUser.getEmail());
            model.addAttribute("userEmail", user.getEmail());
        }


        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable("id") Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}