package com.ohgiraffers.mapping.section03.compositekey.subsction01.embeddedid;

import com.ohgiraffers.mapping.section02.embedded.Book;
import com.ohgiraffers.mapping.section02.embedded.BookRegistDTO;
import com.ohgiraffers.mapping.section02.embedded.Price;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeBookService {

    private LikeRepository likeRepository;

    public LikeBookService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void generateLikeBook(LikeDTO likeDTO) {

        Like like = new Like(
                new LikeCompositeKey(
                        likeDTO.getLikedMemberNo(),
                        likeDTO.getLikedBookNo()
                )
        );

        likeRepository.save(like);
    }
}
