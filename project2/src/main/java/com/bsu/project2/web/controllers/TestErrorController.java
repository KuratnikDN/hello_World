package com.bsu.project2.web.controllers;

import com.bsu.project2.exceptions.Project2TechException;
import com.bsu.project2.web.views.ErrorView;
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
public class TestErrorController {
    static Logger logger = Logger.getLogger(TestErrorController.class.getName());

    @RequestMapping(value = "/test_error", method = RequestMethod.GET)
    public ModelAndView show(Model model) {
        logger.info("test_error request");

        try {
            errorFunction();
        } catch (Project2TechException e) {
            return new ErrorView(e);
        }

        return new ErrorView("test error controller");
    }

    private void errorFunction() throws Project2TechException {
        throw new Project2TechException("exception in errorFunction");
    }
}

