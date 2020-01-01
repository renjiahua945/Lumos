package club.javafan.blog.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected Integer start;


    protected Integer limit;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
        oredCriteria = new ArrayList<>();
    }
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Long value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Long value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Long value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Long value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Long value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Long> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Long> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Long value1, Long value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Long value1, Long value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlIsNull() {
            addCriterion("blog_sub_url is null");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlIsNotNull() {
            addCriterion("blog_sub_url is not null");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlEqualTo(String value) {
            addCriterion("blog_sub_url =", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlNotEqualTo(String value) {
            addCriterion("blog_sub_url <>", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlGreaterThan(String value) {
            addCriterion("blog_sub_url >", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlGreaterThanOrEqualTo(String value) {
            addCriterion("blog_sub_url >=", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlLessThan(String value) {
            addCriterion("blog_sub_url <", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlLessThanOrEqualTo(String value) {
            addCriterion("blog_sub_url <=", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlLike(String value) {
            addCriterion("blog_sub_url like", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlNotLike(String value) {
            addCriterion("blog_sub_url not like", value, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlIn(List<String> values) {
            addCriterion("blog_sub_url in", values, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlNotIn(List<String> values) {
            addCriterion("blog_sub_url not in", values, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlBetween(String value1, String value2) {
            addCriterion("blog_sub_url between", value1, value2, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogSubUrlNotBetween(String value1, String value2) {
            addCriterion("blog_sub_url not between", value1, value2, "blogSubUrl");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageIsNull() {
            addCriterion("blog_cover_image is null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageIsNotNull() {
            addCriterion("blog_cover_image is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageEqualTo(String value) {
            addCriterion("blog_cover_image =", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageNotEqualTo(String value) {
            addCriterion("blog_cover_image <>", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageGreaterThan(String value) {
            addCriterion("blog_cover_image >", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageGreaterThanOrEqualTo(String value) {
            addCriterion("blog_cover_image >=", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageLessThan(String value) {
            addCriterion("blog_cover_image <", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageLessThanOrEqualTo(String value) {
            addCriterion("blog_cover_image <=", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageLike(String value) {
            addCriterion("blog_cover_image like", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageNotLike(String value) {
            addCriterion("blog_cover_image not like", value, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageIn(List<String> values) {
            addCriterion("blog_cover_image in", values, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageNotIn(List<String> values) {
            addCriterion("blog_cover_image not in", values, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageBetween(String value1, String value2) {
            addCriterion("blog_cover_image between", value1, value2, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogCoverImageNotBetween(String value1, String value2) {
            addCriterion("blog_cover_image not between", value1, value2, "blogCoverImage");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNull() {
            addCriterion("blog_content is null");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNotNull() {
            addCriterion("blog_content is not null");
            return (Criteria) this;
        }

        public Criteria andBlogContentEqualTo(String value) {
            addCriterion("blog_content =", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotEqualTo(String value) {
            addCriterion("blog_content <>", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThan(String value) {
            addCriterion("blog_content >", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThanOrEqualTo(String value) {
            addCriterion("blog_content >=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThan(String value) {
            addCriterion("blog_content <", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThanOrEqualTo(String value) {
            addCriterion("blog_content <=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLike(String value) {
            addCriterion("blog_content like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotLike(String value) {
            addCriterion("blog_content not like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentIn(List<String> values) {
            addCriterion("blog_content in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotIn(List<String> values) {
            addCriterion("blog_content not in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentBetween(String value1, String value2) {
            addCriterion("blog_content between", value1, value2, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotBetween(String value1, String value2) {
            addCriterion("blog_content not between", value1, value2, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIsNull() {
            addCriterion("blog_category_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIsNotNull() {
            addCriterion("blog_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdEqualTo(Integer value) {
            addCriterion("blog_category_id =", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotEqualTo(Integer value) {
            addCriterion("blog_category_id <>", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThan(Integer value) {
            addCriterion("blog_category_id >", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_category_id >=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThan(Integer value) {
            addCriterion("blog_category_id <", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_category_id <=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIn(List<Integer> values) {
            addCriterion("blog_category_id in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotIn(List<Integer> values) {
            addCriterion("blog_category_id not in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_category_id between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_category_id not between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIsNull() {
            addCriterion("blog_category_name is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIsNotNull() {
            addCriterion("blog_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameEqualTo(String value) {
            addCriterion("blog_category_name =", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotEqualTo(String value) {
            addCriterion("blog_category_name <>", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameGreaterThan(String value) {
            addCriterion("blog_category_name >", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("blog_category_name >=", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLessThan(String value) {
            addCriterion("blog_category_name <", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("blog_category_name <=", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameLike(String value) {
            addCriterion("blog_category_name like", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotLike(String value) {
            addCriterion("blog_category_name not like", value, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameIn(List<String> values) {
            addCriterion("blog_category_name in", values, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotIn(List<String> values) {
            addCriterion("blog_category_name not in", values, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameBetween(String value1, String value2) {
            addCriterion("blog_category_name between", value1, value2, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryNameNotBetween(String value1, String value2) {
            addCriterion("blog_category_name not between", value1, value2, "blogCategoryName");
            return (Criteria) this;
        }

        public Criteria andBlogTagsIsNull() {
            addCriterion("blog_tags is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagsIsNotNull() {
            addCriterion("blog_tags is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagsEqualTo(String value) {
            addCriterion("blog_tags =", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsNotEqualTo(String value) {
            addCriterion("blog_tags <>", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsGreaterThan(String value) {
            addCriterion("blog_tags >", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tags >=", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsLessThan(String value) {
            addCriterion("blog_tags <", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsLessThanOrEqualTo(String value) {
            addCriterion("blog_tags <=", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsLike(String value) {
            addCriterion("blog_tags like", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsNotLike(String value) {
            addCriterion("blog_tags not like", value, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsIn(List<String> values) {
            addCriterion("blog_tags in", values, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsNotIn(List<String> values) {
            addCriterion("blog_tags not in", values, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsBetween(String value1, String value2) {
            addCriterion("blog_tags between", value1, value2, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogTagsNotBetween(String value1, String value2) {
            addCriterion("blog_tags not between", value1, value2, "blogTags");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIsNull() {
            addCriterion("blog_status is null");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIsNotNull() {
            addCriterion("blog_status is not null");
            return (Criteria) this;
        }

        public Criteria andBlogStatusEqualTo(Byte value) {
            addCriterion("blog_status =", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotEqualTo(Byte value) {
            addCriterion("blog_status <>", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusGreaterThan(Byte value) {
            addCriterion("blog_status >", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("blog_status >=", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusLessThan(Byte value) {
            addCriterion("blog_status <", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusLessThanOrEqualTo(Byte value) {
            addCriterion("blog_status <=", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIn(List<Byte> values) {
            addCriterion("blog_status in", values, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotIn(List<Byte> values) {
            addCriterion("blog_status not in", values, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusBetween(Byte value1, Byte value2) {
            addCriterion("blog_status between", value1, value2, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("blog_status not between", value1, value2, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogViewsIsNull() {
            addCriterion("blog_views is null");
            return (Criteria) this;
        }

        public Criteria andBlogViewsIsNotNull() {
            addCriterion("blog_views is not null");
            return (Criteria) this;
        }

        public Criteria andBlogViewsEqualTo(Long value) {
            addCriterion("blog_views =", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsNotEqualTo(Long value) {
            addCriterion("blog_views <>", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsGreaterThan(Long value) {
            addCriterion("blog_views >", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_views >=", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsLessThan(Long value) {
            addCriterion("blog_views <", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsLessThanOrEqualTo(Long value) {
            addCriterion("blog_views <=", value, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsIn(List<Long> values) {
            addCriterion("blog_views in", values, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsNotIn(List<Long> values) {
            addCriterion("blog_views not in", values, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsBetween(Long value1, Long value2) {
            addCriterion("blog_views between", value1, value2, "blogViews");
            return (Criteria) this;
        }

        public Criteria andBlogViewsNotBetween(Long value1, Long value2) {
            addCriterion("blog_views not between", value1, value2, "blogViews");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIsNull() {
            addCriterion("enable_comment is null");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIsNotNull() {
            addCriterion("enable_comment is not null");
            return (Criteria) this;
        }

        public Criteria andEnableCommentEqualTo(Byte value) {
            addCriterion("enable_comment =", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotEqualTo(Byte value) {
            addCriterion("enable_comment <>", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentGreaterThan(Byte value) {
            addCriterion("enable_comment >", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentGreaterThanOrEqualTo(Byte value) {
            addCriterion("enable_comment >=", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentLessThan(Byte value) {
            addCriterion("enable_comment <", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentLessThanOrEqualTo(Byte value) {
            addCriterion("enable_comment <=", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIn(List<Byte> values) {
            addCriterion("enable_comment in", values, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotIn(List<Byte> values) {
            addCriterion("enable_comment not in", values, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentBetween(Byte value1, Byte value2) {
            addCriterion("enable_comment between", value1, value2, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotBetween(Byte value1, Byte value2) {
            addCriterion("enable_comment not between", value1, value2, "enableComment");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}