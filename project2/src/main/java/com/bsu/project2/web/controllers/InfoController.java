package com.bsu.project2.web.controllers;

import com.bsu.project2.system.SystemInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vildhet on 23.02.14.
 */
@Controller
public class InfoController {
    static Logger logger = Logger.getLogger(InfoController.class.getName());

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView show(Model model) {
        logger.info("info request");
        ModelAndView mview = new ModelAndView("info");
        mview.addObject("infoMap", SystemInfo.getInfoMap());
        return mview;
    }
}
