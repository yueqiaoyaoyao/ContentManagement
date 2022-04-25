package contentmanagement.mapper;

import contentmanagement.pojo.News;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface NewsMapper extends MongoRepository<News,Integer> {
    List<News> findByTitle(String title);
    int deleteNewsByTitle(String title);
}
