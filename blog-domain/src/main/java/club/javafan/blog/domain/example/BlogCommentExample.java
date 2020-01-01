package club.javafan.blog.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCommentExample() {
        oredCriteria = new ArrayList<>();
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
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

        public Criteria andCommentatorIsNull() {
            addCriterion("commentator is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNotNull() {
            addCriterion("commentator is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEqualTo(String value) {
            addCriterion("commentator =", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotEqualTo(String value) {
            addCriterion("commentator <>", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThan(String value) {
            addCriterion("commentator >", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThanOrEqualTo(String value) {
            addCriterion("commentator >=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThan(String value) {
            addCriterion("commentator <", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThanOrEqualTo(String value) {
            addCriterion("commentator <=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLike(String value) {
            addCriterion("commentator like", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotLike(String value) {
            addCriterion("commentator not like", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorIn(List<String> values) {
            addCriterion("commentator in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotIn(List<String> values) {
            addCriterion("commentator not in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorBetween(String value1, String value2) {
            addCriterion("commentator between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotBetween(String value1, String value2) {
            addCriterion("commentator not between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIsNull() {
            addCriterion("website_url is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIsNotNull() {
            addCriterion("website_url is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlEqualTo(String value) {
            addCriterion("website_url =", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotEqualTo(String value) {
            addCriterion("website_url <>", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlGreaterThan(String value) {
            addCriterion("website_url >", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("website_url >=", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLessThan(String value) {
            addCriterion("website_url <", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLessThanOrEqualTo(String value) {
            addCriterion("website_url <=", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLike(String value) {
            addCriterion("website_url like", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotLike(String value) {
            addCriterion("website_url not like", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIn(List<String> values) {
            addCriterion("website_url in", values, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotIn(List<String> values) {
            addCriterion("website_url not in", values, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlBetween(String value1, String value2) {
            addCriterion("website_url between", value1, value2, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotBetween(String value1, String value2) {
            addCriterion("website_url not between", value1, value2, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIsNull() {
            addCriterion("comment_body is null");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIsNotNull() {
            addCriterion("comment_body is not null");
            return (Criteria) this;
        }

        public Criteria andCommentBodyEqualTo(String value) {
            addCriterion("comment_body =", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotEqualTo(String value) {
            addCriterion("comment_body <>", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyGreaterThan(String value) {
            addCriterion("comment_body >", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyGreaterThanOrEqualTo(String value) {
            addCriterion("comment_body >=", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLessThan(String value) {
            addCriterion("comment_body <", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLessThanOrEqualTo(String value) {
            addCriterion("comment_body <=", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyLike(String value) {
            addCriterion("comment_body like", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotLike(String value) {
            addCriterion("comment_body not like", value, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyIn(List<String> values) {
            addCriterion("comment_body in", values, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotIn(List<String> values) {
            addCriterion("comment_body not in", values, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyBetween(String value1, String value2) {
            addCriterion("comment_body between", value1, value2, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentBodyNotBetween(String value1, String value2) {
            addCriterion("comment_body not between", value1, value2, "commentBody");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNull() {
            addCriterion("comment_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNotNull() {
            addCriterion("comment_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeEqualTo(Date value) {
            addCriterion("comment_create_time =", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotEqualTo(Date value) {
            addCriterion("comment_create_time <>", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThan(Date value) {
            addCriterion("comment_create_time >", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_create_time >=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThan(Date value) {
            addCriterion("comment_create_time <", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_create_time <=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIn(List<Date> values) {
            addCriterion("comment_create_time in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotIn(List<Date> values) {
            addCriterion("comment_create_time not in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("comment_create_time between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_create_time not between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpIsNull() {
            addCriterion("commentator_ip is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpIsNotNull() {
            addCriterion("commentator_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpEqualTo(String value) {
            addCriterion("commentator_ip =", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpNotEqualTo(String value) {
            addCriterion("commentator_ip <>", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpGreaterThan(String value) {
            addCriterion("commentator_ip >", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_ip >=", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpLessThan(String value) {
            addCriterion("commentator_ip <", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpLessThanOrEqualTo(String value) {
            addCriterion("commentator_ip <=", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpLike(String value) {
            addCriterion("commentator_ip like", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpNotLike(String value) {
            addCriterion("commentator_ip not like", value, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpIn(List<String> values) {
            addCriterion("commentator_ip in", values, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpNotIn(List<String> values) {
            addCriterion("commentator_ip not in", values, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpBetween(String value1, String value2) {
            addCriterion("commentator_ip between", value1, value2, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andCommentatorIpNotBetween(String value1, String value2) {
            addCriterion("commentator_ip not between", value1, value2, "commentatorIp");
            return (Criteria) this;
        }

        public Criteria andReplyBodyIsNull() {
            addCriterion("reply_body is null");
            return (Criteria) this;
        }

        public Criteria andReplyBodyIsNotNull() {
            addCriterion("reply_body is not null");
            return (Criteria) this;
        }

        public Criteria andReplyBodyEqualTo(String value) {
            addCriterion("reply_body =", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyNotEqualTo(String value) {
            addCriterion("reply_body <>", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyGreaterThan(String value) {
            addCriterion("reply_body >", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyGreaterThanOrEqualTo(String value) {
            addCriterion("reply_body >=", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyLessThan(String value) {
            addCriterion("reply_body <", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyLessThanOrEqualTo(String value) {
            addCriterion("reply_body <=", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyLike(String value) {
            addCriterion("reply_body like", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyNotLike(String value) {
            addCriterion("reply_body not like", value, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyIn(List<String> values) {
            addCriterion("reply_body in", values, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyNotIn(List<String> values) {
            addCriterion("reply_body not in", values, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyBetween(String value1, String value2) {
            addCriterion("reply_body between", value1, value2, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyBodyNotBetween(String value1, String value2) {
            addCriterion("reply_body not between", value1, value2, "replyBody");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeIsNull() {
            addCriterion("reply_create_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeIsNotNull() {
            addCriterion("reply_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeEqualTo(Date value) {
            addCriterion("reply_create_time =", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeNotEqualTo(Date value) {
            addCriterion("reply_create_time <>", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeGreaterThan(Date value) {
            addCriterion("reply_create_time >", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_create_time >=", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeLessThan(Date value) {
            addCriterion("reply_create_time <", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_create_time <=", value, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeIn(List<Date> values) {
            addCriterion("reply_create_time in", values, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeNotIn(List<Date> values) {
            addCriterion("reply_create_time not in", values, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeBetween(Date value1, Date value2) {
            addCriterion("reply_create_time between", value1, value2, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andReplyCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_create_time not between", value1, value2, "replyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Byte value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Byte value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Byte value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Byte value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Byte> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Byte> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Byte value1, Byte value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
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