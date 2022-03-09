package org.example.case3FurkanYabanci.controller;

import lombok.RequiredArgsConstructor;
import org.example.case3FurkanYabanci.dto.CommentDto;
import org.example.case3FurkanYabanci.dto.request.CommentSaveRequestDto;
import org.example.case3FurkanYabanci.generic.dto.RestResponse;
import org.example.case3FurkanYabanci.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity getCommentByUser_Id(@PathVariable long userId){
        List<CommentDto> commentDtoList = commentService.getCommentByUser_Id(userId);
        return ResponseEntity.ok(RestResponse.of(commentDtoList));
    }

    @GetMapping("/byProductId/{productId}")
    public ResponseEntity getCommentByProduct_Id(@PathVariable long productId){
        List<CommentDto> commentDtoList = commentService.getCommentByProduct_Id(productId);
        return ResponseEntity.ok(RestResponse.of(commentDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        CommentDto commentDto = commentService.save(commentSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(commentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        commentService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
