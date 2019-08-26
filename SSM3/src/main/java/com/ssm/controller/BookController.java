package com.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;


import com.ssm.beans.BookCustom;
import com.ssm.beans.BookQueryVo;
import com.ssm.exception.CustomException;
import com.ssm.service.BookService;


import com.ssm.validation.validationGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 商品的controller
 * @author Administrator
 *
 * 1.RequestMapping特性：
 * 		url映射、 窄化请求映射 、限制http请求方法
 *
 * 2.Controller返回值：modelandview（结束方法时，定义modelandview，分别设置model和view） 、
 * 		string（表示返回逻辑视图名，真正视图（jsp路径）=前缀+逻辑视图名+后缀） 、
 * 		void
 *3.springmvc参数绑定：
 * 		从客户端传入key /value数据，经过参数绑定，最终将数据绑定到controller方法的形参上，在springmvc中，
 * 		接收页面提交数据是通过方法形参，而不是在controller中定义成员变量
 * 		默认支持类型(直接在controller形参定义下边类型就可以使用)：
 * 			HttpServletRequest
 * 			HttpServletResponse
 * 			HttpSession
 * 			Model/ModelMap:Model是接口，ModelMap是接口实现,作用将模型数据填充到request域
 * 			简单类型
 * 4.@RequestParam可以对简单类型参数进行绑定，若不使用这个注解，则要求request传入的参数名和controller的形参一致方可绑定
 * 		若使用，则不要求request传入的参数名和controller的形参一亦可绑定
 * 5.pojo绑定
 * 		要求：页面input中的name和controller中pojo属性名一致
 * 		post乱码：web.xml 添加filter
 * 		get乱码：修改Tomcat配置
 * 6.日期参数绑定：
 * 		对于形参中pojo对象，若里面属性有日期类型，要自定义参数绑定，要转换的日期类型要和pojo中日期属性类型保持一致
 * 		需要向处理器适配器中注入自定义参数绑定组件
 * 7.包装类型的pojo绑定
 *      <input name="bookCustom.bname">
 * 8.异常处理：
 *      若与业务功能相关的异常，建议在service中抛出
 *      与业务无关的异常，建议在controller中抛出
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问的是根路径+子路径
@RequestMapping("/book")
public class BookController  {

	@Autowired
	private BookService bookService;

	/**
	 * 注解的映射器注解的适配器必须配对使用
	 * @return
	 * @throws Exception
	 */

	//商品查询列表
	//@RequestMapping实现queryItems方法和url进行映射，一个方法对应一个url，.action可加可不加
        @RequestMapping("/queryItems")//一般将url和方法名写成一样
        public ModelAndView queryItems(HttpServletRequest request, BookQueryVo bookQueryVo) throws Exception{
        //测试forward后request共享
		//System.out.println(request.getParameter("bid"));

		List<BookCustom> bl = bookService.findBookList(bookQueryVo);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request.setAttribute
		modelAndView.addObject("bookList", bl);
		//指定视图
		modelAndView.setViewName("book/list");
		
		return modelAndView;
		
	}
	//商品修改页面展示
	//@RequestMapping("/editBook")
	//限制http请求方法,可以post和get
//	@RequestMapping(value="/editBook",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editBook() throws Exception{
//		//调用service根据商品id查询商品信息
//		BookCustom  bookCustom =bookService.findBookById("1");
//		//返回modelandview
//		ModelAndView modelAndView = new ModelAndView();
//		//将商品信息放到model
//		modelAndView.addObject("bookCustom", bookCustom);
//
//		modelAndView.setViewName("book/desc");
//
//		return modelAndView;
//	}

