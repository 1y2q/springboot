package com.itheima.Conlicr;
import com.itheima.Conlicr.sss.R;

import com.itheima.domain.Book;
import com.itheima.sever.boo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class Do {
    private static final Logger logger = LoggerFactory.getLogger(Do.class);

    @Autowired
    private boo bookServiceimpl;

    @GetMapping
    public R getAllBook(){
        List<Book> books = bookServiceimpl.list();
        logger.info("查询到的书籍数量: {}", books.size());
        for (Book book : books) {
            logger.info("书籍信息: {}", book);
        }
        return new R(true, books);
    }



    /* @Autowired
    private boo bookServiceimpl;
    @GetMapping
    public R getAllBook(){

        return new R(true,bookServiceimpl.list());
    }*/
    @GetMapping("{id}")
    public  R getBookById(@PathVariable int id) {

        return new R(true,bookServiceimpl.getById(id));
    }
    @PostMapping
    public R saveBook(@RequestBody Book book){

        return new R(bookServiceimpl.save(book));

    }

}