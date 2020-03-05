package club.javafan.blog.domain;
/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/11 21:53
 * @desc 博客标签数量
 */
public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private Integer tagCount;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }
}