	//演示string
	@RequestMapping(value="/editBook",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam的value里面指定request传入参数名称和形参进行绑定，
    //required可以指定参数是否必须要传入(不传入会报Required String parameter 'bid' is not present)
	//defaultValue可以设置默认值，若id没有传入则和默认值绑定
	public String editBook(ModelMap modelMap,@RequestParam(value = "bid",required =true) String bbid) throws Exception{
		//调用service根据商品id查询商品信息
		BookCustom  bookCustom =bookService.findBookById(bbid);

		//通过形参中的model传数据给页面
		modelMap.addAttribute("items", bookCustom);
		return "book/desc";
	}

	//RESTful风格示例
	//查出商品信息，输出json
    @RequestMapping("/bookView/{bid}")
    ///bookView/{bid}里的bid表示将这个位置参数传到PathVariable指定名称中
    public @ResponseBody BookCustom bookView(@PathVariable("bid") String bid) throws Exception{
        BookCustom bookCustom = bookService.findBookById(bid);
        return bookCustom;
    }

	//修改信息提交
	@RequestMapping("/editBookSubmit")
    //在需要校验的pojo前添加@Validated注解，在需要校验的pojo后面添加BindingResult来接受错误信息
	//@Validated BindingResult是配对出现的，且顺序是固定的，(value = validationGroup1.class)指定使用哪个分组
    //ModelAttribute可以指定pojo回显到request中的key
	public String editBookSubmit(Model model, HttpServletRequest request, String bid,
                                 @ModelAttribute("items") @Validated(value = validationGroup1.class) BookCustom bookCustom,
                                 BindingResult bindingResult, MultipartFile img //接受图片
                                 ) throws Exception{
            //获取错误信息
            if(bindingResult.hasErrors()){
                //输出错误信息
                List<ObjectError> allErrors = bindingResult.getAllErrors();
                for (ObjectError objectError : allErrors) {
                    System.out.println(objectError.getDefaultMessage());
                }
                model.addAttribute("allErrors",allErrors);
                //可以直接通过model将pojo回显到页面,不使用@ModelAttribute，简单数据类型只能用model
                model.addAttribute("items",bookCustom);
                return "book/desc";
            }
            //图片原始名称
            String fileName = img.getOriginalFilename();
            //上传图片
            if(img != null && fileName !=null && fileName.length()>0 && fileName.trim()!=""){
                //存储图片的真实路径
                String path = "D:\\Temp\\fileupload\\images\\";

                //新的图片名
                String saveName = UUID.randomUUID().toString().replace("-", "").toUpperCase()+
                        fileName.substring(fileName.lastIndexOf("."));
                File file = new File(path,saveName);
                //将内存的数据写入磁盘
                img.transferTo(file);
                bookCustom.setImage(saveName);
            }

            //页面需将商品信息传到此方法
            bookService.updateBook(bid,bookCustom);

    //		ModelAndView modelAndView = new ModelAndView();
    //
    //		//暂时返回成功页面
    //		modelAndView.setViewName("msg");

            //重定向 ：地址栏改变，request不共享
            //return "redirect:queryItems.action";
            //转发： 地址栏不变，request共享
            //return "forward:queryItems.action";
            return "book/msg";
	}

	//批量删除
	@RequestMapping("/deleteBook")
	public String deleteBook (String[] book_id) throws Exception{
        //调用service批量删除商品




        return "book/msg";

    }
	
	
	//批量修改商品页面
    @RequestMapping("/editBookQuery")//一般将url和方法名写成一样
    public ModelAndView editBookQuery(HttpServletRequest request, BookQueryVo bookQueryVo) throws Exception{

        List<BookCustom> bl = bookService.findBookList(bookQueryVo);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request.setAttribute
        modelAndView.addObject("bookList", bl);
        //指定视图
        modelAndView.setViewName("book/editBookQuery");

        return modelAndView;

    }

    //批量修改商品的提交
    //通过BookQueryVo接受批量提交商品的信息，存储到里面的list属性中
    @RequestMapping("/editBookAllSubmit")
    public String editBookAllSubmit(BookQueryVo bookQueryVo) throws Exception{

        return "book/msg";

    }
	
	
	
	
	
	
}
