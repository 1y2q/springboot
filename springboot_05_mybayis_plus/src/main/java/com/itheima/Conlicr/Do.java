package com.itheima.Conlicr;
import com.itheima.Conlicr.sss.R;

import com.itheima.domain.Book;
import com.itheima.sever.boo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class Do {
    @Autowired
    private boo bookServiceimpl;
    @GetMapping
    public R getAllBook(){
        return new R(true,bookServiceimpl.list());
    }
    @GetMapping("{id}")
    public  R getBookById(@PathVariable int id) {
        return new R(true,bookServiceimpl.getById(id));
    }
    @PostMapping
    public R saveBook(@RequestBody Book book){
        return new R(bookServiceimpl.save(book));
    }

}