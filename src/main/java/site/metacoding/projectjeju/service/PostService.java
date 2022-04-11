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

        pubic L

        if (name == null) {
            return restaurantRepository.mSearch("");
        } else {
            return restaurantRepository.mSearch(name);
        }
    }
}
