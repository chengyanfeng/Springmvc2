package SpringMVC.cheng;

import SpringMVC.feng.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
//value 是想放到session中的对象的key，就是请求域中的map中的key值。
    //tpye是放入到请求域中的string类型
@SessionAttributes(value = "car",types = String.class)
@Controller
@RequestMapping("/springmvc")
public class HellWorld {
    /**
     * 1
     *  1.requestMapping可以修饰方
     *  2.requestMapping可以修饰类
     */

    @RequestMapping("/helloWorld")
    public String hello(){

        System.out.print("success");
        return "success";
    }

    /*
    2.requestMapping
    method:属性来指定请求方法
    params:表示必须有这个参数 params = {"username","age!=10"} 必须是有两个参数，并且age必须不能等于10
    heads:请求头必须包含什么
    headers = { "Accept-Language=en-US,zh;q=0.8" }
     */
    @RequestMapping(value="/reqeustMappingMethod",method = RequestMethod.GET,params = {"username","age!=10"}
  )
    public String testruqesutMappingValue(){
        System.out.print("2.success");
        return "success";
    }


    /*
    3.requestMapping 通配符。
     *。代表通配符，访问的时候中间可以有任意字符。
     */
    @RequestMapping(value="/reqeustMappingMethod/*/abc")
    public String MappingValuetongpeofi(){
        System.out.print("2.success");
        return "success";
    }

    /*
    4.占位符
    @PathVariable("id")是必须与上面的传递的占位符名字一样。才能传递过来
     */
    @RequestMapping(value = "/PathVariable/{id}")
    public String PathVariable(@PathVariable("id") Integer id){
        System.out.print(id);
        return "success";
    }

    /*
  5.RESTful风格的四种方法
  @PathVariable("id")是必须与上面的传递的占位符名字一样。才能传递过来
   */
    @RequestMapping(value = "/restful/{id}",method = RequestMethod.GET)
    public String restfulget(@PathVariable("id") Integer id){
        System.out.print(id+"get");
        return "success";
    }
    @RequestMapping(value = "/restful",method = RequestMethod.POST)
    public String restfulpost(){
        System.out.print("post");
        return "success";
    }
    @RequestMapping(value = "/restful/{id}",method = RequestMethod.DELETE)
    public String restfulDELECT(@PathVariable("id") Integer id){
        System.out.print(id+"delect");
        return "success";
    }
    @RequestMapping(value = "/restful/{id}",method = RequestMethod.PUT)
    public String restfulPUT(@PathVariable("id") Integer id){
        System.out.print("这是put"+id);
        return "success";
    }
/**
 * 6.reqeustparam
 * 是以get方法过来的参数，required该参数是否必须。
 * defautlvalue请求参数默认值。
 */
    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam(value = "username",required = false,defaultValue="j")String username){
        System.out.print(username);
        return "success";
    }
    /**
     * 7.CookieValue和header
     * 是以get方法过来的参数，required该参数是否必须。
     * defautlvalue请求参数默认值。
     */
    @RequestMapping("/CookieValue")
    public String CookieValueAndHeader(@CookieValue("Jdsession") String jd){

        return "success";
    }

    /**
     * 8.pojo
     * 是以post方法来直接通过表单来传送一个实体类，传过来的属性直接注入到实体类中。
     * defautlvalue请求参数默认值。
     */
    @RequestMapping(value = "/inPoJo",method = RequestMethod.POST)
    public String inPOJO(Car car){
        System.out.print(car.toString());
        return "success";
    }

    /**
     * 9.ModelAndView这个通过加入的sucess来把页面转换成视图对象
     * 加入对象中属性，相当于把属性值直接放到视图中。
     * 是以get方法过来的参数，required该参数是否必须。
     *
     */
    @RequestMapping(value = "/ModeAndView/{id}",method = RequestMethod.GET)
    public ModelAndView ModeAndView(@PathVariable("id")Integer id){
        ModelAndView modelAndView=new ModelAndView("success");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    /**
     * 10.map必须要放到传参的函数里，这样的map会直接放到域中。
     * 方法里新建的map不行，必须是参数里的map,、     *
     * 因为只有在参数里才是把map放到请求域中。
     *
     *
     */

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    public String map(Map<String,Object> map){


        map.put("name", "testmap");
        System.out.print(map.toString());
        return "success";
    }
    /**
     * 11.sessionAttribute
     *value 把请求域中的对象放到session域中
     *
     *
     */
    @RequestMapping(value="/SessionAttrbute",method = RequestMethod.POST)
    public String getSessionAttrrabuite(Map<String,Object> map){

    map.put("c","adfa");
System.out.print(map.toString());
    return "success";
    }
    /**
     * 12.ModelAttribute
     * 这个注解标示的方法是所有的请求来到后，优先找的。第一就找的方法，然后再找sessionAttribute
     *
     *
     *
     */
    @RequestMapping(value="/ModelAttribute",method = RequestMethod.POST)
    public String getModelAttribute(Car car){

            System.out.print(car.toString());

        return "success";
    }
    /**
     * 12.@ModelAttribute必须有，不然，sessionAttribute会报错
     * 这个方法必须优先执行的，任何方法都先经过这个方法执行。这个是实体类注入，和更新的方法。
     * 这个优先于sessionAttribute执行。如果没有这个，但是有sessionAttribute，那么会报错。
     *
     *
     */
    @ModelAttribute
    public String getModelAttributeCar(String name,Map<String,Object> map){
Car car=new Car(1,name);
        map.put("name",name);
        map.put("car",car);
        System.out.print(map.toString());
        return "success";
    }

    /**
     * 13.Redirect 重定向
     * 直接转发到某个页面
     *
     */
    @RequestMapping("/testRedirect")
    public String Redirect(){
        System.out.print("13.重定向");
        return "redirect:/index.jsp";
    }
    /**
     * 14.表单标签，form 标签
     * modelAttribute 只要有form 标签，必须有modelAttribute
     * 然后我们在handle里必须像域中添加跟modelAttribute属性一样的名字。
     */
    @RequestMapping("/formbiaodan")
    public  String formbiadan(Map<String,Object> map){
    map.put("company", new Car(2, "ce"));

        return "success";
    }
    /**
     * 15.初始化绑定
     * 忽略传递过来的值的参数的值
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields("lastName");
    }
    @ResponseBody
    @RequestMapping(value = "/ResponseBody",method =RequestMethod.POST)
    public List<Car> ResponseBody(){
        Car car=new Car(1,"baoma");
        Car car1=new Car(2,"benchi");
        List<Car> list=new ArrayList<>();
        list.add(car);
        list.add(car1);
        return list;
    }
}
