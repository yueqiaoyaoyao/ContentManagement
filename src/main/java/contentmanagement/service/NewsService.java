package contentmanagement.service;

import contentmanagement.pojo.News;

import java.util.List;

public interface NewsService {
    int addNews(News news);
    int updateNews(News news);
    List<News> findByTitle(String title);
    List<News> findAll();
    int deleteNews(String title);
}
