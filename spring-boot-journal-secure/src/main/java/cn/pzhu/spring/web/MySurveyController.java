package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.SurveyEntity;
import cn.pzhu.spring.repository.SurveyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MySurveyController {

    private static final String VIEW_SURVEY = "mySurveys";
    private static final String VIEW_SURVEY_CREATE = "mySurveyCreate";

    @Autowired
    private SurveyEntityRepository surveyEntityRepository;

    @RequestMapping(value = "/mySurveys", method = RequestMethod.GET)
    public ModelAndView mySurveys(ModelAndView modelAndView) {
        List<SurveyEntity> surveyEntityList = surveyEntityRepository.findAll();
        modelAndView.addObject(VIEW_SURVEY, surveyEntityList);
        return modelAndView;
    }

    @RequestMapping(value = "/mySurveyCreate", method = RequestMethod.GET)
    public ModelAndView mySurveyCreate(ModelAndView modelAndView, @RequestParam("surveyName") String surveyName) {
        if(surveyName==null || "".equals(surveyName.trim())) {
            surveyName = "请输入问卷标题";
        }
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyEntity.setSurveyName(surveyName);
        modelAndView.addObject(VIEW_SURVEY_CREATE);
        return modelAndView;
    }
}
