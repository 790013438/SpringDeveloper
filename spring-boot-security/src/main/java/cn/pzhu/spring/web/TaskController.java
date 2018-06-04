package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.TaskEntity;
import cn.pzhu.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {

  private static final String VIEW_ADD_TASK = "views/taskForm";

  @Autowired
  private TaskService taskService;

  @GetMapping("/addTask")
  public ModelAndView taskForm(String email,
      ModelAndView modelAndView,
      HttpSession httpSession) {
    modelAndView.setViewName(VIEW_ADD_TASK);

    httpSession.setAttribute("email", email);
    modelAndView.addObject("task", new TaskEntity());
    return modelAndView;
  }

}
