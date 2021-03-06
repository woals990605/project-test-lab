package site.metacoding.projectjeju.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
<<<<<<< HEAD

    @Query(value = "SELECT * FROM restaurant WHERE name like %:name% or menuInfo like %:menuInfo% or category like %:category%", nativeQuery = true)
    List<Restaurant> mSearch(@Param("name") String name, @Param("menuInfo") String menuInfo,
            @Param("category") String category);
=======
    @Query(value = "SELECT * FROM restaurant WHERE name like %:keyword% or menuInfo like %:keyword% or category like %:keyword%", nativeQuery = true)
    List<Restaurant> mSearch(@Param("keyword") String keyword);
>>>>>>> jaemin
}
