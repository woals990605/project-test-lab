package site.metacoding.projectjeju.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.projectjeju.domain.post.Restaurant;
import site.metacoding.projectjeju.domain.post.RestaurantRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> 글목록(String name, String menuInfo, String category) {
        if (name == null & menuInfo == null & category == null) {
            return restaurantRepository.mSearch("", "", "");
        } else {
            return restaurantRepository.mSearch(name, menuInfo, category);
        }
    }
}
