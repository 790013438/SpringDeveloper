package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.CommentEntity;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.repository.CommentEntityRepository;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CommentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private JSONObject failJSONObject;

    private static final String VIEW_COMMENT = "comment";
    @Autowired
    private CommentEntityRepository commentEntityRepository;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    @Autowired
    private Sort idASCSort;

    @GetMapping("/deleteComment")
    public ModelAndView delete(ModelAndView modelAndView,
                               @RequestParam(value = "id") String id) {
        modelAndView.setViewName("redirect:/admin/comments");
        commentEntityRepository.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/comment")
    public ModelAndView comment(ModelAndView modelAndView, CommentEntity commentEntity,
                                @RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "6") Integer size) {
        // 获取当前用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        if ("anonymousUser".equals(name)) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        AccountEntity accountEntity = accountEntityRepository.findAccountEntitiesByAccountName(name);
        commentEntity.setUserEntityId(accountEntity.getUserEntityId());

        modelAndView.addObject("commentEntity", commentEntity);
        modelAndView.setViewName(VIEW_COMMENT);

        modelAndView.addObject("comments", commentEntityRepository.findAllByOrderByCreatedDate(PageRequest.of(page, size, idASCSort)));
        return modelAndView;
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "comment")
    @ResponseBody
    public JSONObject comment(@Valid CommentEntity commentEntity) {

        if (StringUtils.isBlank(commentEntity.getContent())) {
            failJSONObject.put("msg", "请输入完整后评论");
            failJSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            return failJSONObject;
        }

        if (commentEntity.getContent().length() > 400) {
            failJSONObject.put("msg", "请输入400个字符以内的评论");
            failJSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            return failJSONObject;
        }

        try {
            commentEntityRepository.save(commentEntity);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success", true);
            failJSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            return jsonObject;
        } catch (Exception e) {
            String msg = "评论发布失败";
            LOGGER.error(msg, e);
            failJSONObject.put("msg", msg);
            failJSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            return failJSONObject;
        }
    }
}
