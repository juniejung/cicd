package demo.practice.cicd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("list")
    public String list(Model model){

        List<Memo> memos = memoService.findAll();
        model.addAttribute("memos", memos);

        return "list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id")Long id){
        Memo memo = memoService.findById(id);
        model.addAttribute("memo", memo);
        return "detail";
    }

    @PostMapping("/posting")
    public String posting(@RequestParam("title") String title, @RequestParam("content") String content){
        memoService.createMemo(title, content);
        return "redirect:/";
    }


}
