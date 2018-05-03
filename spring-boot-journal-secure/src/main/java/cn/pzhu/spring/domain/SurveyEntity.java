package cn.pzhu.spring.domain;

import org.hibernate.annotations.Formula;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;


/**
 * 试卷目录及试卷
 *
 * @author keyuan
 * @author Floyd
 * <p>
 * https://github.com/790013438/DWSurvey
 */
@Entity
@Table(name = "surveyEntity")
public class SurveyEntity extends AbstractEntity {

    private String id;
    //回答次数
    private Integer answerNumber;
    // 创建者Id
    private String UserEntity_id;
    //创建时间
    private Date createDate;
    private String htmlPath;
    //用于短链接的ID
    private String sid;
    private String surveyName;
    //试卷下面有多少题目数
    private Integer surveyQuestionNum;
    //试卷状态  0默认设计状态  1执行中 2结束
    private Integer surveyStatus = 0;

    // 表中没有的用户名
    private String userName;

    @Formula("(select o.name from user_entity o where o.id = user_entity_id)")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 表中没有List,QuestionEntity
    private List<QuestionEntity> questions = null;

    @Transient
    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getUserEntity_id() {
        return UserEntity_id;
    }

    public void setUserEntity_id(String userEntity_id) {
        UserEntity_id = userEntity_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Integer getSurveyQuestionNum() {
        return surveyQuestionNum;
    }

    public void setSurveyQuestionNum(Integer surveyQuestionNum) {
        this.surveyQuestionNum = surveyQuestionNum;
    }

    public Integer getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(Integer surveyState) {
        this.surveyStatus = surveyState;
    }
}
