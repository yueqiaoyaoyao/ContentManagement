package contentmanagement.service;

import contentmanagement.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int addNews(String content) {
        mongoTemplate.insert(content);
        return 0;
    }
}
