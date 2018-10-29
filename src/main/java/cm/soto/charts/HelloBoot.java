package cm.soto.charts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloBoot {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/first",method = RequestMethod.GET)
    public ModelAndView firstDemo(){
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/course_clickcount",method = RequestMethod.GET)
    public ModelAndView courseClickCountStat(){
        return new ModelAndView("demo");
    }

}
