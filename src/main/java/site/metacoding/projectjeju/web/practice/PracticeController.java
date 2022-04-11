package site.metacoding.projectjeju.web.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.projectjeju.domain.post.Restaurant;
import site.metacoding.projectjeju.domain.post.RestaurantRepository;
import site.metacoding.projectjeju.service.PostService;
import site.metacoding.projectjeju.web.dto.download.JejuDto;
import site.metacoding.projectjeju.web.dto.download.RestaurantDto;

@RequiredArgsConstructor
@Controller
public class PracticeController {

    private final RestaurantRepository restaurantRepository;
    private final PostService postService;

    @GetMapping("/test/craw")
    public @ResponseBody List<Restaurant> croling() {
        RestTemplate rt = new RestTemplate();

        JejuDto body = rt.getForObject(
                "https://map.naver.com/v5/api/search?caller=pcweb&query=서귀포시디저트&type=all&searchCoord=126.03779919999974;33.44996470000005&page=3&displayCount=100&isPlaceRecommendationReplace=true&lang=ko&_json",
                JejuDto.class);
        // System.out.println(body);
        List<RestaurantDto> list = body.getResult().getPlace().getList();

        // 여기에 옮기는게 목적
        List<Restaurant> restaurants = new ArrayList<>();

        for (RestaurantDto restaurantDto : list) {
            restaurants.add(restaurantDto.toEntity());
        }
        restaurantRepository.saveAll(restaurants);

        return restaurants;
    }

    // @PostMapping("/list")
    // public List<FoodTbl> list() {
    // // List<FoodTbl> foodEntity = foodTblRepository.save();
    // // return foodEntity;
    // }
    @GetMapping("/post/list")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model) {
        List<Restaurant> restaurants = postService.글목록(keyword);
        // System.out.println("사이즈 : " + restaurants.size());
        model.addAttribute("Restaurant", restaurants);
        return "list";
    }

}
