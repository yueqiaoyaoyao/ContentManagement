package contentmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "news")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    private ObjectId id;
    private String title;
    private String writer;
    private String content;
    private Date createTime;
    private Date updateTime;
}
