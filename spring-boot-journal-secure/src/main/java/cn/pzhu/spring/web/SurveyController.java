package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.SurveyEntity;
import cn.pzhu.spring.repository.SurveyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SurveyController {

    private static final String VIEW_SURVEY = "mySurveys";
    private static final String VIEW_SURVEY_CREATE = "mySurveyCreate";

    @Autowired
    private SurveyEntityRepository surveyEntityRepository;

    @GetMapping("surveys")
    public ModelAndView mySurveys(ModelAndView modelAndView, @RequestParam(defaultValue = "0") Integer page) {
        modelAndView.setViewName(VIEW_SURVEY);
        modelAndView.addObject(VIEW_SURVEY, surveyEntityRepository.findAll(PageRequest.of(page, 4)));
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    @GetMapping("mySurveyCreate")
    public ModelAndView mySurveyCreate(ModelAndView modelAndView, @RequestParam("surveyName") String surveyName) {
        if (surveyName == null || "".equals(surveyName.trim())) {
            surveyName = "请输入问卷标题";
        }
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyEntity.setSurveyName(surveyName);
        modelAndView.addObject(VIEW_SURVEY_CREATE);
        return modelAndView;
    }
}
