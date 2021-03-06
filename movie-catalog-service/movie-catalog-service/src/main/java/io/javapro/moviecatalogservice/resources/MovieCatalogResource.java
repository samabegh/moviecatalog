package io.javapro.moviecatalogservice.resources;

import io.javapro.moviecatalogservice.resources.models.CatalogItem;
import io.javapro.moviecatalogservice.resources.models.Movie;
import io.javapro.moviecatalogservice.resources.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource
{
    @Autowired
   private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        List<Rating> ratings= Arrays.asList(
                new Rating("T164",4),
                new Rating("SM354",3));
        return ratings.stream().map(rating -> {
            Movie movie=restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(),Movie.class);

            return new CatalogItem(movie.getName(), "Test",rating.getRating());


    })
                .collect(Collectors.toList());

}
}
