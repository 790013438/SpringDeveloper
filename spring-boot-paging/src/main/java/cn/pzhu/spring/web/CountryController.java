package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.Country;
import cn.pzhu.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {

    private final static String VIEW_INDEX = "index";

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/")
    public ModelAndView showPage(ModelAndView modelAndView, @RequestParam(defaultValue = "0")Integer page) {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("data", countryRepository.findAll(PageRequest.of(page, 4)));
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Country country) {
        countryRepository.save(country);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Integer country) {
        countryRepository.deleteById(country);

        return "redirect:/";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Country findOne(Integer country) {
        return countryRepository.findById(country)
                .orElse(null);
    }
}
