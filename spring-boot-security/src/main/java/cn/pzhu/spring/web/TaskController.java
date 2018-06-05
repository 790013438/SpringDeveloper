package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.TaskEntity;
import cn.pzhu.spring.service.TaskService;
import cn.pzhu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

  private static final String VIEW_ADD_TASK = "views/taskForm";

  @Autowired
  private TaskService taskService;
  @Autowired
  private UserService userService;

  @GetMapping("/addTask")
  public ModelAndView taskForm(String email,
                               ModelAndView modelAndView,
                               HttpSession httpSession) {
    modelAndView.setViewName(VIEW_ADD_TASK);

    httpSession.setAttribute("email", email);
    modelAndView.addObject("taskEntity", new TaskEntity());
    return modelAndView;
  }

  @PostMapping("/addTask")
  public ModelAndView addTask(ModelAndView modelAndView,
                              @Valid TaskEntity taskEntity,
                              BindingResult bindingResult,
                              HttpSession httpSession) {

    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("views/taskForm");
      return modelAndView;
    }

    String email = (String) httpSession.getAttribute("email");
    taskService.addTask(taskEntity, userService.findOne(email));

    modelAndView.setViewName("redirect:users");
    return modelAndView;
  }
}
