package contentmanagement.service;

import contentmanagement.mapper.NewsMapper;
import contentmanagement.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int addNews(News news) {
        try {
            newsMapper.save(news);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateNews(News news) {
        try{
            Query query = new Query(new Criteria("id").is(news.getId()));
            Update update = new Update()
                    .set("content",news.getContent())
                    .set("createTime",new Date());
            mongoTemplate.updateMulti(query,update,news.getClass());
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


    @Override
    public List<News> findByTitle(String title) {
        return newsMapper.findByTitle(title);
    }

    @Override
    public List<News> findAll() {
        return newsMapper.findAll();
    }

    @Override
    public int deleteNews(String title) {
        return newsMapper.deleteNewsByTitle(title);
    }
}
