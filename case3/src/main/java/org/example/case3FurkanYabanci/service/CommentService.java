package org.example.case3FurkanYabanci.service;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.converter.CommentMapper;
import org.example.case3FurkanYabanci.dto.CommentDto;
import org.example.case3FurkanYabanci.dto.request.CommentSaveRequestDto;
import org.example.case3FurkanYabanci.generic.exception.ItemNotFoundException;
import org.example.case3FurkanYabanci.generic.model.BaseAdditionalFields;
import org.example.case3FurkanYabanci.model.Comment;
import org.example.case3FurkanYabanci.model.Product;
import org.example.case3FurkanYabanci.model.User;
import org.example.case3FurkanYabanci.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;

    public CommentDto save(CommentSaveRequestDto commentSaveRequestDto){
        User user = userService.findById(commentSaveRequestDto.getUserId());
        Product product = productService.findById(commentSaveRequestDto.getProductId());
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequestDto);
        setAdditionalFields(comment);
        comment.setUser(user);
        comment.setProduct(product);
        comment = commentRepository.save(comment);
        CommentDto commentDto = CommentMapper.INSTANCE.convertToCommentDto(comment);
        return commentDto;
    }

    public void delete(long id){
        Comment comment = findById(id);
        commentRepository.delete(comment);
    }

    public List<CommentDto> getCommentByUser_Id(long userId){
        User user = userService.findById(userId);
        List<Comment> commentList = commentRepository.getCommentByUser_Id(userId);
        if (commentList.isEmpty()){
            throw new ItemNotFoundException(user.getName() + " isimli kullanıcı henüz bir yorum yazmamıştır");
        }
        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToCommentDtoList(commentList);
        return commentDtoList;
    }

    public List<CommentDto> getCommentByProduct_Id(long productId){
        Product product = productService.findById(productId);
        List<Comment> commentList = commentRepository.getCommentByProduct_Id(productId);
        if (commentList.isEmpty()){
            throw new ItemNotFoundException(product.getName() + " isimli ürüne henüz bir yorum yazılmamıştır");
        }
        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToCommentDtoList(commentList);
        return commentDtoList;
    }

    protected Comment findById(long id){
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Comment Not Found!"));
        return comment;
    }

    private void setAdditionalFields(Comment comment){
        BaseAdditionalFields baseAdditionalFields = new BaseAdditionalFields();
        baseAdditionalFields.setUpdateDate(new Date());
        if (baseAdditionalFields.getCreateDate() == null){
            baseAdditionalFields.setCreateDate(new Date());
            comment.setBaseAdditionalFields(baseAdditionalFields);
        }
    }

}
