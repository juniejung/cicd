package demo.practice.cicd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public Memo createMemo(String title, String content){
        return memoRepository.save(Memo.builder()
                .title(title)
                .content(content)
                .build());
    }

    public Memo findById(Long id){
        return memoRepository.findById(id).get();
    }

    public List<Memo> findAll(){
        return memoRepository.findAll();
    }
}
