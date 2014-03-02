package com.bsu.project2.web.views;

import com.bsu.project2.exceptions.Project2TechException;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by vildhet on 23.02.14.
 */
public class ErrorView extends ModelAndView {

    public ErrorView(Project2TechException e) {
        super("error");
        super.addObject("errorMessage", e.getMessage());
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String trace = sw.toString();
        super.addObject("trace", trace);
    }

    public ErrorView(String msg) {
        super("error");
        super.addObject("errorMessage", msg);
    }
}
