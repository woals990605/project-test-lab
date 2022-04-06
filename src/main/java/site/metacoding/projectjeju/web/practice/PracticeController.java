package site.metacoding.projectjeju.web.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.projectjeju.domain.resturant.Resturant;
import site.metacoding.projectjeju.web.dto.download.JejuDto;
import site.metacoding.projectjeju.web.dto.download.ResturantDto;

@RequiredArgsConstructor
@Controller
public class PracticeController {

    @GetMapping("/test/craw")
    public @ResponseBody List<Resturant> croling() {
        RestTemplate rt = new RestTemplate();

        JejuDto body = rt.getForObject(
                "https://map.naver.com/v5/api/search?caller=pcweb&query=제주시음식점&type=all&searchCoord=126.03779919999974;33.44996470000005&page=1&displayCount=10&isPlaceRecommendationReplace=true&lang=ko&_json",
                JejuDto.class);
        // System.out.println(body);
        List<ResturantDto> list = body.getResult().getPlace().getList();

        // 여기에 옮기는게 목적
        List<Resturant> resturants = new ArrayList<>();

        for (ResturantDto resturantDto : list) {
            resturants.add(resturantDto.toEntity());
        }

        return resturants;
    }

    // @PostMapping("/list")
    // public List<FoodTbl> list() {
    // // List<FoodTbl> foodEntity = foodTblRepository.save();
    // // return foodEntity;
    // }

}
