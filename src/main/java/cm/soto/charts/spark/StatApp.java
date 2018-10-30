package cm.soto.charts.spark;

import cm.soto.charts.dao.CourseClickCountDAO;
import cm.soto.charts.domain.CourseClickCount;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * web层
 */

@RestController
public class StatApp {
    private static Map<String, String> course = new HashMap<>();
    static {
        course.put("112","Spark SQL 慕课网日志分析");
        course.put("128","10小时入门大数据");
        course.put("145","尝试学习之神经网络核心原理与算法");
        course.put("146","强大的Node.js在Web开发的应用");
        course.put("131","Vue+Django实战");
        course.put("130","web前端性能优化");
    }

    @Autowired
    CourseClickCountDAO courseClickCountDAO;

    @RequestMapping(value = "/course_clickcount_dynamic", method = RequestMethod.POST)
    @ResponseBody
    public List<CourseClickCount> courseClickCount() throws Exception {
        ModelAndView view = new ModelAndView("index");

        List<CourseClickCount> list = courseClickCountDAO.query("20181029");


        for (CourseClickCount model : list) {
            model.setName(course.get(model.getName().substring(9)));
        }

        return list;
    }
//    @RequestMapping(value="/course_clickcount_dynamic",method = RequestMethod.GET)
//    public ModelAndView courseClickCount() throws Exception {
//        ModelAndView view = new ModelAndView("index");
//
//        List<CourseClickCount> list = courseClickCountDAO.query("20181029");
//
//
//        for (CourseClickCount model : list) {
//            model.setName(course.get(model.getName().substring(9)));
//        }
//        JSONArray json = JSONArray.fromObject(list);
//
//        view.addObject("data_json", json);
//
//        return view;
//    }

    @RequestMapping(value = "/echarts", method = RequestMethod.GET)
    public ModelAndView echarts() {

        return new ModelAndView("echarts");

    }
}
