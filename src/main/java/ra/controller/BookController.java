package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Book;
import ra.service.BookService;

import java.util.List;

@Controller
//Map controller với đường dẫn request URL
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private BookService bookService;
    //@RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @GetMapping("/findAll")
    public ModelAndView getAllBook(){
        ModelAndView mav = new ModelAndView("books");
        List<Book> listBook = bookService.findAll();
        //add dữ liệu vào mav để chuyển sang books.jsp hiển thị
        mav.addObject("listBook",listBook);
        return mav;
    }
    @GetMapping("/initCreate")
    public String initCreate(ModelMap modelMap){
        //Khởi tạo 1 đối tượng Book để map lên form cho người dùng nhập dữ liệu
        Book bookNew = new Book();
        //add đối tượng thêm mới vào ModelMap để chuyển sang trang jsp
        modelMap.addAttribute("bookNew",bookNew);
        return "newBook";
    }
    @PostMapping("/create")
    public String createBook(Book bookNew){
        boolean result = bookService.save(bookNew);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public String initUpdate(ModelMap modelMap,int bookId){
        Book bookUpdate = bookService.findById(bookId);
        modelMap.addAttribute("bookUpdate",bookUpdate);
        return "updateBook";
    }
    @PostMapping("/update")
    public String updateBook(Book bookUpdate){
        boolean result = bookService.update(bookUpdate);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }
    @GetMapping("/delete")
    public String deleteBook(int bookId){
        boolean result = bookService.delete(bookId);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }
}
