package com.bsu.project2.web.controllers;

import com.bsu.project2.buzztalk.BuzzTalk;
import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.database.DataBase;
import com.bsu.project2.exceptions.Project2TechException;
import com.bsu.project2.registry.Registry;
import com.bsu.project2.web.views.ErrorView;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    static Logger logger = Logger.getLogger(MainController.class.getName());

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView show(Model model) {
        logger.info("main request");

        BuzzTalkData buzzTalkData = null;
        try {
            buzzTalkData = new BuzzTalk().getData();
        } catch (Project2TechException e) {
            return new ErrorView(e);
        }

        DataBase db = Registry.getBase();
        db.save(buzzTalkData);

        ModelAndView mview = new ModelAndView("main");
        mview.addObject("tags", db.getAllTags());
        return mview;
    }
}
