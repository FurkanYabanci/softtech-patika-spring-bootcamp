package org.example.case3FurkanYabanci.converter;

import org.example.case3FurkanYabanci.dto.CommentDto;
import org.example.case3FurkanYabanci.dto.request.CommentSaveRequestDto;
import org.example.case3FurkanYabanci.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequestDto commentSaveRequestDto);
    CommentDto convertToCommentDto(Comment comment);
    List<CommentDto> convertToCommentDtoList(List<Comment> commentList);
}
