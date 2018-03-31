package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.SurveyDirectoryEntity;
import cn.pzhu.spring.repository.SurveyDirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@RestController
public class MySurveyController
{
    @Autowired
    private SurveyDirectoryRepository surveyDirectoryRepository;

    @RequestMapping(value = "/mySurveys", method = RequestMethod.GET)
    public ModelAndView mySurveys(ModelAndView modelAndView){
        List<SurveyDirectoryEntity> surveyDirectoryEntityList = surveyDirectoryRepository.findAll();
        modelAndView.addObject("mySurveys", surveyDirectoryEntityList);
        return modelAndView;
    }

}
